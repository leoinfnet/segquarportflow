package br.com.infnet.containerService.containerService.service.kafka.service;

import br.com.infnet.containerService.containerService.service.kafka.events.ContainerStatusEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@RequiredArgsConstructor
public class KafkaServiceImpl implements KafkaService {
    private final String TOPIC_DOCUMENTACAO_PENDENTE = "portflow.container.documentacao_pendente";
    private final KafkaTemplate<String, ContainerStatusEvent> kafka;

    @Override
    public void sendEvent(String containerId){
        ContainerStatusEvent containerStatusEvent = ContainerStatusEvent.documentacaoPendente(containerId);
        kafka.send(TOPIC_DOCUMENTACAO_PENDENTE,containerId,containerStatusEvent);

    }
}
