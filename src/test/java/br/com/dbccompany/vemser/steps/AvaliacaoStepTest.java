package br.com.dbccompany.vemser.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.AcompanhamentosPage;
import br.com.dbccompany.vemser.pages.ConfiguracoesPage;
import br.com.dbccompany.vemser.pages.EstagiariosCadastroPage;
import br.com.dbccompany.vemser.pages.EstagiariosInformacoesPage;
import br.com.dbccompany.vemser.pages.EstagiariosPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.pages.MenuPage;
import br.com.dbccompany.vemser.pages.TecnicoFeedbackPage;
import br.com.dbccompany.vemser.utils.Navegador;
import dataFactory.DataFactory;
import dataFactory.EstagiarioDataFactory;
import model.EstagiarioModel;
import service.EstagiarioService;

public class AvaliacaoStepTest extends Navegador {
    private static AcompanhamentosPage acompanhamentosPage = new AcompanhamentosPage();
    private static LoginPage loginPage = new LoginPage();
    private static AcessoPage acessoPage = new AcessoPage();
    private static MenuPage menuPage = new MenuPage();
    private ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static EstagiariosInformacoesPage estagiariosInformacoesPage = new EstagiariosInformacoesPage();
    private static TecnicoFeedbackPage tecnicoFeedbackPage = new TecnicoFeedbackPage();
    private static String nomeEstagiario;
    private static String idFeedBackTecnico;
    private static String idFeedBackComportamental;
    @BeforeAll
    public static void loginEBuscarMassa() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        estagiariosPage.acessarPagina();
        nomeEstagiario = EstagiarioService.buscarNomeEstagiarioTesteFluxoAvaliacao();
    }
    @AfterAll
    public static void limparMassa() {
        EstagiarioService.deletarFeedBackById(Integer.parseInt(idFeedBackTecnico));
    }
    @Test
    public void testFluxoDeAvaliacaoComSucesso() {
        menuPage.clicarBotaoTecnico();
        menuPage.clicarBotaoTecnicoFeedback();
        tecnicoFeedbackPage.clicarAcompanhamento();
        estagiariosPage.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        estagiariosPage.esperarBuscaPorNome(nomeEstagiario);
        tecnicoFeedbackPage.clicarPrimeiroBotaoDetalhes();
        tecnicoFeedbackPage.clicarBotaoAvaliar();
        tecnicoFeedbackPage.clicarTipoFeedback();
        tecnicoFeedbackPage.selecionarTipoFeedback(0);
        tecnicoFeedbackPage.preencherCampoDescricao("Aluno atendeu às expectativas.");
        tecnicoFeedbackPage.preencherCampoNota(DataFactory.gerarNotaPositiva());
        tecnicoFeedbackPage.clicarBotaoCadastrar();
        tecnicoFeedbackPage.esperarModalAbrir();
        tecnicoFeedbackPage.fecharModal();
        idFeedBackTecnico = tecnicoFeedbackPage.pegarIdFeedback();
        menuPage.clicarBotaoComportamental();
        menuPage.clicarBotaoAcompanhamentos();
        estagiariosPage.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        estagiariosPage.esperarBuscaPorNome(nomeEstagiario);
        tecnicoFeedbackPage.clicarPrimeiroBotaoDetalhes();
        acompanhamentosPage.clicarBotaoAgendarHorario();
        acompanhamentosPage.clicarBotaoSelecionarDia();
        acompanhamentosPage.selecionarOpcaoDia(0);
        acompanhamentosPage.clicarBotaoSelecionarHorario();
        acompanhamentosPage.selecionarOpcaoHorario(0);
    }
}
