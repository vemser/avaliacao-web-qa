package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.dataFactory.LoginData;
import br.com.dbcompany.vemser.model.LoginModel;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginTest extends Navegador {
    LoginPage loginPage = new LoginPage();

    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login com sucesso")
    @DisplayName("Usuário faz login com sucesso")
    public void testLoginComSucesso(){
        Assertions.assertTrue(loginPage.validaPaginaDeLogin());
        Assertions.assertTrue(loginPage.realizarLoginComSucessoHighCredentials());
    }
    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login utilizando E-mail invalido")
    @DisplayName("Usuário faz login utilizando E-mail invalido")
    public void testLoginComEmailInvalidoSemSucesso(){
        LoginModel login = LoginData.loginEmailInvalido();
        loginPage.realizarLoginComEmailInvalido(login);
        String mensagem = loginPage.msgErroEmailInvalido();
        Assertions.assertEquals("Precisa ser email @dbccompany.com.br ou usuário válido", mensagem);
    }


    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login utilizando senha invalida")
    @DisplayName("Usuário faz login utilizando senha invalida")
    public void testLoginComSenhaInvalidaSemSucesso(){
        LoginModel login = LoginData.loginSenhaInvalida();
        loginPage.realizarloginSenhaInvalida(login);
        String mensagem = loginPage.msgErroSenhaInvalida();
        Assertions.assertEquals("login e senha inválidos!", mensagem);
    }

    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login com e-mail em branco")
    @DisplayName("Usuário faz login com e-mail em branco")
    public void testLoginComLoginEmBrancoSemSucesso(){
        LoginModel login = LoginData.loginEmailEmBranco();
        loginPage.realizarlloginEmailEmBranco(login);
        String mensagem = loginPage.msgDeLoginEmBranco();
        Assertions.assertEquals("Por favor, digite seu usuário", mensagem);
    }

    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login com senha em branco")
    @DisplayName("Usuário faz login com senha em branco")
    public void testLoginComSenhaEmBrancoSemSucesso(){
        LoginModel login = LoginData.loginSenhaEmBranco();
        loginPage.realizarlloginSenhaEmBranco(login);
        String mensagem = loginPage.msgDeSenhaEmBranco();
        Assertions.assertEquals("Por favor, digite sua senha", mensagem);
    }
    @AfterEach
    public void limparCookies(){
        driver.manage().deleteAllCookies();
        loginPage.acessarPagina();
    }
}
