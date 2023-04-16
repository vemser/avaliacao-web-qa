package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class EstagiariosStepTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
    }
    @Nested
    class ConsultaEstagiarios {
        @BeforeEach
        public void acessarPaginaEstagiarios() {
            estagiariosPage.acessarPagina();
        }
        @Test
        @Story("Consulta de Estagiários")
        @Description("Consulta de detalhes de informações de Estagiários")
        @DisplayName("Consulta de detalhes de informações de Estagiários")
        public void testConsultaEstagiarioPorId() {
            //Verifica os 10 primeiros estagiários
            estagiariosPage.consultarIdsEstagiarios()
                .forEach(id -> {
                    String nomeEstagiario = estagiariosPage.consultarNomeEstagiarioPorId(id);
                    estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorId(id);
                    Assertions.assertEquals(estagiariosPage.URL_PAGINA+"/informacoes", estagiariosPage.consultarUrl());
                    Assertions.assertEquals(nomeEstagiario, estagiariosPage.consultarNomeEstagiarioInformacoes());
                    estagiariosPage.clicarBotaoVoltarParaLista();
                    Assertions.assertTrue(estagiariosPage.estaNaPaginaEstagiarios());
                });
        }
    }
    @Nested
    class CadastroEstagiario {
        @BeforeEach
        public void acessarPaginaCadastroEstagiario() {
            estagiariosPage.acessarPagina();
            estagiariosPage.clicarBotaoCadastroEstagiario();
        }
        @Test
        @Story("Cadastro de Estagiários")
        @Description("Cadastro de Estagiários manualmente com sucesso")
        @DisplayName("Cadastro de Estagiários manualmente com sucesso")
        public void testCadastroEstagiarioManual() {
            Assertions.assertTrue(estagiariosCadastroPage.estaNaPaginaCadastroEstagiario());
            estagiariosCadastroPage.preencherCampoNomeValido();
            estagiariosCadastroPage.preencherCampoCpfValido();
            estagiariosCadastroPage.preencherCampoEmailPessoalValido();
            estagiariosCadastroPage.preencherCampoEmailCorporativoValido();
            estagiariosCadastroPage.preencherCampoTelefoneValido();
            estagiariosCadastroPage.preencherCampoDataNascimentoValido();
            estagiariosCadastroPage.preencherCampoEstadoValido();
            estagiariosCadastroPage.preencherCampoCidadeValido();
            estagiariosCadastroPage.preencherCampoInstituicaoEnsinoValido();
            estagiariosCadastroPage.preencherCampoCursoValido();
            estagiariosCadastroPage.preencherCampoGithubValido();
            estagiariosCadastroPage.preencherCampoLinkedinValido();
            estagiariosCadastroPage.preencherCampoObservacoesValido();
            estagiariosCadastroPage.clicarSelecionarPrograma();
            estagiariosCadastroPage.selecionarOpcaoPrograma(0);
            estagiariosCadastroPage.clicarSelecionarTrilha();
            estagiariosCadastroPage.selecionarOpcaoTrilha(0);
            estagiariosCadastroPage.clicarSelecionarStatus();
            estagiariosCadastroPage.selecionarOpcaoStatus(0);
            estagiariosCadastroPage.clicarBotaoCadastrar();
            Assertions.assertTrue(estagiariosPage.estaNaPaginaEstagiarios());
            Assertions.assertTrue(estagiariosPage.existeMensagemModal());
        }

        @ParameterizedTest(name = "Candidato {index}- CPF: {0}")
        @Story("Cadastro de Estagiários")
        @Description("Cadastro de Estagiários por busca de candidato")
        @DisplayName("Cadastro de Estagiários por busca de candidato")
        @MethodSource("dataFactory.DataFactory#provideCandidatosEdicaoAtual")
        public void testCadastroEstagiarioPorBuscaCandidato(String cpfCandidato, String nomeCandidato, String emailCandidato) {
            Assertions.assertTrue(estagiariosCadastroPage.estaNaPaginaCadastroEstagiario());
            estagiariosCadastroPage.preencherCampoBuscaCpf(cpfCandidato);
            estagiariosCadastroPage.clicarBotaoBuscaCpf();
            Assertions.assertEquals(nomeCandidato, estagiariosCadastroPage.consultarCampoNome());
            Assertions.assertEquals(emailCandidato, estagiariosCadastroPage.consultarCampoEmailPessoal());
        }

        @ParameterizedTest(name = "Candidato inválido {index}- CPF: {0}")
        @Story("Cadastro de Estagiários")
        @Description("Cadastro de Estagiários por busca de CPF não cadastrado")
        @DisplayName("Cadastro de Estagiários por busca de CPF não cadastrado")
        @MethodSource("dataFactory.DataFactory#provideCpfNaoCadastradoNaEdicaoAtual")
        public void testCadastroEstagiarioPorBuscaDeCpfNaoCadastrado(String cpfCandidatoInvalido) {
            Assertions.assertTrue(estagiariosCadastroPage.estaNaPaginaCadastroEstagiario());
            estagiariosCadastroPage.preencherCampoBuscaCpf(cpfCandidatoInvalido);
            estagiariosCadastroPage.clicarBotaoBuscaCpf();
            Assertions.assertTrue(estagiariosCadastroPage.existeMensagemDeCpfNaoEncontrado());
        }
    }
    @Nested
    class DesativarEstagiario {
        @Test
        @Story("Desativar de Estagiários")
        @Description("Desativar de Estagiários com sucesso")
        @DisplayName("Desativar de Estagiários com sucesso")
        public void testDesativarEstagiario() {
            estagiariosPage.acessarPagina();
            estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorId("1");
            estagiariosPage.clicarBotaoDesativarEstagiario();
            estagiariosPage.preencherCampoMotivoDesativacaoValido();
            estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
            Assertions.assertTrue(estagiariosPage.existeMensagemModal());
        }
    }
}
