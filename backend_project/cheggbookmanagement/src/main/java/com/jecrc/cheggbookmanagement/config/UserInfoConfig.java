package com.jecrc.cheggbookmanagement.config;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
@Setter
@Slf4j
public class UserInfoConfig implements InitializingBean {


    @Value("${user-info.configuration.book-quota}")
    Integer bookQuota;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("-----------userinfo config {}",this);
    }
}
