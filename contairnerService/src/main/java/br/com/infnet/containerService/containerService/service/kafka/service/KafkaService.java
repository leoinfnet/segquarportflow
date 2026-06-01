package br.com.infnet.containerService.containerService.service.kafka.service;

public interface KafkaService {
    void sendEvent(String containerId);
}
