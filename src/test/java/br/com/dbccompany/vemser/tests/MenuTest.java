package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuTest extends Navegador {
    private static LoginPage loginPage = new LoginPage();
    private static AcessoPage acessoPage = new AcessoPage();
    private static MenuPage menuPage = new MenuPage();
    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        Assertions.assertTrue(loginPage.validaLoginComSucesso());
        menuPage.acessarPagina();
    }
    @Test
    @DisplayName("Verificar links do menu do Administrador")
    @Story("Menu Avaliação")
    @Description("Verificar links do menu do Administrador")
    public void testVerificarLinksMenu() {
        menuPage.clicarBotaoDashboard();
        Assertions.assertEquals("dashboard", menuPage.consultarTituloAtual());
        Assertions.assertEquals(DashboardPage.URL_PAGINA, menuPage.consultarUrl());
        menuPage.clicarBotaoEstagiarios();
        Assertions.assertEquals("colaboradores", menuPage.consultarTituloAtual());
        Assertions.assertEquals(ColaboradoresPage.URL_PAGINA, menuPage.consultarUrl());
        menuPage.clicarBotaoComportamental();
        menuPage.clicarBotaoAcompanhamentos();
        Assertions.assertEquals("acompanhamentos", menuPage.consultarTituloAtual());
        Assertions.assertTrue(menuPage.consultarUrl().contains(AcompanhamentosPage.URL_PAGINA));
        menuPage.clicarBotaoTecnico();
        menuPage.clicarBotaoTecnicoFeedback();
        Assertions.assertEquals(TecnicoFeedbackPage.URL_PAGINA, menuPage.consultarUrl());
        menuPage.clicarBotaoConfiguracoes();
        Assertions.assertEquals("configurações", menuPage.consultarTituloAtual());
        Assertions.assertEquals(ConfiguracoesPage.URL_PAGINA, menuPage.consultarUrl());
    }
}
