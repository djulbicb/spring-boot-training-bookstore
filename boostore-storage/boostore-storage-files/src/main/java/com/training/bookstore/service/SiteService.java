package com.training.bookstore.service;

import com.training.bookstore.sites.SiteConfig;
import com.training.bookstore.sites.SiteConfigConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SiteService {

    private final SiteConfigConsumer consumer;

    @Autowired
    public SiteService( ResourceService resourceService ) throws IOException {
        this.consumer = new SiteConfigConsumer(resourceService.getSitesResource());
    }

    public SiteConfig getByShopCode (String shopCode) {
        return consumer.getByShopCode(shopCode);
    }
}
