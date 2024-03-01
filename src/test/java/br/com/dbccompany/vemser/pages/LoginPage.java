package br.com.dbccompany.vemser.pages;

import static br.com.dbccompany.vemser.utils.Manipulation.getProp;

import br.com.dbccompany.vemser.utils.Elementos;

public class LoginPage extends Elementos {
    // region Atributos
    private static final String SELETOR_CAMPO_USUARIO = "#login";
    private static final String SELETOR_CAMPO_SENHA = "#senha";
    private static final String SELETOR_BOTAO_LOGIN = "#root > div.MuiBox-root.css-9yu00z > main > div > div.MuiBox-root.css-1v9gjd5 > form > button";
    private static final String SELETOR_BOTAO_MOSTRAR_SENHA = "#root > div.MuiBox-root.css-9yu00z > main > div > div.MuiBox-root.css-1v9gjd5 > form > div.MuiFormControl-root.css-1179acg > div > div > button > svg";
    private static final String SELETOR_MODAL_SESSAO_EXPIRADA = "div.Toastify__toast-body > div:nth-child(2)";
    private static final String USUARIO_VALIDO = getProp().getProperty("UsuárioPessoal");
    private static final String SENHA_VALIDO = getProp().getProperty("SenhaPessoal");;
    public static final String URL_PAGINA = URL_BASE;

    // endregion

    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoLogin() {
        clicar(SELETOR_BOTAO_LOGIN);
    }
    public String consultarNomeUsuarioValido() {
        return USUARIO_VALIDO.replace("@dbccompany.com.br", "").replace(".", " ").toLowerCase();
    }
    public String consultarUsuarioValido() {
        return USUARIO_VALIDO;
    }
    public boolean estaNaPaginaDeLogin() {
        return estaVisivel(SELETOR_BOTAO_LOGIN)
                && estaVisivel(SELETOR_CAMPO_SENHA)
                && estaVisivel(SELETOR_CAMPO_USUARIO)
                && estaVisivel(SELETOR_BOTAO_MOSTRAR_SENHA)
                && driver.getCurrentUrl().equals(URL_PAGINA)
                ;
    }
    public boolean existeMensagemDeSessaoExpirada() {
        esperarUrl(URL_PAGINA);
        esperarConteudoNaoVazio(SELETOR_MODAL_SESSAO_EXPIRADA);
        return estaVisivel(SELETOR_MODAL_SESSAO_EXPIRADA);
    }
    public void preencherUsuario(String usuario) {
        preencher(SELETOR_CAMPO_USUARIO, usuario);
    }
    public void preencherUsuarioValido() {
        preencherUsuario(USUARIO_VALIDO);
    }
    public void preencherSenha(String senha) {
        preencher(SELETOR_CAMPO_SENHA, senha);
    }
    public void preencherSenhaValida() {
        preencherSenha(SENHA_VALIDO);
    }
    public void realizarLoginComSucesso() {
        acessarPagina();
        preencherUsuarioValido();
        preencherSenhaValida();
        clicarBotaoLogin();
    }
}
