package br.com.infnet.containerService.containerService.client;

import br.com.infnet.containerService.containerService.dto.ValidacaoTerminalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "TERMINAL-SERVICE")
public interface TerminalClient {
    @GetMapping("/terminais/{terminalId}/validacao")
    ValidacaoTerminalResponse validarTerminal(@PathVariable("terminalId") String terminalId,
                                              @RequestParam("tipoCarga") String tipoCarga);
}
