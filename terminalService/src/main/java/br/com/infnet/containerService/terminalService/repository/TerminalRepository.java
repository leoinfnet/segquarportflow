package br.com.infnet.containerService.terminalService.repository;

import br.com.infnet.containerService.terminalService.domain.Terminal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TerminalRepository extends MongoRepository<Terminal,String> {
    Optional<Terminal> findByTerminalId(String terminalId);
}
