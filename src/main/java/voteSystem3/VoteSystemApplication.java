package voteSystem3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import voteSystem3.service.SimpleService;


@SpringBootApplication
public class VoteSystemApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(VoteSystemApplication.class, args);
        context.getBean(SimpleService.class).testGet();
    }
}
