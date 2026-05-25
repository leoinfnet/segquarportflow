package br.com.infnet.containerService.terminalService.dto;

import br.com.infnet.containerService.terminalService.domain.Capacidade;
import br.com.infnet.containerService.terminalService.domain.Restricoes;
import br.com.infnet.containerService.terminalService.domain.Terminal;
import br.com.infnet.containerService.terminalService.domain.Zona;

import java.util.List;

public record TerminalResponse(String terminalId,
                               String nome,
                               boolean ativo,
                               List<String> tiposCargaAceitos,
                               Capacidade capacidade,
                               List<Zona> zonas,
                               Restricoes restricoes,
                               List<String> equipamentos) {


    public static TerminalResponse fromDomain(Terminal terminal) {
        return new TerminalResponse(
                terminal.getTerminalId(),
                terminal.getNome(),
                terminal.isAtivo(),
                terminal.getTiposCargaAceitos(),
                terminal.getCapacidade(),
                terminal.getZonas(),
                terminal.getRestricoes(),
                terminal.getEquipamentos()
        );
    }
}
