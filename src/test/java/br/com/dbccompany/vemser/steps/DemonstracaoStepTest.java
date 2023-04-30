package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import dataFactory.EstagiarioDataFactory;
import model.EstagiarioModel;
import service.EstagiarioService;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemonstracaoStepTest extends Navegador {
    private static LoginPage loginPage = new LoginPage();
    private static AcessoPage acessoPage = new AcessoPage();
    private static MenuPage menuPage = new MenuPage();
    private ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static EstagiariosInformacoesPage estagiariosInformacoesPage = new EstagiariosInformacoesPage();
    public void timer(int milisegundos) {
        configuracoesPage.esperarTempo(milisegundos);
    }
    public void timerCurto() {
        timer(500);
    }
    public void timerMedio() {
        timer(1000);
    }
    @Test
    @Disabled
    @DisplayName("Demonstração do sistema")
    public void testeDemonstracao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        // navegar pelo menu
        menuPage.acessarPagina();
        timerCurto();
        menuPage.clicarBotaoDashboard();
        timerMedio();
        menuPage.clicarBotaoEstagiarios();
        timerMedio();
        menuPage.clicarBotaoComportamental();
        timerMedio();
        menuPage.clicarBotaoAcompanhamentos();
        timerMedio();
        menuPage.clicarBotaoTecnico();
        timerMedio();
        menuPage.clicarBotaoTecnicoFeedback();
        timerMedio();
        menuPage.clicarBotaoConfiguracoes();
        timerMedio();
        // cadastrar estagiário
        menuPage.clicarBotaoEstagiarios();
        timerMedio();
        timerMedio();
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
        timerCurto();
        estagiariosCadastroPage.selecionarOpcaoPrograma(0);
        estagiariosCadastroPage.clicarSelecionarTrilha();
        timerCurto();
        estagiariosCadastroPage.selecionarOpcaoTrilha(0);
        estagiariosCadastroPage.clicarSelecionarStatus();
        timerCurto();
        estagiariosCadastroPage.selecionarOpcaoStatus(0);
        estagiariosCadastroPage.clicarBotaoCadastrar();
        estagiariosPage.fecharModal();
        timerMedio();
        // consultar por nome
        estagiariosPage.filtrarEstagiarioPorNome(estagiario.getNome());
        estagiariosPage.clicarBotaoBuscar();
        estagiariosPage.esperarBuscaPorNome(estagiario.getNome());
        timerMedio();
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        timerMedio();
        // alterar nome do estagiário
        estagiariosPage.clicarBotaoEditarEstagiario();
        estagiario.setNome(estagiario.getNome() + " Editado");
        estagiariosCadastroPage.esperarBuscaDeCandidatoValido();
        estagiariosCadastroPage.limparCampoNome();
        estagiariosCadastroPage.preencherCampoNome(" Editado");
        timerMedio();
        estagiariosCadastroPage.clicarBotaoEditar();
        estagiariosPage.fecharModal();
        // consultar por nome
        timerCurto();
        estagiariosPage.filtrarEstagiarioPorNome(estagiario.getNome());
        timerMedio();
        estagiariosPage.clicarBotaoBuscar();
        timerMedio();
        estagiariosPage.esperarBuscaPorNome(estagiario.getNome());
        timerMedio();
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        // desativar estagiário
        timerMedio();
        estagiariosInformacoesPage.clicarBotaoDesativarEstagiario();
        timerMedio();
        estagiariosPage.preencherCampoMotivoDesativacaoValido();
        estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
        timerMedio();
    }
    @AfterAll
    public static void limparMassa() {
        EstagiarioService.deletarEstagiariosTeste();
    }
}
