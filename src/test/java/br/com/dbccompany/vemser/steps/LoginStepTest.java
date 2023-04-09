package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.BasePage;
import br.com.dbccompany.vemser.utils.Usuarios;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Assert;
import org.junit.Test;

public class LoginStepTest extends BaseSteps{
    BasePage basePage = new BasePage();
//    @Test
//    @Story("Usuário faz login")
//    @Description("Administrador faz login com sucesso via token")
//    public void testLoginComToken(){
//        basePage.logarComToken(Usuarios.TOKEN_ADMIN);
//        Assert.assertEquals(Usuarios.NOME_ADMIN, basePage.consultarUsuarioLogado());
//    }
    @Test
    @Story("Usuário faz login")
    @Description("Administrador faz login com sucesso via pagina de login")
    public void testLoginComUsuarioESenha(){
        basePage.logarComUsuario(Usuarios.USUARIO, Usuarios.SENHA);
        Assert.assertEquals("Usuarios.NOME", basePage.consultarUsuarioLogado());
    }
    @Test
    @Story("Usuário faz login")
    @Description("Usuário faz login e sai de sua conta com sucesso")
    public void testLogout(){
        basePage.logarComUsuario(Usuarios.USUARIO, Usuarios.SENHA);
        Assert.assertEquals("Usuarios.NOME", basePage.consultarUsuarioLogado());
        basePage.sairDaConta();
        Assert.assertTrue(basePage.isPaginaDeLogin());
    }
}
