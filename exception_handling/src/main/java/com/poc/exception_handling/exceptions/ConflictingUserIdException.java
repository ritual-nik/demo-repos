package com.poc.exception_handling.exceptions;

import java.util.Locale;
import java.util.UUID;

public class ConflictingUserIdException extends ApiException {

    public UUID conflictingId;

    public ConflictingUserIdException(UUID id, Locale locale, String translationKey) {
        super(translationKey, locale);
        this.conflictingId = id;
    }

    public ConflictingUserIdException(Locale locale, String translationKey) {
        super(translationKey, locale);
    }


}
