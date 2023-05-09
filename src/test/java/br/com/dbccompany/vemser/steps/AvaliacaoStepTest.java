package br.com.dbccompany.vemser.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.AcompanhamentosPage;
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
    private static LoginPage loginPage = new LoginPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static String nomeEstagiario;
    private static String idAvaliacao;
    @BeforeAll
    public static void loginEBuscarMassa() {
        loginPage.realizarLoginComSucesso();
        AcessoPage.estaNaPaginaAcesso();
        estagiariosPage.acessarPagina();
        nomeEstagiario = EstagiarioService.buscarNomeEstagiarioTesteFluxoAvaliacao();
    }
    @AfterAll
    public static void limparMassa() {
        EstagiarioService.deletarFeedBacksByIdAvaliacao(Integer.parseInt(idAvaliacao));
    }
    @Test
    public void testFluxoDeAvaliacaoComSucesso() {
        MenuPage.clicarBotaoTecnico();
        MenuPage.clicarBotaoTecnicoFeedback();
        TecnicoFeedbackPage.clicarAcompanhamento();
        TecnicoFeedbackPage.Busca.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        TecnicoFeedbackPage.Busca.esperarBuscaPorNome(nomeEstagiario);
        TecnicoFeedbackPage.Tabela.clicarBotaoDetalhes();
        TecnicoFeedbackPage.clicarBotaoAvaliar();
        CriarFeedBackPage.clicarTipoFeedback();
        CriarFeedBackPage.selecionarTipoFeedback(0);
        CriarFeedBackPage.preencherCampoDescricao("Aluno atendeu às expectativas.");
        CriarFeedBackPage.preencherCampoNota(DataFactory.gerarNotaPositiva());
        CriarFeedBackPage.clicarBotaoCadastrar();
        TecnicoFeedbackPage.Modal.esperarModalAbrir();
        TecnicoFeedbackPage.Modal.fecharModal();
        String url = TecnicoFeedbackPage.consultarUrl();
        idAvaliacao = url.substring(url.lastIndexOf('/') + 1);
        MenuPage.clicarBotaoComportamental();
        MenuPage.clicarBotaoAcompanhamentos();
        AcompanhamentosPage.Busca.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        AcompanhamentosPage.Busca.esperarBuscaPorNome(nomeEstagiario);
        AcompanhamentosPage.Tabela.clicarBotaoDetalhes();
        AcompanhamentosPage.clicarBotaoAgendarHorario();
        AcompanhamentosPage.clicarBotaoSelecionarDia();
        AcompanhamentosPage.selecionarOpcaoDia(2);
        AcompanhamentosPage.clicarBotaoSelecionarHorario();
        AcompanhamentosPage.selecionarOpcaoHorario(1);
        AcompanhamentosPage.clicarBotaoAgendar();
        AcompanhamentosPage.Modal.esperarModalAbrir();
        AcompanhamentosPage.Modal.fecharModal();
        AcompanhamentosPage.Busca.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        AcompanhamentosPage.Busca.esperarBuscaPorNome(nomeEstagiario);
        AcompanhamentosPage.Tabela.clicarBotaoDetalhes();
        AcompanhamentosPage.clicarBotaoAvaliarEstagiario();
        CriarFeedBackPage.clicarTipoFeedback();
        CriarFeedBackPage.selecionarTipoFeedback(0);
        CriarFeedBackPage.preencherCampoDescricao("Aluno atendeu às expectativas.");
        CriarFeedBackPage.preencherCampoNota(DataFactory.gerarNotaPositiva());
        CriarFeedBackPage.preencherCampoObjetivo("Aluno com objetivo de se tornar um grande programador.");
        CriarFeedBackPage.preencherCampoRecomendacao("Recomendo ao aluno realizar cursos de programação no LinkedIn Learning.");
        CriarFeedBackPage.clicarTipoStatus();
        CriarFeedBackPage.selecionarTipoStatus(0);
        CriarFeedBackPage.clicarBotaoCadastrar();
        AcompanhamentosPage.Modal.esperarModalAbrir();
        AcompanhamentosPage.Modal.fecharModal();
        AcompanhamentosPage.Busca.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        AcompanhamentosPage.Busca.esperarBuscaPorNome(nomeEstagiario);
        AcompanhamentosPage.Tabela.clicarBotaoDetalhes();
        AcompanhamentosPage.clicarBotaoCancelarAgendamento();
        AcompanhamentosPage.clicarBotaoConfirmarCancelarAgendamento();
    }
}
