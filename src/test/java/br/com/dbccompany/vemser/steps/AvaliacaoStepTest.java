package br.com.dbccompany.vemser.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import br.com.dbccompany.vemser.pages.AcessoPage;
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
    private static LoginPage loginPage = new LoginPage();
    private static AcessoPage acessoPage = new AcessoPage();
    private static MenuPage menuPage = new MenuPage();
    private ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static EstagiariosInformacoesPage estagiariosInformacoesPage = new EstagiariosInformacoesPage();
    private static TecnicoFeedbackPage tecnicoFeedbackPage = new TecnicoFeedbackPage();
    private static String nomeEstagiario;
    @BeforeAll
    public static void loginECriarMassa() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        estagiariosPage.acessarPagina();
        estagiariosPage.clicarBotaoCadastroEstagiario();
        EstagiarioModel estagiario = EstagiarioDataFactory.gerarEstagiarioValido(1);
        estagiariosCadastroPage.preencherCampoNome(estagiario.getNome());
        estagiariosCadastroPage.preencherCampoCpf(estagiario.getCpf());
        estagiariosCadastroPage.preencherCampoEmailPessoal(estagiario.getEmailPessoal());
        estagiariosCadastroPage.preencherCampoEmailCorporativo(estagiario.getEmailCorporativo());
        estagiariosCadastroPage.preencherCampoTelefone(estagiario.getTelefone());
        estagiariosCadastroPage.preencherCampoDataNascimento(estagiario.getDataNascimento());
        estagiariosCadastroPage.preencherCampoEstado(estagiario.getEstado());
        estagiariosCadastroPage.preencherCampoCidade(estagiario.getCidade());
        estagiariosCadastroPage.preencherCampoInstituicaoEnsino(estagiario.getInstituicaoEnsino());
        estagiariosCadastroPage.preencherCampoCurso(estagiario.getCurso());
        estagiariosCadastroPage.preencherCampoGithub(estagiario.getGithub());
        estagiariosCadastroPage.preencherCampoLinkedin(estagiario.getLinkedin());
        estagiariosCadastroPage.preencherCampoObservacoes(estagiario.getObservacoes());
        estagiariosCadastroPage.clicarSelecionarPrograma();
        estagiariosCadastroPage.selecionarOpcaoPrograma(0);
        estagiariosCadastroPage.clicarSelecionarTrilha();
        estagiariosCadastroPage.selecionarOpcaoTrilha(0);
        estagiariosCadastroPage.clicarSelecionarStatus();
        estagiariosCadastroPage.selecionarOpcaoStatus(0);
        estagiariosCadastroPage.clicarBotaoCadastrar();
        Assertions.assertTrue(estagiariosPage.existeMensagemModal());
        estagiariosPage.fecharModal();
        nomeEstagiario = estagiario.getNome();
    }
    @AfterAll
    public static void limparMassa() {
        EstagiarioService.deletarEstagiariosTeste();
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
    }
}
