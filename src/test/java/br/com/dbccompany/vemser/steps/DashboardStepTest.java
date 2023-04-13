package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.DashboardPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DashboardStepTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    private static LoginPage loginPage = new LoginPage();
    private static DashboardPage dashboardPage = new DashboardPage();
    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.clicarBotaoAvaliacao();
        dashboardPage.acessarPagina();
    }
    @Test
    public void testAcessarPaginaAvaliacao() {
        Assertions.assertTrue(dashboardPage.estaNaPaginaDashboard());
    }
}
