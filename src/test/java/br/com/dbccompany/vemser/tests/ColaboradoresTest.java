package br.com.dbccompany.vemser.tests;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.dataFactory.EstagiarioDataFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import br.com.dbcompany.vemser.model.EstagiarioModel;

import org.junit.jupiter.api.*;

public class ColaboradoresTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    public static ColaboradoresPage colaboradoresPage = new ColaboradoresPage();
    private static ColaboradoresCadastroPage colaboradoresCadastroPage = new ColaboradoresCadastroPage();
    private static ColaboradoresInformacoesPage colaboradoresInformacoesPage = new ColaboradoresInformacoesPage();
    private static LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
    }

    @Nested
    class ConsultaColaboradores {
        @BeforeEach
        public void acessarPaginaEstagiarios() {
            colaboradoresPage.acessarPagina();
        }
        @Test
        @Disabled
        @Story("Consulta de Estagiários")
        @Description("Consulta de detalhes de informações de Estagiários")
        @DisplayName("Consulta de detalhes de informações de Estagiários")
        public void testConsultaEstagiarioPorId() {
            //Verifica os 10 primeiros estagiários
            colaboradoresPage.consultarIdsEstagiarios()
                .forEach(id -> {
                    String nomeEstagiario = colaboradoresPage.consultarNomeEstagiarioPorId(id);
                    System.out.println("Nome do estagiário: " + nomeEstagiario);
                    System.out.println("Id do estagiário: " + id);
                    colaboradoresPage.clicarBotaoDetalhesDoEstagiarioPorId(id);
                    Assertions.assertEquals(nomeEstagiario, colaboradoresInformacoesPage.consultarNomeEstagiario());
                    colaboradoresInformacoesPage.clicarBotaoVoltarParaLista();
                });
        }
        @Test
        @Story("Consulta de Estagiários")
        @Description("Consulta de estagiários por nome")
        @DisplayName("Consulta de estagiários por nome")
        public void testConsultarEstagiarioPorNome() {
            String nome = colaboradoresPage.consultarNomeEstagiarioInformacoes();
            colaboradoresPage.filtrarEstagiarioPorNomeValido();
            colaboradoresPage.clicarBotaoBuscar();
            colaboradoresPage.esperarBuscaPorNome(nome);
            Assertions.assertEquals(nome, colaboradoresPage.consultarNomeEstagiarioInformacoes());
        }
    }
    @Nested
    class CadastroEstagiario {
        @BeforeEach
        public void acessarPaginaCadastroEstagiario() {
            colaboradoresPage.acessarPagina();
            colaboradoresPage.clicarBotaoCadastroEstagiario();
        }
        @Test
        @Story("Cadastro de Estagiários")
        @Description("Cadastro de Estagiários manualmente com sucesso")
        @DisplayName("Cadastro de Estagiários manualmente com sucesso")
        public void testCadastroEstagiarioManual() {
            EstagiarioModel estagiario = EstagiarioDataFactory.gerarEstagiarioValido(1);
            Assertions.assertTrue(colaboradoresCadastroPage.estaNaPaginaCadastroEstagiario());
            colaboradoresCadastroPage.preencherCampoNome(estagiario.getNome());
            colaboradoresCadastroPage.preencherCampoCpf(estagiario.getCpf());
            colaboradoresCadastroPage.preencherCampoEmailPessoal(estagiario.getEmailPessoal());
            colaboradoresCadastroPage.preencherCampoEmailCorporativo(estagiario.getEmailCorporativo());
            colaboradoresCadastroPage.preencherCampoTelefone(estagiario.getTelefone());
            colaboradoresCadastroPage.preencherCampoDataNascimento(estagiario.getDataNascimento());
            colaboradoresCadastroPage.preencherCampoEstado(estagiario.getEstado());
            colaboradoresCadastroPage.preencherCampoCidade(estagiario.getCidade());
            colaboradoresCadastroPage.preencherCampoInstituicaoEnsino(estagiario.getInstituicaoEnsino());
            colaboradoresCadastroPage.preencherCampoCurso(estagiario.getCurso());
            colaboradoresCadastroPage.preencherCampoGithub(estagiario.getGithub());
            colaboradoresCadastroPage.preencherCampoLinkedin(estagiario.getLinkedin());
            colaboradoresCadastroPage.preencherCampoObservacoes(estagiario.getObservacoes());
            colaboradoresCadastroPage.clicarSelecionarPrograma();
            colaboradoresCadastroPage.selecionarOpcaoPrograma(0);
            colaboradoresCadastroPage.clicarSelecionarTrilha();
            colaboradoresCadastroPage.selecionarOpcaoTrilha(0);
            colaboradoresCadastroPage.clicarSelecionarStatus();
            colaboradoresCadastroPage.selecionarOpcaoStatus(0);
            colaboradoresCadastroPage.clicarBotaoCadastrar();
            Assertions.assertTrue(colaboradoresPage.estaNaPaginaEstagiarios());
            Assertions.assertTrue(colaboradoresPage.existeMensagemModal());
            colaboradoresPage.fecharModal();
            colaboradoresPage.filtrarEstagiarioPorNome(estagiario.getNome());
            colaboradoresPage.clicarBotaoBuscar();
            colaboradoresPage.esperarBuscaPorNome(estagiario.getNome());
            Assertions.assertEquals(estagiario.getNome(), colaboradoresPage.consultarNomeEstagiarioInformacoes());
            colaboradoresPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
            colaboradoresInformacoesPage.clicarBotaoDesativarEstagiario();
            colaboradoresPage.preencherCampoMotivoDesativacaoValido();
            colaboradoresPage.clicarBotaoConfirmarDesativarEstagiario();
            Assertions.assertTrue(colaboradoresPage.existeMensagemModal());
    }

    @Nested
    class DesativarEstagiario {
        @Test
        @Story("Desativar de Estagiários")
        @Description("Desativar de Estagiários com sucesso")
        @DisplayName("Desativar de Estagiários com sucesso")
        public void testDesativarEstagiario() {
            colaboradoresPage.acessarPagina();
            colaboradoresPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
            colaboradoresInformacoesPage.clicarBotaoDesativarEstagiario();
            colaboradoresPage.preencherCampoMotivoDesativacaoValido();
            colaboradoresPage.clicarBotaoConfirmarDesativarEstagiario();
            Assertions.assertTrue(colaboradoresPage.existeMensagemModal());
        }
    }
  }
}
