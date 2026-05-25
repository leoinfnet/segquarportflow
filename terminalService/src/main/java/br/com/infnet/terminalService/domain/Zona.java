package br.com.infnet.terminalService.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Zona {
    private String tipo;
    private boolean disponivel;
    private String motivoIndisponibilidade;
}
