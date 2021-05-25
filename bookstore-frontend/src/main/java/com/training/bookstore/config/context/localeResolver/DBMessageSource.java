package com.training.bookstore.config.context.localeResolver;

import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

    private static final String DEFAULT_LOCALE_CODE = "en";

    @Override
    protected MessageFormat resolveCode(String key, Locale locale) {
        return new MessageFormat("bojan", locale);
    }
}