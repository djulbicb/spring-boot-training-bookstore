package com.training.bookstore.config.context.spec;

import com.training.bookstore.client.StorageFilesClient;
import com.training.bookstore.sites.SiteConfig;
import com.training.bookstore.sites.SiteConfigConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Service
public class SiteSpecService {

    @Autowired
    StorageFilesClient client;

    @Autowired
    public SiteSpecService(StorageFilesClient client) {
        System.out.println("SERVICE");
        this.client = client;
    }

    public SiteSpec create(HttpServletRequest request) {
        SiteConfigConsumer consumer = new SiteConfigConsumer(Arrays.asList(client.getSiteConfigs()));
        SiteConfig config = consumer.getByServerName(request.getServerName());

        return new SiteSpec(config);
    }
}
