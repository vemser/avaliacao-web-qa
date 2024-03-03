package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.ConfiguracoesPage;
import br.com.dbccompany.vemser.pages.CriaProgramaPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.pages.MenuPage;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.dataFactory.CriarProgramaData;
import br.com.dbcompany.vemser.model.CriaProgramaModel;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CriaProgramaTest extends Navegador {
    CriaProgramaPage programaPage = new CriaProgramaPage();
    LoginPage login = new LoginPage();
    MenuPage menu = new MenuPage();
    ConfiguracoesPage configuracoes = new ConfiguracoesPage();

    public void fluxoDeLoginEPrograma(){
        login.fluxoDeLoginHighCredentials();
        menu.clicarBotaoConfiguracoes();
        configuracoes.clicarBotaoProgramasConfig();
        configuracoes.clicarBtnCriarPrograma();
    }

    @Test
    @DisplayName("Validar criar programa com sucesso")
    @Story("Validar criar programa com sucesso")
    @Description("Validar criar programa com sucesso")
    public void criarProgramaComSucesso(){
        CriaProgramaModel programa = CriarProgramaData.programaValido();
        fluxoDeLoginEPrograma();
        programaPage.preencherPrograma(programa);
        String mensagem = programaPage.mensagensModal();
        Assertions.assertEquals("Programa cadastrado com sucesso!", mensagem);
    }

    @Test
    @DisplayName("Invalidar criar programa com nome repetido")
    @Story("Criar programa")
    @Description("Validar criar programa com sucesso")
    public void criarProgramaComNomeRepetido(){
        CriaProgramaModel programa = CriarProgramaData.programaComNomeRepetido();
        fluxoDeLoginEPrograma();
        programaPage.preencherPrograma(programa);
        String mensagem = programaPage.mensagensModal();
        Assertions.assertEquals("Já há um programa com esse nome cadastrado!", mensagem);
    }
}
