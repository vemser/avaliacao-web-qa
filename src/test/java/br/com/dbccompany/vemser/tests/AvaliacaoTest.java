package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.AcompanhamentosPage;
import br.com.dbccompany.vemser.pages.ColaboradoresPage;
import br.com.dbccompany.vemser.pages.CriarFeedBackPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.pages.MenuPage;
import br.com.dbccompany.vemser.pages.TecnicoFeedbackPage;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.dataFactory.DataFactory;
import br.com.dbcompany.vemser.service.ColaboradorService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class AvaliacaoTest extends Navegador {
    private static LoginPage loginPage = new LoginPage();
    public static ColaboradoresPage estagiariosPage = new ColaboradoresPage();
    private static String nomeEstagiario;
    private static String idAvaliacao;

    @BeforeAll
    public static void loginEBuscarMassa() {
        loginPage.realizarLoginComSucesso();
        AcessoPage.estaNaPaginaAcesso();
        estagiariosPage.acessarPagina();
        nomeEstagiario = ColaboradorService.buscarNomeEstagiarioTesteFluxoAvaliacao();
    }

    @AfterAll
    public static void limparMassa() {
        ColaboradorService.deletarFeedBacksByIdAvaliacao(Integer.parseInt(idAvaliacao));
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
        Assertions.assertEquals("criando feedback", MenuPage.consultarTituloAtual());
        CriarFeedBackPage.clicarTipoFeedback();
        CriarFeedBackPage.selecionarTipoFeedback(0);
        CriarFeedBackPage.preencherCampoDescricao("Aluno atendeu às expectativas.");
        CriarFeedBackPage.preencherCampoNota("70");
        CriarFeedBackPage.clicarBotaoCadastrar();
        TecnicoFeedbackPage.Modal.esperarModalAbrir();
        Assertions.assertEquals("Feedback cadastrado com sucesso!", TecnicoFeedbackPage.Modal.consultarMensagemModal());
        TecnicoFeedbackPage.Modal.fecharModal();
        String url = TecnicoFeedbackPage.consultarUrl();
        idAvaliacao = url.substring(url.lastIndexOf('/') + 1);
        MenuPage.clicarBotaoComportamental();
        MenuPage.clicarBotaoAcompanhamentos();
        Assertions.assertEquals("acompanhamentos", MenuPage.consultarTituloAtual());
        AcompanhamentosPage.Busca.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        AcompanhamentosPage.Busca.esperarBuscaPorNome(nomeEstagiario);
        AcompanhamentosPage.Tabela.clicarBotaoDetalhes();
        AcompanhamentosPage.clicarBotaoAgendarHorario();
        AcompanhamentosPage.clicarBotaoSelecionarDia();
        AcompanhamentosPage.selecionarOpcaoDia(0);
        AcompanhamentosPage.clicarBotaoSelecionarHorario();
        AcompanhamentosPage.selecionarOpcaoHorario(0);
        AcompanhamentosPage.clicarBotaoAgendar();
        AcompanhamentosPage.Modal.esperarModalAbrir();
        Assertions.assertEquals("Agendamento realizado com sucesso!", AcompanhamentosPage.Modal.consultarMensagemModal());
        AcompanhamentosPage.Modal.fecharModal();
        AcompanhamentosPage.Busca.filtrarEstagiarioPorNome(nomeEstagiario + Keys.ENTER);
        AcompanhamentosPage.Busca.esperarBuscaPorNome(nomeEstagiario);
        AcompanhamentosPage.Tabela.clicarBotaoDetalhes();
        AcompanhamentosPage.clicarBotaoAvaliarEstagiario();
        CriarFeedBackPage.clicarTipoFeedback();
        CriarFeedBackPage.selecionarTipoFeedback(0);
        CriarFeedBackPage.preencherCampoDescricao("Aluno atendeu às expectativas.");
        CriarFeedBackPage.preencherCampoNota("90");
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
        AcompanhamentosPage.Modal.esperarModalAbrir();
        Assertions.assertEquals("Agendamento Deletado com sucesso!", AcompanhamentosPage.Modal.consultarMensagemModal());
        AcompanhamentosPage.Modal.fecharModal();
    }
}
