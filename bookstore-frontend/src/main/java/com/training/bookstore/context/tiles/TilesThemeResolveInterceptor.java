package com.training.bookstore.context.tiles;

import com.training.bookstore.context.SiteSpec;
import com.training.bookstore.model.resources.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class TilesThemeResolveInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PRE");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        SiteSpec spec = (SiteSpec) modelAndView.getModelMap().getAttribute("siteSpec");
        Theme theme = spec.getTheme();
        String viewName = modelAndView.getViewName();

        modelAndView.setViewName(viewName + "." + theme.name().toLowerCase());
        System.out.println("POST");
    }
}
