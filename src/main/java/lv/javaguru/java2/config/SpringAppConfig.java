package lv.javaguru.java2.config;

import lv.javaguru.java2.filters.DirectLinkFIlter;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"lv.javaguru.java2"})
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class SpringAppConfig {

    @Bean(name = "propertySourcesPlaceholderConfigurer")
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "dataSource")
    public static DataSource dataSource(
            @Value("${jdbc.url}") String jdbcUrl,
            @Value("${driverClass}") String driverClass,
            @Value("${database.user.name}") String userName,
            @Value("${database.user.password}") String password) {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(jdbcUrl);
        ds.setDriverClassName(driverClass);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }

    @Bean(name = "hibernateProperties")
    public Properties hibernateProperties(
            @Value("${hibernate.dialect}") String dialect,
            @Value("${hibernate.show_sql}") boolean showSql,
            @Value("${hibernate.format_sql}") boolean formatSql,
            @Value("${hibernate.hbm2ddl.auto}") String hbm2ddl) {

        Properties properties = new Properties();
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.show_sql", showSql);
        properties.put("hibernate.format_sql", formatSql);
        properties.put("hibernate.hbm2ddl.auto", hbm2ddl);

        return properties;
    }

    @Bean(name = "sessionFactorys")
    public SessionFactory sessionFactory(DataSource dataSource,
                                         @Value("${hibernate.packagesToScan}") String packagesToScan,
                                         @Qualifier("hibernateProperties") Properties properties) throws Exception {

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(packagesToScan);
        sessionFactoryBean.setHibernateProperties(properties);
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(someFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("someFilter");
        registration.setOrder(1);
        return registration;
    }

    public Filter someFilter() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        return new DirectLinkFIlter();
    }
}
