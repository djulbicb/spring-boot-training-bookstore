package com.training.bookstore.sites;

import java.util.Arrays;
import java.util.List;

public class SiteConfigConsumer {

    private final List<SiteConfig> configs;

    public SiteConfigConsumer(List<SiteConfig> configs) {
        this.configs = configs;
//        Type type = new TypeToken<List<SiteConfig>>() {}.getType();
//        this.configs = readConfig(type);
    }

    public SiteConfigConsumer(SiteConfig[] sitesResource) {
        this.configs = Arrays.asList(sitesResource);
    }

    public SiteConfig getByServerName(String serverName) {
        for (SiteConfig config : configs) {
            for (String domain : config.getDomains()) {
                if (serverName.matches(domain)) {
                    return config;
                }
            }

        }
        return getByShopCode("default");
    }

    public SiteConfig getByShopCode(String siteCode) {
        for (SiteConfig config : configs) {
            if (config.getCode().equals(siteCode)) {
                return config;
            }
        }
        throw new IllegalArgumentException("Cant find site with that site code " + siteCode);
    }

}
