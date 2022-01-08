package com.ornelas.foodapi.core.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ValidationConfig {


    //LocalValidatorFactoryBean faz a integração e configuração do Bean Validation com o Spring
    //MessageSource é o responsável por ler o arquivo messages.properties e fazer a resolução de mensagens
    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        //Indicamos que o ValidationMessageSource será o messageSource e não ValidationMessages.properties(Padrão)
        bean.setValidationMessageSource(messageSource);
        return bean;
    }
}
