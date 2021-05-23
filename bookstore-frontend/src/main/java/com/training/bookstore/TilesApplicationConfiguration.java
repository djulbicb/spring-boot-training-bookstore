package com.training.bookstore;

import com.training.bookstore.config.TilesThemeInitialiser;
import com.training.bookstore.config.TilesThemeResolveInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.util.Locale;

@Configuration
@EnableWebMvc
public class TilesApplicationConfiguration implements WebMvcConfigurer {

    @Autowired
    TilesThemeResolveInterceptor themeResolver;

    @Autowired
    SubDomainLocaleResolver localeChangeInterceptor;

    @Bean
    public LocaleResolver localeResolver() {
        return localeChangeInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(themeResolver);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        viewResolver.setOrder(1);
        registry.viewResolver(viewResolver);
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();


         tiles.setTilesInitializer(new TilesThemeInitialiser());
//        tiles.setDefinitionsFactoryClass(TilesDefinitionConfig.class);
//        TilesDefinitionConfig.addDefinitions();
        tiles.setDefinitions("classpath:layout.xml");

        tiles.setCheckRefresh(true);

        return tiles;
    }
}
