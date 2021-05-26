package com.training.bookstore.config.themes;

import com.training.bookstore.config.context.spec.SiteSpec;
import com.training.bookstore.model.site.Theme;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TilesThemeResolveInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("PRE");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.getModelMap().containsAttribute("siteSpec")) {
            return;
        }
        SiteSpec spec = (SiteSpec) modelAndView.getModelMap().getAttribute("siteSpec");
        Theme theme = spec.getTheme();
        String viewName = modelAndView.getViewName();

        modelAndView.setViewName(viewName + "." + theme.name().toLowerCase());
        System.out.println("POST");
    }
}
