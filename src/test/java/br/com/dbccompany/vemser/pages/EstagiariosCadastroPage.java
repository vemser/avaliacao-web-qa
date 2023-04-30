package br.com.dbccompany.vemser.pages;

import dataFactory.EstagiarioDataFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EstagiariosCadastroPage extends EstagiariosPage{
    // region SELETORES BOTOES E CAMPOS
    private static final String SELETOR_BOTAO_BUSCA_CPF = "form > div > button";
    private static final String SELETOR_CAMPO_BUSCA_CPF = "[id=\"cpfBusca\"]";
    private static final String SELETOR_CAMPO_NOME = "[id=\"nome\"]";
    private static final String SELETOR_CAMPO_CPF = "[id=\"cpf\"]";
    private static final String SELETOR_CAMPO_EMAIL_PESSOAL = "[id=\"emailPessoal\"]";
    private static final String SELETOR_CAMPO_EMAIL_CORPORATIVO = "[id=\"emailCorporativo\"]";
    private static final String SELETOR_CAMPO_TELEFONE = "[id=\"telefone\"]";
    private static final String SELETOR_CAMPO_DATA_NASCIMENTO = "[id=\"dataNascimento\"]";
    private static final String SELETOR_CAMPO_ESTADO = "[id=\"estado\"]";
    private static final String SELETOR_CAMPO_CIDADE = "[id=\"cidade\"]";
    private static final String SELETOR_CAMPO_INSTITUICAO_ENSINO = "[id=\"instituicaoEnsino\"]";
    private static final String SELETOR_CAMPO_CURSO = "[id=\"curso\"]";
    private static final String SELETOR_CAMPO_GITHUB = "[id=\"github\"]";
    private static final String SELETOR_CAMPO_LINKEDIN = "[id=\"linkedin\"]";
    private static final String SELETOR_CAMPO_OBSERVACOES = "[id=\"observacoes\"]";
    private static final String SELETOR_BOTAO_SELECIONAR_PROGRAMA = "[id=\"programa\"]";
    private static final String SELETOR_BOTAO_SELECIONAR_TRILHA = "[id=\"idTrilha\"]";
    private static final String SELETOR_BOTAO_SELECIONAR_STATUS = "[id=\"status\"]";
    private static final String SELETOR_BOTAO_SELECIONAR_GERAL_OPCOES = "[id^=\"menu-\"] > div > ul > li";
    private static final String SELETOR_BOTAO_CADASTRAR = "form:nth-child(3) > div > button";
    private static final String SELETOR_MENSAGEM_CPF_NAO_ENCONTRADO = "div.Toastify__toast-body > div:nth-child(2)";
    // endregion
    public static final String URL_PAGINA = EstagiariosPage.URL_PAGINA + "/cadastro";
    private static final String SELETOR_BOTAO_EDITAR = "div > form > div > button";

    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoBuscaCpf() {
        clicar(SELETOR_BOTAO_BUSCA_CPF);
    }
    public void clicarBotaoCadastrar() {
        clicar(SELETOR_BOTAO_CADASTRAR);
    }
    public void clicarSelecionarPrograma() {
        clicar(SELETOR_BOTAO_SELECIONAR_PROGRAMA);
    }
    public void clicarSelecionarTrilha() {
        clicar(SELETOR_BOTAO_SELECIONAR_TRILHA);
    }
    public void clicarSelecionarStatus() {
        clicar(SELETOR_BOTAO_SELECIONAR_STATUS);
    }
    public boolean estaNaPaginaCadastroEstagiario() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
    public void esperarBuscaDeCandidatoValido() {
        wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.cssSelector(SELETOR_CAMPO_NOME)),"value"));
    }
    public boolean existeMensagemDeCpfNaoEncontrado() {
        esperarUrl(URL_PAGINA);
        esperarConteudoNaoVazio(SELETOR_MENSAGEM_CPF_NAO_ENCONTRADO);
        return estaVisivel(SELETOR_MENSAGEM_CPF_NAO_ENCONTRADO);
    }
    public void preencherCampoBuscaCpf(String cpf) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_BUSCA_CPF, cpf);
    }
    public void preencherCampoCpf(String cpf) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_CPF, cpf);
    }
    public void preencherCampoDataNascimento(String dataNascimento) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_DATA_NASCIMENTO, dataNascimento);
    }
    public void preencherCampoEmailCorporativo(String emailCorporativo) {
        preencher(SELETOR_CAMPO_EMAIL_CORPORATIVO, emailCorporativo);
    }
    public void preencherCampoEmailPessoal(String emailPessoal) {
        preencher(SELETOR_CAMPO_EMAIL_PESSOAL, emailPessoal);
    }
    public void preencherCampoNome(String nome) {
        preencher(SELETOR_CAMPO_NOME, nome);
    }
    public void preencherCampoObservacoes(String observacoes) {
        preencher(SELETOR_CAMPO_OBSERVACOES, observacoes);
    }
    public void preencherCampoTelefone(String telefone) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_TELEFONE, telefone);
    }
    public void preencherCampoCidade(String cidade) {
        preencher(SELETOR_CAMPO_CIDADE, cidade);
    }
    public void preencherCampoEstado(String estado) {
        preencher(SELETOR_CAMPO_ESTADO, estado);
    }
    public void preencherCampoInstituicaoEnsino(String instituicaoEnsino) {
        preencher(SELETOR_CAMPO_INSTITUICAO_ENSINO, instituicaoEnsino);
    }
    public void preencherCampoCurso(String curso) {
        preencher(SELETOR_CAMPO_CURSO, curso);
    }
    public void preencherCampoGithub(String github) {
        preencher(SELETOR_CAMPO_GITHUB, github);
    }
    public void preencherCampoLinkedin(String linkedin) {
        preencher(SELETOR_CAMPO_LINKEDIN, linkedin);
    }
    public void selecionarOpcaoStatus(Integer index) {
        clicarNoElementoIndex(SELETOR_BOTAO_SELECIONAR_GERAL_OPCOES, index);
    }
    public void selecionarOpcaoTrilha(Integer index) {
        clicarNoElementoIndex(SELETOR_BOTAO_SELECIONAR_GERAL_OPCOES, index);
    }
    public void selecionarOpcaoPrograma(Integer index) {
        clicarNoElementoIndex(SELETOR_BOTAO_SELECIONAR_GERAL_OPCOES, index);
    }
    public String consultarCampoEmailPessoal() {
        return consultarValor(SELETOR_CAMPO_EMAIL_PESSOAL);
    }
    public String consultarCampoNome() {
        return consultarValor(SELETOR_CAMPO_NOME);
    }
    // region Metodos com retorno valido
    public void preencherCampoNomeValido() {
        preencherCampoNome(EstagiarioDataFactory.gerarNomeValido());
    }
    public void preencherCampoCpfValido() {
        preencherCampoCpf(EstagiarioDataFactory.gerarCpfValido());
    }
    public void preencherCampoEmailPessoalValido() {
        preencherCampoEmailPessoal(EstagiarioDataFactory.gerarEmailPessoalValido());
    }
    public void preencherCampoEmailCorporativoValido() {
        preencherCampoEmailCorporativo(EstagiarioDataFactory.gerarEmailDbcValido());
    }
    public void preencherCampoTelefoneValido() {
        preencherCampoTelefone(EstagiarioDataFactory.gerarTelefoneValido());
    }
    public void preencherCampoDataNascimentoValido() {
//        preencherCampoDataNascimento(EstagiarioDataFactory.gerarDataNascimentoValida());
        preencherCampoDataNascimento("01/01/1990");
    }
    public void preencherCampoEstadoValido() {
        preencherCampoEstado(EstagiarioDataFactory.gerarEstadoValido());
    }
    public void preencherCampoCidadeValido() {
        preencherCampoCidade(EstagiarioDataFactory.gerarCidadeValida());
    }
    public void preencherCampoInstituicaoEnsinoValido() {
        preencherCampoInstituicaoEnsino(EstagiarioDataFactory.gerarInstituicaoEnsinoValida());
    }
    public void preencherCampoCursoValido() {
        preencherCampoCurso(EstagiarioDataFactory.gerarCursoValido());
    }
    public void preencherCampoGithubValido() {
        preencherCampoGithub(EstagiarioDataFactory.gerarGithubValido());
    }
    public void preencherCampoLinkedinValido() {
        preencherCampoLinkedin(EstagiarioDataFactory.gerarLinkedinValido());
    }
    public void preencherCampoObservacoesValido() {
        preencherCampoObservacoes(EstagiarioDataFactory.gerarObservacoesValidas());
    }

    public void limparCampoNome() {
        driver.findElement(By.cssSelector(SELETOR_CAMPO_NOME)).clear();
    }

    public void clicarBotaoEditar() {
        clicar(SELETOR_BOTAO_EDITAR);
    }
    // endregion
}
