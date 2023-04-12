package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import org.openqa.selenium.By;

public class AcessoPage extends Elementos {
    public static final String SELETOR_BOTAO_SAIR = "[data-testid=\"LogoutIcon\"]";
    public static final String SELETOR_ICONE_USUARIO = "[data-testid=\"PersonIcon\"]";
    public static final String SELETOR_NOME_USUARIO = "div.nome-usuario > h3";
    public static final String SELETOR_USUARIO = "div.nome-usuario > span";
    public void clicarBotaoAvaliacao() {
        driver.findElement(By.linkText("Avaliação")).click();
    }
    public void clicarBotaoSair() {
        clicar(SELETOR_BOTAO_SAIR);
    }
    public void clicarIconeUsuario() {
        clicar(SELETOR_ICONE_USUARIO);
    }
    public String consultarNomeUsuarioLogado() {
        esperarConteudoNaoVazio(SELETOR_NOME_USUARIO);
        return consultarTexto(SELETOR_NOME_USUARIO).toLowerCase();
    }
    public String consultarUsuarioLogado() {
        esperarConteudoNaoVazio(SELETOR_USUARIO);
        return consultarTexto(SELETOR_USUARIO).toLowerCase();
    }
    public void realizarLogoutComSucesso() {
        clicarIconeUsuario();
        clicarBotaoSair();
    }
}
