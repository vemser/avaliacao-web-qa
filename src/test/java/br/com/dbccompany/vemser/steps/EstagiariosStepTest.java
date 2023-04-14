package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.*;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class EstagiariosStepTest extends Navegador {
    private static AcessoPage acessoPage = new AcessoPage();
    private static EstagiariosPage estagiariosPage = new EstagiariosPage();
    private static EstagiariosCadastroPage estagiariosCadastroPage = new EstagiariosCadastroPage();
    private static LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        estagiariosPage.acessarPagina();
    }
    @ParameterizedTest(name = "Candidato - CPF: {0} - Nome: {1} - E-mail: {2}")
    @Story("Cadastro de Estagiários")
    @Description("Cadastro de Estagiários por busca de candidato")
    @DisplayName("Cadastro de Estagiários por busca de candidato")
    @CsvSource({"17004082083,MARIAN STARK REILLY V,email@mail.com"})
    public void testCadastroEstagiarioPorBuscaCandidato(String cpfCandidato, String nomeCandidato, String emailCandidato) {
        estagiariosPage.clicarBotaoCadastroEstagiario();
        Assertions.assertTrue(estagiariosCadastroPage.estaNaPaginaCadastroEstagiario());
        estagiariosCadastroPage.preencherCampoBuscaCpf(cpfCandidato);
        estagiariosCadastroPage.clicarBotaoBuscaCpf();
        Assertions.assertEquals(nomeCandidato, estagiariosCadastroPage.consultarCampoNome());
        Assertions.assertEquals(emailCandidato, estagiariosCadastroPage.consultarCampoEmailPessoal());
//        Assertions.assertTrue(estagiariosCadastroPage.existeMensagemDeCpfNaoEncontrado());
//        Assertions.assertEquals(nomeCandidato, estagiariosCadastroPage.consultarNomeCandidato());
    }
}
