package com.training.bookstore.config.tiles;

import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.startup.AbstractTilesInitializer;
import org.springframework.stereotype.Component;

@Component
public class TilesThemeInitialiser extends AbstractTilesInitializer {

    @Override
    protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext applicationContext) {
        TilesThemeContainerFactory factory = new TilesThemeContainerFactory();
        return factory;
    }
}
