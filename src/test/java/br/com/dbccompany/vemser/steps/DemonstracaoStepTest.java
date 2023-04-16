package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DemonstracaoStepTest extends Navegador {
    private static LoginPage loginPage = new LoginPage();
    private static AcessoPage acessoPage = new AcessoPage();
    private static MenuPage menuPage = new MenuPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    @Test
    @DisplayName("Demonstração CRUD Estagiários")
    public void testDemonstracaoCRUDEstagiarios() {
        int delay = 250;
        //region Acessar página de login
        loginPage.acessarPagina();
        loginPage.esperarTempo(delay);
        loginPage.realizarLoginComSucesso();
        loginPage.esperarTempo(delay);
        acessoPage.clicarBotaoAvaliacao();
        loginPage.esperarTempo(delay);
        menuPage.clicarBotaoEstagiarios();
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarBotaoCadastroEstagiario();
        loginPage.esperarTempo(delay);
        // endregion Acessar página de login
        // region Cadastrar Estagiário
        estagiariosCadastroPage.preencherCampoNomeValido();
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
        estagiariosCadastroPage.preencherCampoEstadoValido();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoCidadeValido();
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
//        estagiariosCadastroPage.clicarBotaoCadastrar();
        estagiariosPage.acessarPagina();
        loginPage.esperarTempo(delay);
        // endregion
        // region Consultar Estagiário
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorId("0");
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarAbaInformacoesDoPrograma();
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarAbaAcompanhamentosDoEstagiario();
        loginPage.esperarTempo(delay);
        // endregion
        // region Editar Estagiário
        estagiariosCadastroPage.limparCampoNome();
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.preencherCampoNome("Nome Editado Do Estagiário");
        loginPage.esperarTempo(delay);
        estagiariosCadastroPage.clicarBotaoEditar();
        loginPage.esperarTempo(delay);
        // endregion
        // region Desativar Estagiário
        estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorId("0");
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarBotaoDesativarEstagiario();
        loginPage.esperarTempo(delay);
        estagiariosPage.preencherCampoMotivoDesativacaoValido();
        loginPage.esperarTempo(delay);
        estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
        loginPage.esperarTempo(delay);
        // endregion
    }
}
