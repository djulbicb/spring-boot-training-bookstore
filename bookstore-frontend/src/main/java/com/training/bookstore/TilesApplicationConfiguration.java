package com.training.bookstore;


import com.training.bookstore.context.tiles.TilesThemeInitialiser;
import com.training.bookstore.context.tiles.TilesThemeResolveInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
public class TilesApplicationConfiguration implements WebMvcConfigurer {

    @Autowired
    TilesThemeResolveInterceptor themeResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(themeResolver);
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
