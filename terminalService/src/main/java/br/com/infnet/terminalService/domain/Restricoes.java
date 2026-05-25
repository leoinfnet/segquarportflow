package br.com.infnet.terminalService.domain;


import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Restricoes {
    private boolean aceitaCargaPerigosa;
    private boolean aceitaCargaRefrigerada;
    private Double alturaMaximaMetros;
    private Double pesoMaximoToneladas;
}
