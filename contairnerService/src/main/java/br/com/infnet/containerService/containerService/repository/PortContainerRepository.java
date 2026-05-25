package br.com.infnet.containerService.containerService.repository;

import br.com.infnet.containerService.containerService.domain.PortContainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortContainerRepository extends JpaRepository<PortContainer,String> {
}
