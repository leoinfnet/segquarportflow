package br.com.infnet.containerService.terminalService.domain;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Capacidade {
    private Integer maximaContainers;
    private Integer ocupacaoAtual;

    public boolean possuiCapacidadeDisponivel() {
        if (maximaContainers == null || ocupacaoAtual == null) {
            return false;
        }

        return ocupacaoAtual < maximaContainers;
    }
}
