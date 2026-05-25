package br.com.infnet.containerService.containerService.service;

import br.com.infnet.containerService.containerService.domain.PortContainer;
import br.com.infnet.containerService.containerService.domain.StatusContainer;
import br.com.infnet.containerService.containerService.dto.ContainerArrivalRequest;
import br.com.infnet.containerService.containerService.dto.ValidacaoTerminalResponse;
import br.com.infnet.containerService.containerService.exception.TerminalValidationException;
import br.com.infnet.containerService.containerService.repository.PortContainerRepository;
import br.com.infnet.containerService.containerService.service.kafka.service.KafkaService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContainerService {
    private final PortContainerRepository repository;
    private final TerminalService terminalService;
    private final KafkaService kafkaService;
    public PortContainer registerArrival(ContainerArrivalRequest request) {
        PortContainer container = new PortContainer(
                request.containerId(),
                request.shipId(),
                request.terminalId(),
                request.originCountry(),
                request.destinationCountry(),
                request.cargoType(),
                StatusContainer.DOCUMENTACAO_PENDENTE,
                LocalDateTime.now()
        );
        ValidacaoTerminalResponse validacao =
                terminalService.validarTerminal(request.terminalId(), request.cargoType());
        if(!validacao.terminalValido()) throw new TerminalValidationException(validacao.mensagem());
        PortContainer saved = repository.save(container);
        kafkaService.sendEvent(saved.getId());
        return saved;
    }
    public List<PortContainer> findAll(){
        return repository.findAll();
    }
    public PortContainer findById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Container não localizado"));
    }
    public StatusContainer findStatusById(String id){
        return findById(id).getStatus();
    }

    public PortContainer updateStatus(String containerId, StatusContainer newStatus){
        PortContainer container = findById(containerId);
        container.setStatus(newStatus);
        return repository.save(container);
    }


}
