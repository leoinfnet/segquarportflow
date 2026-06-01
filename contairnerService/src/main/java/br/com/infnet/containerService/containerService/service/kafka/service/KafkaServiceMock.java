package br.com.infnet.containerService.containerService.service.kafka.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class KafkaServiceMock implements KafkaService {
    @Override
    public void sendEvent(String containerId) {
        System.out.println("Enviando mensagem mock!!");
    }
}
