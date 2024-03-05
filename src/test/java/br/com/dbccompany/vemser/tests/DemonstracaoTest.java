//package br.com.dbccompany.vemser.tests;
//
//import br.com.dbccompany.vemser.pages.*;
//import br.com.dbccompany.vemser.utils.Navegador;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//public class DemonstracaoTest extends Navegador {
//
//    private static LoginPage loginPage = new LoginPage();
//    private static AcessoPage acessoPage = new AcessoPage();
//    private static MenuPage menuPage = new MenuPage();
//    private static ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
//    public static ColaboradoresPage colaboradoresPage = new ColaboradoresPage();
//    private static ColaboradoresCadastroPage colaboradoresCadastroPage = new ColaboradoresCadastroPage();
//    private static ColaboradoresInformacoesPage colaboradoresInformacoesPage = new ColaboradoresInformacoesPage();
//
//    @Test
//    @Disabled
//    @DisplayName("Demonstração CRUD Estagiários")
//    public void testDemonstracaoCRUDEstagiarios() {
//        int delay = 350;
//        //region Acessar página de login
//        loginPage.acessarPagina();
//        loginPage.esperarTempo(delay);
//        loginPage.realizarLoginComSucesso();
//        loginPage.esperarTempo(delay);
//        acessoPage.clicarBotaoAvaliacao();
//        loginPage.esperarTempo(delay);
//        // endregion Acessar página de login
//        // region Navegar pelo menu
//        menuPage.clicarBotaoDashboard();
//        loginPage.esperarTempo(delay);
//        menuPage.clicarBotaoEstagiarios();
//        loginPage.esperarTempo(delay);
//        menuPage.clicarBotaoComportamental();
//        loginPage.esperarTempo(delay);
//        menuPage.clicarBotaoAcompanhamentos();
//        loginPage.esperarTempo(delay);
//        menuPage.clicarBotaoTecnico();
//        loginPage.esperarTempo(delay);
//        menuPage.clicarBotaoTecnicoFeedback();
//        loginPage.esperarTempo(delay);
//        menuPage.clicarBotaoConfiguracoes();
//        loginPage.esperarTempo(delay);
//        configuracoesPage.clicarBotaoProgramasConfig();
//        loginPage.esperarTempo(delay);
//        // endregion
//        // region Cadastrar Estagiário
//        menuPage.clicarBotaoEstagiarios();
//        loginPage.esperarTempo(delay);
//        colaboradoresPage.clicarBotaoCadastroEstagiario();
//        loginPage.esperarTempo(delay);
////        estagiariosCadastroPage.preencherCampoBuscaCpf("68426083765");
////        loginPage.esperarTempo(delay);
////        estagiariosCadastroPage.clicarBotaoBuscaCpf();
////        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoNome("Estagiário Original");
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoCpfValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoEmailPessoalValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoEmailCorporativoValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoTelefoneValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoDataNascimentoValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoEstado("PA");
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoCidade("Belém");
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoInstituicaoEnsinoValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoCursoValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoGithubValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoLinkedinValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoObservacoesValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.clicarSelecionarPrograma();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.selecionarOpcaoPrograma();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.clicarSelecionarTrilha();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.selecionarOpcaoTrilha(0);
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.clicarSelecionarStatus();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.selecionarOpcaoStatus(0);
//        loginPage.esperarTempo(delay);
////         estagiariosCadastroPage.clicarBotaoCadastrar();
//        colaboradoresPage.acessarPagina();
//        loginPage.esperarTempo(delay);
//        loginPage.esperarTempo(3000);
//        menuPage.clicarBotaoEstagiarios();
//        // endregion
//        // region Editar Estagiário
//        colaboradoresPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
//        colaboradoresPage.clicarBotaoEditarEstagiario();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.limparCampoNome();
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.preencherCampoNome(" Editado");
//        loginPage.esperarTempo(delay);
//        colaboradoresCadastroPage.clicarBotaoEditar();
//        loginPage.esperarTempo(delay);
//        // endregion
//        // region Consultar Estagiário
//        menuPage.clicarBotaoEstagiarios();
//        colaboradoresPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresPage.clicarAbaInformacoesDoPrograma();
//        loginPage.esperarTempo(delay);
////        estagiariosPage.clicarAbaAcompanhamentosDoEstagiario();
////        loginPage.esperarTempo(delay);
//        // endregion
//        // region Desativar Estagiário
//        menuPage.clicarBotaoEstagiarios();
////        estagiariosPage.esperarModalFechar();
//        colaboradoresPage.esperarTempo(3000);
//        colaboradoresPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresInformacoesPage.clicarBotaoDesativarEstagiario();
//        loginPage.esperarTempo(delay);
//        colaboradoresPage.preencherCampoMotivoDesativacaoValido();
//        loginPage.esperarTempo(delay);
//        colaboradoresPage.clicarBotaoConfirmarDesativarEstagiario();
////        loginPage.esperarTempo(delay);
//        loginPage.esperarTempo(3000);
//        // endregion
//    }
//}
