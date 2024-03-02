package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.AcompanhamentoFormulariosPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.dataFactory.AcompanhamentoData;
import br.com.dbcompany.vemser.model.AcompanhamentoModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcompanhamentoFormularioTest extends Navegador {
    LoginPage login = new LoginPage();
    AcompanhamentoFormulariosPage acompanhamentoFormulariosPage = new AcompanhamentoFormulariosPage();
    public void fluxoDeLogin(){
       login.fluxoDeLoginHighCredentials();
    }

    @Test
    public void criarAcompanhamentoDeProgramaComSucesso(){
        fluxoDeLogin();
        acompanhamentoFormulariosPage.fluxoAcompanhamento();
        AcompanhamentoModel acompanhamento = AcompanhamentoData.acompanhamentoComDadosValidos();
        acompanhamentoFormulariosPage.preencherAcompanhamentoValido(acompanhamento);
        Assertions.assertEquals("Acompanhamento criado com sucesso!", acompanhamentoFormulariosPage.msgRetornoSucesso());
    }
}
