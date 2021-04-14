package com.poc.exception_handling.config;

import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

public class AcceptHeaderResolver extends AcceptHeaderLocaleResolver {

    List<Locale> SUPPORTED_LOCALES = Arrays.asList(Locale.US, Locale.FRANCE);

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String requestLanguage = request.getHeader("Accept-Language");
        return requestLanguage == null || requestLanguage.isEmpty()
                ? Locale.US
                : Locale.lookup(Locale.LanguageRange.parse(requestLanguage), SUPPORTED_LOCALES);
    }


}
