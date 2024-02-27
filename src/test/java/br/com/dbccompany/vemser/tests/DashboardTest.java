package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.DashboardPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DashboardTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    private static LoginPage loginPage = new LoginPage();
    private static DashboardPage dashboardPage = new DashboardPage();

    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        dashboardPage.acessarPagina();
    }

    @Test
    @DisplayName("Acessar página Dashboard")
    @Story("Acessar página Dashboard")
    @Description("Acessar página Dashboard")
    public void testAcessarPaginaAvaliacao() {
        Assertions.assertTrue(dashboardPage.estaNaPaginaDashboard());
    }
}
