package com.training.bookstore.api;

import com.google.gson.reflect.TypeToken;
import com.pocketknife.resource.JsonToClassResourceReader;
import com.training.bookstore.model.ShopConfig;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class ShopConfigConsumer extends JsonToClassResourceReader<List<ShopConfig>> {

    private final List<ShopConfig> configs;

    public ShopConfigConsumer() {
        Type type = new TypeToken<List<ShopConfig>>() {}.getType();
        this.configs = readConfig(type);
    }

    public List<ShopConfig> getConfigs() {
        return configs;
    }

    @Override
    public String getResourceFilePath() {
        return "shops-config.json";
    }
}
