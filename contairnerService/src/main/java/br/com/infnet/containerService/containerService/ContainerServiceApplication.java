package br.com.infnet.containerService.containerService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ContainerServiceApplication {
    static void main(String [] args) {
        SpringApplication.run(ContainerServiceApplication.class);
    }
}
