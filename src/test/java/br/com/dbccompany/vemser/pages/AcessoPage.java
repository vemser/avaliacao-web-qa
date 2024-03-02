package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import org.openqa.selenium.By;

public class AcessoPage extends Elementos {
    public static final String SELETOR_BOTAO_SAIR = "[data-testid=\"LogoutIcon\"]";
    public static final String SELETOR_ICONE_USUARIO = ".MuiAvatar-root.MuiAvatar-circular.MuiAvatar-colorDefault.css-154ogbs";
    public static final String SELETOR_NOME_USUARIO = "div.nome-usuario > h3";
    public static final String SELETOR_USUARIO = "div[class='nome-usuario MuiBox-root css-12wr06q'] span";
    public static final String SELETOR_AVALIACAO = "#root > div.CardList_container__EPfbg > a:nth-child(1) > div";
    public static final String URL_SITE = "https://avaliacao-front-five.vercel.app/login";

    public void acessarPaginaAvaliacao() {
        acessarUrl(URL_SITE);
    }
    public void clicarBotaoAvaliacao() {
        esperarElemento(By.cssSelector(SELETOR_AVALIACAO));
        driver.findElement(By.cssSelector(SELETOR_AVALIACAO)).click();
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
