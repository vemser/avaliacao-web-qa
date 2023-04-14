package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LoginStepTest extends Navegador {
    AcessoPage acessoPage = new AcessoPage();
    LoginPage loginPage = new LoginPage();
    @AfterEach
    public void limparCookies(){
        driver.manage().deleteAllCookies();
        loginPage.acessarPagina();
    }
    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login com sucesso")
    @DisplayName("Usuário faz login com sucesso")
    public void testLoginComUsuarioESenha(){
        loginPage.acessarPagina();
        loginPage.preencherUsuarioValido();
        loginPage.preencherSenhaValida();
        loginPage.clicarBotaoLogin();
        Assertions.assertEquals(loginPage.consultarUsuarioValido(), acessoPage.consultarUsuarioLogado());
        Assertions.assertEquals(loginPage.consultarNomeUsuarioValido(), acessoPage.consultarNomeUsuarioLogado());
    }
    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz logout de sua conta com sucesso")
    @DisplayName("Usuário faz logout de sua conta com sucesso")
    public void testLogout(){
        loginPage.realizarLoginComSucesso();
        acessoPage.clicarIconeUsuario();
        acessoPage.clicarBotaoSair();
        Assertions.assertTrue(loginPage.estaNaPaginaDeLogin());
    }
    @ParameterizedTest(name = "{index} - Login com usuário: {0}")
    @Story("Usuário faz login")
    @Description("Usuário faz login com dados inválidos")
    @DisplayName("Usuário faz login com dados inválidos")
    @MethodSource("dataFactory.DataFactory#provideLoginsInvalidos")
    public void testLoginComUsuarioESenhaInvalidos(String usuario, String senha){
        loginPage.acessarPagina();
        loginPage.preencherUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarBotaoLogin();
        acessoPage.acessarPagina();
        Assertions.assertTrue(loginPage.estaNaPaginaDeLogin());
        Assertions.assertTrue(loginPage.existeMensagemDeSessaoExpirada());
    }
}
