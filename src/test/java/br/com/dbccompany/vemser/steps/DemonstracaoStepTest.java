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
    private static ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static EstagiariosInformacoesPage estagiariosInformacoesPage = new EstagiariosInformacoesPage();
    @Test
    @Disabled
    @DisplayName("Demonstração do sistema")
    public void testeDemonstracao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        // navegar pelo menu
        menuPage.acessarPagina();
        menuPage.clicarBotaoDashboard();
        menuPage.clicarBotaoEstagiarios();
        menuPage.clicarBotaoComportamental();
        menuPage.clicarBotaoAcompanhamentos();
        menuPage.clicarBotaoTecnico();
        menuPage.clicarBotaoTecnicoFeedback();
        menuPage.clicarBotaoConfiguracoes();
        // cadastrar estagiário
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
        estagiariosPage.fecharModal();
        // consultar por nome
        estagiariosPage.filtrarEstagiarioPorNome(estagiario.getNome());
        estagiariosPage.clicarBotaoBuscar();
        estagiariosPage.esperarBuscaPorNome(estagiario.getNome());
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        // alterar nome do estagiário
        estagiariosPage.clicarBotaoEditarEstagiario();
        estagiario.setNome(estagiario.getNome() + " Editado");
        estagiariosCadastroPage.esperarBuscaDeCandidatoValido();
        estagiariosCadastroPage.limparCampoNome();
        estagiariosCadastroPage.preencherCampoNome(" Editado");
        estagiariosCadastroPage.clicarBotaoEditar();
        estagiariosPage.fecharModal();
        // consultar por nome
        estagiariosPage.filtrarEstagiarioPorNome(estagiario.getNome());
        estagiariosPage.clicarBotaoBuscar();
        estagiariosPage.esperarBuscaPorNome(estagiario.getNome());
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        // desativar estagiário
        estagiariosInformacoesPage.clicarBotaoDesativarEstagiario();
        estagiariosPage.preencherCampoMotivoDesativacaoValido();
        estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
    }
    @AfterAll
    public static void limparMassa() {
        EstagiarioService.deletarEstagiariosTeste();
    }
}
