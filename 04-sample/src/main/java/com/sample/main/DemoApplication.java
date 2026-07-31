package com.sample.main;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import io.prometheus.client.CollectorRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MapperScan(basePackages = {"com.sample.**.mapper"},
        sqlSessionTemplateRef = "sqlSessionTemplate",
        sqlSessionFactoryRef = "sqlSessionFactory")
@SpringBootApplication(proxyBeanMethods = false)
public class DemoApplication implements CommandLineRunner {

    final static Logger logger = LoggerFactory.getLogger(DemoApplication.class);
    public static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(DemoApplication.class);
        application.setApplicationStartup(new BufferingApplicationStartup(2048));
        applicationContext = application.run(args);


        while (true){

            Thread.sleep(1000);
            HikariDataSource dataSource = applicationContext.getBean(HikariDataSource.class);

            Field f = HikariDataSource.class.getDeclaredField("pool");
            f.setAccessible(true);
            HikariPool pool = (HikariPool) f.get(dataSource);

            logger.error("{} - {}stats (total={}, active={}, idle={}, waiting={})",
                    pool.toString(), "",
                    pool.getTotalConnections(), pool.getActiveConnections(),
                    pool.getIdleConnections(), pool.getThreadsAwaitingConnection());

        }


//        SpringApplication.run(DemoApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {




    }
}
