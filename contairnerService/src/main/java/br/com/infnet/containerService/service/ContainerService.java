package br.com.infnet.containerService.service;

import br.com.infnet.containerService.domain.PortContainer;
import br.com.infnet.containerService.domain.StatusContainer;
import br.com.infnet.containerService.dto.ContainerArrivalRequest;
import br.com.infnet.containerService.repository.PortContainerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContainerService {
    private final PortContainerRepository repository;

    public PortContainer registerArrival(ContainerArrivalRequest request) {
        PortContainer container = new PortContainer(
                request.containerId(),
                request.shipId(),
                request.terminalId(),
                request.originCountry(),
                request.destinationCountry(),
                request.cargoType(),
                StatusContainer.CHEGOU,
                LocalDateTime.now()
        );

        return repository.save(container);
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
