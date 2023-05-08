package br.com.dbccompany.vemser.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.AcompanhamentosPage;
import br.com.dbccompany.vemser.pages.ConfiguracoesPage;
import br.com.dbccompany.vemser.pages.CriarFeedBackPage;
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
    private static CriarFeedBackPage criarFeedBackPage = new CriarFeedBackPage();
    private static String nomeEstagiario;
    private static String idAvaliacao;
    @BeforeAll
    public static void loginEBuscarMassa() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        estagiariosPage.acessarPagina();
        nomeEstagiario = EstagiarioService.buscarNomeEstagiarioTesteFluxoAvaliacao();
    }
    @AfterAll
    public static void limparMassa() {
        EstagiarioService.deletarFeedBacksByIdAvaliacao(Integer.parseInt(idAvaliacao));
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
        String url = tecnicoFeedbackPage.consultarUrl();
        idAvaliacao = url.substring(url.lastIndexOf('/') + 1);
        menuPage.clicarBotaoComportamental();
        menuPage.clicarBotaoAcompanhamentos();
        estagiariosPage.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        estagiariosPage.esperarBuscaPorNome(nomeEstagiario);
        tecnicoFeedbackPage.clicarPrimeiroBotaoDetalhes();
        acompanhamentosPage.clicarBotaoAgendarHorario();
        acompanhamentosPage.clicarBotaoSelecionarDia();
        acompanhamentosPage.selecionarOpcaoDia(1);
        acompanhamentosPage.clicarBotaoSelecionarHorario();
        acompanhamentosPage.selecionarOpcaoHorario(1);
        acompanhamentosPage.clicarBotaoAgendar();
        acompanhamentosPage.esperarModalAbrir();
        acompanhamentosPage.fecharModal();
        estagiariosPage.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        estagiariosPage.esperarBuscaPorNome(nomeEstagiario);
        tecnicoFeedbackPage.clicarPrimeiroBotaoDetalhes();
        acompanhamentosPage.clicarBotaoAvaliarEstagiario();
        criarFeedBackPage.clicarTipoFeedback();
        criarFeedBackPage.selecionarTipoFeedback(0);
        criarFeedBackPage.preencherCampoDescricao("Aluno atendeu às expectativas.");
        criarFeedBackPage.preencherCampoNota(DataFactory.gerarNotaPositiva());
        criarFeedBackPage.preencherCampoObjetivo("Aluno com objetivo de se tornar um grande programador.");
        criarFeedBackPage.preencherCampoRecomendacao("Recomendo ao aluno realizar cursos de programação no LinkedIn Learning.");
        criarFeedBackPage.clicarTipoStatus();
        criarFeedBackPage.selecionarTipoStatus(0);
        criarFeedBackPage.clicarBotaoCadastrar();
        acompanhamentosPage.esperarModalAbrir();
        acompanhamentosPage.fecharModal();
        estagiariosPage.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        estagiariosPage.esperarBuscaPorNome(nomeEstagiario);
        tecnicoFeedbackPage.clicarPrimeiroBotaoDetalhes();
        acompanhamentosPage.clicarBotaoCancelarAgendamento();
        acompanhamentosPage.clicarBotaoConfirmarCancelarAgendamento();
    }
}
