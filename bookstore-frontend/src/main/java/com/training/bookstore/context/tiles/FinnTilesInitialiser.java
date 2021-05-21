package com.training.bookstore.context.tiles;

import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.factory.BasicTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.startup.AbstractTilesInitializer;
import org.apache.tiles.startup.DefaultTilesInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class FinnTilesInitialiser extends AbstractTilesInitializer {

    public FinnTilesInitialiser() {}

    @Override
    protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext applicationContext) {
        return new FinnTilesContainerFactory();
    }
}
