package com.tw.smartpool.config;

import org.hibernate.engine.transaction.internal.jta.JtaTransactionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan(basePackages="{com.tw.smartpool.controller}")
@EnableWebMvc
@EnableTransactionManagement
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setCache(true);
		resolver.setSuffix(".ftl");
		return resolver;
	}

    @Bean
    public FreeMarkerConfigurer getViewConfigurer(){
        FreeMarkerConfigurer configurer =new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath("/WEB-INF/views/");
        return configurer;

    }

    @Bean
    public EntityManager getEntityManager(){
        return getEntityManagerFactory().getObject().createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactory= new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactory.setPersistenceUnitName("punit");
        entityManagerFactory.setDataSource(getDataSource());
        entityManagerFactory.setJpaVendorAdapter(getJpaVendorAdapter());
        entityManagerFactory.setJpaPropertyMap(getJpaPropertyMap());
        entityManagerFactory.setPackagesToScan("com.tw.smartpool");
        return entityManagerFactory;
    }

    @Bean
    public JpaTransactionManager getTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getEntityManagerFactory().getObject());
        return  transactionManager;
    }

    private DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");          //TODO pull out the configurations to a file
        dataSource.setUrl("jdbc:mysql://localhost:3306/smartpool");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return  dataSource;
    }

    @Bean
    public HibernateJpaVendorAdapter getJpaVendorAdapter(){
        HibernateJpaVendorAdapter adapter= new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        return adapter;
    }

    private Map<String,String> getJpaPropertyMap(){
        Map<String,String> map = new HashMap<>(3);
        map.put("hibernate.dialect","org.hibernate.dialect.MySQL5InnoDBDialect");    //TODO pull out properties to a file
        map.put("hibernate.hbm2ddl.auto","none");
        map.put("hibernate.format_sql","true");
        return map;
    }



	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}


}
