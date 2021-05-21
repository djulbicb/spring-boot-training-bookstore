package com.training.bookstore.sites;

import com.djulb.resource.JsonToClassResourceReader;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class SiteConfigConsumer extends JsonToClassResourceReader<List<SiteConfig>> {

    private final List<SiteConfig> configs;

    public SiteConfigConsumer() {
        Type type = new TypeToken<List<SiteConfig>>() {}.getType();
        this.configs = readConfig(type);
    }

    public SiteConfig getByServerName(String serverName) {
        for (SiteConfig config : configs) {
            for (String domain : config.getDomains()) {
                if (serverName.matches(domain)) {
                    return config;
                }
            }

        }
        return getByName("enbl");
    }

    private SiteConfig getByName(String siteCode) {
        for (SiteConfig config : configs) {
            if (config.getCode().equals(siteCode)) {
                return config;
            }
        }
        throw new IllegalArgumentException("Cant find site with that site code " + siteCode);
    }

    @Override
    public String getResourceFilePath() {
        return "site-config.json";
    }
}
