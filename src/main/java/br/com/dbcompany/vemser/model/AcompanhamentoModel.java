package br.com.dbcompany.vemser.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AcompanhamentoModel {
    private String titulo;
    private String instrutores;
    private String dataInicio;
    private String dataFim;
    private String horaInicio;
    private String horaFim;
    private int sessao;
    private int resposaveis;
    private String descricao;
}
