package br.com.infnet.containerService.containerService.service.kafka.service;

import br.com.infnet.containerService.containerService.service.kafka.events.ContainerStatusEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService {
    private final String TOPIC_DOCUMENTACAO_PENDENTE = "portflow.container.documentacao_pendente";
    private final KafkaTemplate<String, ContainerStatusEvent> kafka;

    public void sendEvent(String containerId){
        ContainerStatusEvent containerStatusEvent = ContainerStatusEvent.documentacaoPendente(containerId);
        kafka.send(TOPIC_DOCUMENTACAO_PENDENTE,containerId,containerStatusEvent);

    }
}
