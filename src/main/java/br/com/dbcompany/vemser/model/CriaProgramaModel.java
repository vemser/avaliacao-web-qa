package br.com.dbcompany.vemser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CriaProgramaModel {
    private String nome;
    private String dataInicial;
    private String dataFinal;
    private String descricao;
    private boolean situacaoPrograma;
}
