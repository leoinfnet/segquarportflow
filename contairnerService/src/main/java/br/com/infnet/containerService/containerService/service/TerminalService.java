package br.com.infnet.containerService.containerService.service;

import br.com.infnet.containerService.containerService.client.TerminalClient;
import br.com.infnet.containerService.containerService.dto.ValidacaoTerminalResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TerminalService {
    private final TerminalClient client;
    public ValidacaoTerminalResponse validarTerminal(String terminalId, String cargoType){
        return client.validarTerminal(terminalId,cargoType);
    }
}
