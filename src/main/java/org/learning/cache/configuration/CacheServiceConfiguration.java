package org.learning.cache.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan(basePackages = "{org.learning.cache}")
public class CacheServiceConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

 //Ehcache configuration implementation here....

    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(ehCacheCacheManager().getObject());
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager(){
        EhCacheManagerFactoryBean cfb = new EhCacheManagerFactoryBean();
        cfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cfb.setShared(true);

        return cfb;
    }
}
