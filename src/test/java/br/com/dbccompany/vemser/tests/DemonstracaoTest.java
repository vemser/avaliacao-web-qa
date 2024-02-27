package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemonstracaoTest extends Navegador {

    private static LoginPage loginPage = new LoginPage();
    private static AcessoPage acessoPage = new AcessoPage();
    private static MenuPage menuPage = new MenuPage();
    private static ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static EstagiariosInformacoesPage estagiariosInformacoesPage = new EstagiariosInformacoesPage();

    @Test
    @Disabled
    @DisplayName("Demonstração CRUD Estagiários")
    public void testDemonstracaoCRUDEstagiarios() {
        int delay = 350;
        //region Acessar página de login
        loginPage.acessarPagina();
        loginPage.esperarTempo(delay);
        loginPage.realizarLoginComSucesso();
        loginPage.esperarTempo(delay);
        acessoPage.clicarBotaoAvaliacao();
        loginPage.esperarTempo(delay);
        // endregion Acessar página de login
        // region Navegar pelo menu
        menuPage.clicarBotaoDashboard();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoEstagiarios();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoComportamental();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoAcompanhamentos();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoTecnico();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoTecnicoFeedback();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoConfiguracoes();
        loginPage.esperarTempo(delay);
        configuracoesPage.clicarBotaoProgramasConfig();
        loginPage.esperarTempo(delay);
        // endregion
        // region Cadastrar Estagiário
        menuPage.clicarBotaoEstagiarios();
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarBotaoCadastroEstagiario();
        loginPage.esperarTempo(delay);
//        estagiariosCadastroPage.preencherCampoBuscaCpf("68426083765");
//        loginPage.esperarTempo(delay);
//        estagiariosCadastroPage.clicarBotaoBuscaCpf();
//        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoNome("Estagiário Original");
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoCpfValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoEmailPessoalValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoEmailCorporativoValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoTelefoneValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoDataNascimentoValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoEstado("PA");
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoCidade("Belém");
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoInstituicaoEnsinoValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoCursoValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoGithubValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoLinkedinValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoObservacoesValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.clicarSelecionarPrograma();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.selecionarOpcaoPrograma(0);
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.clicarSelecionarTrilha();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.selecionarOpcaoTrilha(0);
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.clicarSelecionarStatus();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.selecionarOpcaoStatus(0);
        loginPage.esperarTempo(delay);
//         estagiariosCadastroPage.clicarBotaoCadastrar();
        estagiariosPage.acessarPagina();
        loginPage.esperarTempo(delay);
        loginPage.esperarTempo(3000);
        menuPage.clicarBotaoEstagiarios();
        // endregion
        // region Editar Estagiário
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        estagiariosPage.clicarBotaoEditarEstagiario();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.limparCampoNome();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoNome(" Editado");
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.clicarBotaoEditar();
        loginPage.esperarTempo(delay);
        // endregion
        // region Consultar Estagiário
        menuPage.clicarBotaoEstagiarios();
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarAbaInformacoesDoPrograma();
        loginPage.esperarTempo(delay);
//        estagiariosPage.clicarAbaAcompanhamentosDoEstagiario();
//        loginPage.esperarTempo(delay);
        // endregion
        // region Desativar Estagiário
        menuPage.clicarBotaoEstagiarios();
//        estagiariosPage.esperarModalFechar();
        estagiariosPage.esperarTempo(3000);
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
        loginPage.esperarTempo(delay);
        estagiariosInformacoesPage.clicarBotaoDesativarEstagiario();
        loginPage.esperarTempo(delay);
        estagiariosPage.preencherCampoMotivoDesativacaoValido();
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
//        loginPage.esperarTempo(delay);
        loginPage.esperarTempo(3000);
        // endregion
    }
}
