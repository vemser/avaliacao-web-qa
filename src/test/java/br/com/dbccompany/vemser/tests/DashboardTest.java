package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.DashboardPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class DashboardTest extends Navegador {
    LoginPage login = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    @DisplayName("Validar página Dashboard após o login")
    @Story("Validar página Dashboard após o login")
    @Description("Validar página Dashboard após o login")
    public void validarPaginaDashboardInicialHighCredentials() {
        login.fluxoDeLoginHighCredentials();
        Assertions.assertTrue(dashboardPage.validarDadosDashboard());
    }

}
