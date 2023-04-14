package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class EstagiariosStepTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    private static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
    }
    @ParameterizedTest(name = "Candidato {index}- CPF: {0}")
    @Story("Cadastro de Estagiários")
    @Description("Cadastro de Estagiários por busca de candidato")
    @DisplayName("Cadastro de Estagiários por busca de candidato")
    @MethodSource("dataFactory.DataFactory#provideCanditadosEdicaoAtual")
    public void testCadastroEstagiarioPorBuscaCandidato(String cpfCandidato, String nomeCandidato, String emailCandidato) {
        estagiariosPage.acessarPagina();
        estagiariosPage.clicarBotaoCadastroEstagiario();
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
    @MethodSource("dataFactory.DataFactory#provideCpfNaoCadastrado")
    public void testCadastroEstagiarioPorBuscaDeCpfNaoCadastrado(String cpfCandidatoInvalido) {
        estagiariosPage.acessarPagina();
        estagiariosPage.clicarBotaoCadastroEstagiario();
        Assertions.assertTrue(estagiariosCadastroPage.estaNaPaginaCadastroEstagiario());
        estagiariosCadastroPage.preencherCampoBuscaCpf(cpfCandidatoInvalido);
        estagiariosCadastroPage.clicarBotaoBuscaCpf();
        Assertions.assertTrue(estagiariosCadastroPage.existeMensagemDeCpfNaoEncontrado());
    }
}
