package com.training.bookstore.config.context.localeResolver;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class SubDomainLocaleResolver extends AbstractLocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String domain = request.getServerName();

        if (!domain.contains(".")) {
            return Locale.ENGLISH;
        }

        String language = domain.substring(0, domain.indexOf('.'));
        Locale  locale = StringUtils.parseLocaleString(language);
        if (locale == null) {
            locale = determineDefaultLocale(request);
        }
        return locale != null ? locale : determineDefaultLocale(request);
    }

    protected Locale determineDefaultLocale(HttpServletRequest request) {
        Locale defaultLocale = getDefaultLocale();
        if (defaultLocale == null) {
            defaultLocale = request.getLocale();
        }
        return Locale.ENGLISH;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        throw new UnsupportedOperationException("Cannot change sub-domain locale - use a different locale resolution strategy");
    }
}