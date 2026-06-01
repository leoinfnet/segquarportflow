package br.com.infnet.containerService.containerService.service;

import br.com.infnet.containerService.containerService.client.TerminalClient;
import br.com.infnet.containerService.containerService.dto.ValidacaoTerminalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Profile("prod")
public class TerminalServiceImpl implements TerminalService {
    private final TerminalClient client;
    public ValidacaoTerminalResponse validarTerminal(String terminalId, String cargoType){
        return client.validarTerminal(terminalId,cargoType);
    }
}
