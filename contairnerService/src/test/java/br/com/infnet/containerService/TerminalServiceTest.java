package br.com.infnet.containerService;

import br.com.infnet.containerService.containerService.dto.ValidacaoTerminalResponse;
import br.com.infnet.containerService.containerService.service.TerminalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TerminalServiceTest {
    @Autowired
    TerminalService terminalService;
    @Test
    public void deveTerstarTerminal(){
        ValidacaoTerminalResponse response = terminalService
                .validarTerminal("T1", "ELETRONICOS");

        System.out.println(response);
    }
}
