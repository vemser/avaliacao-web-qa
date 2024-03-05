package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class ConfiguracoesTest extends Navegador {
    ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    LoginPage login = new LoginPage();
    MenuPage menu = new MenuPage();

    public void fluxoDeLogin(){
        login.fluxoDeLoginHighCredentials();
        menu.clicarBotaoConfiguracoes();
    }
    @Test
    @Story("Validar a page Configurações - Função Programa")
    @Description("Validando a visibilidade da função criar programa.")
    @DisplayName("Validando a visibilidade da função criar programa.")
    public void validarPaginaConfiguracoesFuncaoPrograma() {
        fluxoDeLogin();
        Assertions.assertTrue(configuracoesPage.validaPaginaConfiguracoes());
        Assertions.assertTrue(configuracoesPage.validarElementoProgramaEmPageConfig());
    }

    @Test
    @Story("Validar a page Configurações - Função Acompanhamento")
    @Description("Validando a visibilidade da função criar Acompanhamento.")
    @DisplayName("Validando a visibilidade da função criar Acompanhamento.")
    public void validarPaginaConfiguracoesFuncaoAcompanhamento() {
        fluxoDeLogin();
        Assertions.assertTrue(configuracoesPage.validaPaginaConfiguracoes());
        Assertions.assertTrue(configuracoesPage.validarElementoAcompanhamentoEmPageConfig());
    }
}
