package br.com.infnet.containerService.containerService.service;

import br.com.infnet.containerService.containerService.dto.ValidacaoTerminalResponse;

public interface TerminalService {
    ValidacaoTerminalResponse validarTerminal(String terminalId, String cargoType);
}
