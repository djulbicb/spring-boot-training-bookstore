package com.training.curator.watcher;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.TreeCache;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class Watcher {
    String connectionInfo = "127.0.0.1:2181";
    String ZK_PATH = "/someapp/somemodule";

    public Watcher() throws Exception {
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

//        PathChildrenCache watcher = new PathChildrenCache(
//                client, ZK_PATH, true    // if cache data
//        );

        TreeCache watcher = new TreeCache(client, ZK_PATH);

        watcher.getListenable().addListener((client1, event) -> {
            ChildData data = event.getData();
            if (data == null) {
                System.out.println("No data in event[" + event + "]");
            } else {
                System.out.println("Receive event: "
                        + "type=[" + event.getType() + "]"
                        + ", path=[" + data.getPath() + "]"
                        + ", data=[" + new String(data.getData()) + "]"
                        + ", stat=[" + data.getStat() + "]");

                String s = new String(data.getData(), StandardCharsets.UTF_8);
                System.out.println(s);
            }
        });
        watcher.start();
//        watcher.start(PathChildrenCache.StartMode.NORMAL);
        System.out.println("Register zk watcher successfully!");
    }
}
