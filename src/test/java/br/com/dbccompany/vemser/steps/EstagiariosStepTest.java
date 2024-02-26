package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import br.com.dbcompany.vemser.dataFactory.EstagiarioDataFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import br.com.dbcompany.vemser.model.EstagiarioModel;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class EstagiariosStepTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    public static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static EstagiariosInformacoesPage estagiariosInformacoesPage = new EstagiariosInformacoesPage();
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
        @Disabled
        @Story("Consulta de Estagiários")
        @Description("Consulta de detalhes de informações de Estagiários")
        @DisplayName("Consulta de detalhes de informações de Estagiários")
        public void testConsultaEstagiarioPorId() {
            //Verifica os 10 primeiros estagiários
            estagiariosPage.consultarIdsEstagiarios()
                .forEach(id -> {
                    String nomeEstagiario = estagiariosPage.consultarNomeEstagiarioPorId(id);
                    System.out.println("Nome do estagiário: " + nomeEstagiario);
                    System.out.println("Id do estagiário: " + id);
                    estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorId(id);
                    Assertions.assertEquals(nomeEstagiario, estagiariosInformacoesPage.consultarNomeEstagiario());
                    estagiariosInformacoesPage.clicarBotaoVoltarParaLista();
                });
        }
        @Test
        @Story("Consulta de Estagiários")
        @Description("Consulta de estagiários por nome")
        @DisplayName("Consulta de estagiários por nome")
        public void testConsultarEstagiarioPorNome() {
            String nome = estagiariosPage.consultarNomeEstagiarioInformacoes();
            estagiariosPage.filtrarEstagiarioPorNomeValido();
            estagiariosPage.clicarBotaoBuscar();
            estagiariosPage.esperarBuscaPorNome(nome);
            Assertions.assertEquals(nome, estagiariosPage.consultarNomeEstagiarioInformacoes());
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
            EstagiarioModel estagiario = EstagiarioDataFactory.gerarEstagiarioValido(1);
            Assertions.assertTrue(estagiariosCadastroPage.estaNaPaginaCadastroEstagiario());
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
            Assertions.assertTrue(estagiariosPage.estaNaPaginaEstagiarios());
            Assertions.assertTrue(estagiariosPage.existeMensagemModal());
            estagiariosPage.fecharModal();
            estagiariosPage.filtrarEstagiarioPorNome(estagiario.getNome());
            estagiariosPage.clicarBotaoBuscar();
            estagiariosPage.esperarBuscaPorNome(estagiario.getNome());
            Assertions.assertEquals(estagiario.getNome(), estagiariosPage.consultarNomeEstagiarioInformacoes());
            estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
            estagiariosInformacoesPage.clicarBotaoDesativarEstagiario();
            estagiariosPage.preencherCampoMotivoDesativacaoValido();
            estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
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
            estagiariosCadastroPage.esperarBuscaDeCandidatoValido();
            Assertions.assertEquals(nomeCandidato.toLowerCase(), estagiariosCadastroPage.consultarCampoNome().toLowerCase());
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
            estagiariosPage.clicarBotaoDetalhesDoEstagiarioPorIdValido();
            estagiariosInformacoesPage.clicarBotaoDesativarEstagiario();
            estagiariosPage.preencherCampoMotivoDesativacaoValido();
            estagiariosPage.clicarBotaoConfirmarDesativarEstagiario();
            Assertions.assertTrue(estagiariosPage.existeMensagemModal());
        }
    }
}
