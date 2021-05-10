package com.training.curator.producer;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.System.out;

@Service
public class Producer {
    String connectionInfo = "127.0.0.1:2181";
    String ZK_PATH = "/someapp/somemodule/someroute/test";

    public Producer() throws Exception {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client =
                CuratorFrameworkFactory.builder()
                        .connectString(connectionInfo)
                        .sessionTimeoutMs(5000)
                        .connectionTimeoutMs(5000)
                        .retryPolicy(retryPolicy)
                        .namespace("base")
                        .build();
        client.start();

        Stat stat1 = client.checkExists().creatingParentContainersIfNeeded().forPath(ZK_PATH);
        if (stat1 == null) {
            client.create().forPath(ZK_PATH, "sometdata".getBytes());
        }

        CompletableFuture.runAsync(() -> {
            CuratorWatcher curatorWatcher = event -> System.out.println("Watched event: " + event);

            try {
                client.getChildren().usingWatcher(curatorWatcher).forPath(ZK_PATH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });



        byte[] bytes = client.getData().forPath(ZK_PATH);
        out.println(new String(bytes, StandardCharsets.UTF_8));

        final AtomicInteger i = new AtomicInteger(0);

        ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
        exec.scheduleAtFixedRate(new Runnable(){
            @Override
            public void run(){
                i.set(i.get()+1);
                System.out.println(i);
                try {
                    client.setData().forPath(ZK_PATH, ("init_" + i ).getBytes());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 500, TimeUnit.MILLISECONDS);
    }
}
