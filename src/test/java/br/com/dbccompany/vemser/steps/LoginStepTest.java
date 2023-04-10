package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.dbccompany.vemser.pages.MenuPage.clicarBotaoSair;
import static br.com.dbccompany.vemser.pages.MenuPage.consultarUsuarioLogado;


public class LoginStepTest extends LoginPage {
    @Test
    @Story("Usuário faz login")
    @Description("Administrador faz login com sucesso via pagina de login")
    public void testLoginComUsuarioESenha(){
        preencherUsuario(USUARIO_VALIDO);
        preencherSenha(SENHA_VALIDO);
        clicarBotaoLogin();
        Assertions.assertEquals(NOME_VALIDO.toLowerCase(), consultarUsuarioLogado().toLowerCase());
    }
    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz logout de sua conta com sucesso")
    public void testLogout(){
        preencherUsuario(USUARIO_VALIDO);
        preencherSenha(SENHA_VALIDO);
        clicarBotaoLogin();
        clicarBotaoSair();
        Assertions.assertTrue(isPaginaDeLogin());
    }
}
