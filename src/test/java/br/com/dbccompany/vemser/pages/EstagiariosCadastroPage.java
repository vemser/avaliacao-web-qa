package br.com.dbccompany.vemser.pages;

public class EstagiariosCadastroPage extends EstagiariosPage{
    private static final String SELETOR_BOTAO_BUSCA_CPF = "form > div > button";
    private static final String SELETOR_CAMPO_BUSCA_CPF = "[id=\"cpfBusca\"]";
    private static final String SELETOR_CAMPO_NOME = "[id=\"nome\"]";
    private static final String SELETOR_MENSAGEM_CPF_NAO_ENCONTRADO = "div.Toastify__toast-body > div:nth-child(2)";
    public static final String URL_PAGINA = EstagiariosPage.URL_PAGINA + "/cadastro";
    private static final String SELETOR_CAMPO_EMAIL_PESSOAL = "[id=\"emailPessoal\"]";

    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoBuscaCpf() {
        clicar(SELETOR_BOTAO_BUSCA_CPF);
    }
    public boolean estaNaPaginaCadastroEstagiario() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
    public boolean existeMensagemDeCpfNaoEncontrado() {
        esperarUrl(URL_PAGINA);
        esperarConteudoNaoVazio(SELETOR_MENSAGEM_CPF_NAO_ENCONTRADO);
        return estaVisivel(SELETOR_MENSAGEM_CPF_NAO_ENCONTRADO);
    }
    public void preencherCampoBuscaCpf(String cpf) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_BUSCA_CPF, cpf);
    }
    public String consultarCampoEmailPessoal() {
        return consultarValor(SELETOR_CAMPO_EMAIL_PESSOAL);
    }
    public String consultarCampoNome() {
        return consultarValor(SELETOR_CAMPO_NOME);
    }
}
