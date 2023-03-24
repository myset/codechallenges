package org.example.codechallenges.springbootkafka.springboot;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"org.example.codechallenges.springbootkafka"})
@ComponentScan(basePackages = {"org.example.codechallenges.springbootkafka"})
@EnableJpaRepositories(basePackages={"org.example.codechallenges.springbootkafka"})
@EntityScan(basePackages={"org.example.codechallenges.springbootkafka"})
@EnableTransactionManagement
public class Application {

    private static final Logger LOG = LogManager.getFormatterLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                LOG.debug("%s = %s",beanName, ctx.getBean(beanName));
//            }
        };
    }

}