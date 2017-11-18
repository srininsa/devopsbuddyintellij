package com.devopsbuddyintellij.web.i18n;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * This is a Service
 * i89n is a package sits below root package where
 * devopsbuddyintellij application class lives
 * because devopsbuddyintellij application scan all its sub-packages
 * we can be sure this class will be scaned and managed like a bean
 */
@Service
public class I18NService {
    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(I18NService.class);

    /**
     * Dependency Injection ( you wanted two classes to be defined in the same source file?
     * instead you could use DI to achieve the same effect)
     *
     * Injecting message source bean - to tell spring to look for a messagesource interface
     * we have previously setup ReloadableResourceBundleMessageSource
     * spring will inject an instance of ReloadableResourceBundleMessageSource class in I18NService class
     **/
    @Autowired
    private MessageSource messageSource;

    /**
     * Returns a message for the given message id and the default locale in the session context
     * @param messageId The key to the messages resource file
     */
    //Overloaded method
    public String getMessage(String messageId) {
        LOG.info("****** Returning i18n text for messageId {}", messageId);
        Locale locale = LocaleContextHolder.getLocale();
        return getMessage(messageId,locale);
    }

    /**
     * Returns a message for the given message id and locale
     * @param messageId The key to the messages resource file
     * @param locale The Locale
     */
    //This takes locale as parameter to
    //access the text in the messages.properties file
    public String getMessage(String messageId, Locale locale) {
        LOG.info("LOCALE : Returning i18n text for messageId {}", messageId);
        return messageSource.getMessage(messageId,null, locale);
    }
}
