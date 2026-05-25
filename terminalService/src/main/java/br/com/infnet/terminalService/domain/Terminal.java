package br.com.infnet.terminalService.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "terminais")
@Getter@Setter
public class Terminal {
    @Id
    private String id;
    private String terminalId;
    private String nome;
    private boolean ativo;
    private List<String> tiposCargaAceitos;
    private Capacidade capacidade;
    private List<Zona> zonas;
    private Restricoes restricoes;
    private List<String> equipamentos;
}
