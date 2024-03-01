package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.AcompanhamentoPage;
import br.com.dbcompany.vemser.dataFactory.AcompanhamentoData;
import br.com.dbcompany.vemser.model.AcompanhamentoModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AcompanhamentoTest extends AcompanhamentoPage {

    @BeforeAll
    public static void fluxoDeLoginNoSite(){
        fluxoDeLogin();
    }

    @Test
    public void criarAcompanhamentoDeProgramaComSucesso(){
        fluxoAcompanhamento();
        AcompanhamentoModel acompanhamento = AcompanhamentoData.acompanhamentoComDadosValidos();
        preencherDeAcompanhamentoValido(acompanhamento);
    }
}
