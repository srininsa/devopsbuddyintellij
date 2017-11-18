package com.devopsbuddyintellij.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class I18NConfig {

    //Spring Bean
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:i18n/messages"); //looks for messages.properties file in resources/i18n
        //Check for new messages every 30 minutes
        reloadableResourceBundleMessageSource.setCacheSeconds(1800);
        return reloadableResourceBundleMessageSource;
    }
}
