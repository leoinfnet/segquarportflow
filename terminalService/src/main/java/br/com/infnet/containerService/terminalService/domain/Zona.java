package br.com.infnet.containerService.terminalService.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Zona {
    private String tipo;
    private boolean disponivel;
    private String motivoIndisponibilidade;
}
