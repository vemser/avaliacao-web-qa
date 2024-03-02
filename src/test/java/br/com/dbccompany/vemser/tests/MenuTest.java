package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class MenuTest extends Navegador {
    private static LoginPage loginPage = new LoginPage();
    private static MenuPage menuPage = new MenuPage();

    @Test
    @DisplayName("Verificar links do menu do Administrador")
    @Story("Verificar links do menu do Administrador")
    @Description("Verificar links do menu do Administrador")
    public void testVerificarLinksMenu() {
        loginPage.fluxoDeLoginHighCredentials();
        Assertions.assertTrue(menuPage.validarDashboard());
        Assertions.assertTrue(menuPage.validarColaboradores());
        Assertions.assertTrue(menuPage.validarTecnico());
        Assertions.assertTrue(menuPage.validarConfiguracoes());
        Assertions.assertTrue(menuPage.validarAusencias());
    }
}
