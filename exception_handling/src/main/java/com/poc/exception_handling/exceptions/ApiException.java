package com.poc.exception_handling.exceptions;

import java.util.Locale;
import java.util.ResourceBundle;

public class ApiException extends Exception {

    Locale locale;

    String translationKey;

    public ApiException(String nonLocalizedMessage) {
        super(nonLocalizedMessage);
        locale = null;
        translationKey = null;
    }

    public ApiException(String translationKey, Locale locale) {
        this.locale = locale;
        this.translationKey = translationKey;
    }

    @Override
    public String getMessage() {
        if (locale != null) {
            String nonLocalizedMessage = ResourceBundle.getBundle(ExceptionConstants.TRANSLATIONS_FILE, Locale.US).getString(translationKey);
            return nonLocalizedMessage;
        }

        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        if (locale != null) {
            String localizedMessage = ResourceBundle.getBundle(ExceptionConstants.TRANSLATIONS_FILE, locale).getString(translationKey);
            return localizedMessage;
        }

        return super.getMessage();
    }

}
