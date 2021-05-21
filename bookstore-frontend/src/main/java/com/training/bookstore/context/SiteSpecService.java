package com.training.bookstore.context;

import com.training.bookstore.sites.SiteConfig;
import com.training.bookstore.sites.SiteConfigConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class SiteSpecService {

    SiteConfigConsumer siteConfigConsumer;

    @Autowired
    public SiteSpecService(SiteConfigConsumer siteConfigConsumer) {
        System.out.println("SERVICE");
        this.siteConfigConsumer = siteConfigConsumer;
    }

    public SiteSpec create(HttpServletRequest request) {
        SiteConfig config = siteConfigConsumer.getByServerName(request.getServerName());
        return new SiteSpec(config.getTheme(), config.getLang());
    }
}
