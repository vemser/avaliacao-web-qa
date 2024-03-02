package br.com.dbccompany.vemser.pages;

import static br.com.dbccompany.vemser.utils.Manipulation.getProp;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbcompany.vemser.dataFactory.LoginData;
import br.com.dbcompany.vemser.model.LoginModel;

public class LoginPage extends Elementos {
    private static final String SELETOR_CAMPO_USUARIO = "#usuario";
    private static final String SELETOR_CAMPO_SENHA = "#senha";
    private static final String SELETOR_BOTAO_LOGIN = "#botao-logar";
    private static final String VALIDAR_LOGIN_SUCESSO = "div#root p > span";
    private static final String USUARIO_VALIDO = getProp().getProperty("UsuárioAdministrador");
    private static final String SENHA_VALIDO = getProp().getProperty("SenhaAdministrador");
    private static final String MSG_ERRO_EMAIL_INVALIDO = "p#erro-email";
    private static final String MSG_ERRO_SENHA_INVALIDA = "#box-login > div";
    private static final String MSG_ERRO_LOGIN_EM_BRANCO = "p#erro-email";
    private static final String MSG_ERRO_SENHA_EM_BRANCO = "p#erro-senha";

    public static final String URL_PAGINA = URL_BASE + "/login";

    public boolean validaLoginComSucesso(){
        return estaVisivel(VALIDAR_LOGIN_SUCESSO);
    }
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoLogin() {
        clicar(SELETOR_BOTAO_LOGIN);
    }
    public void preencherUsuario(String usuario) {
        preencher(SELETOR_CAMPO_USUARIO, usuario);
    }
    public void preencherSenha(String senha) {
        preencher(SELETOR_CAMPO_SENHA, senha);
    }

    public String msgErroEmailInvalido(){
        return consultarTexto(MSG_ERRO_EMAIL_INVALIDO);
    }

    public String msgErroSenhaInvalida(){
        return consultarTexto(MSG_ERRO_SENHA_INVALIDA);
    }

    public String msgDeLoginEmBranco(){
        return consultarTexto(MSG_ERRO_LOGIN_EM_BRANCO);
    }
    public String msgDeSenhaEmBranco(){
        return consultarTexto(MSG_ERRO_SENHA_EM_BRANCO);
    }



    public boolean validaPaginaDeLogin() {
        return estaVisivel(SELETOR_BOTAO_LOGIN)
                && estaVisivel(SELETOR_CAMPO_SENHA)
                && estaVisivel(SELETOR_CAMPO_USUARIO)
                && driver.getCurrentUrl().equals(URL_PAGINA)
                ;
    }
    public boolean realizarLoginComSucesso() {
        preencherUsuario(USUARIO_VALIDO);
        preencherSenha(SENHA_VALIDO);
        clicarBotaoLogin();
        return validaLoginComSucesso();
    }

    public void realizarLoginComEmailInvalido(LoginModel login) {
        preencherUsuario(login.getLogin());
        preencherSenha(login.getSenha());
        clicarBotaoLogin();
    }

    public void  realizarloginSenhaInvalida(LoginModel login) {
        preencherUsuario(USUARIO_VALIDO);
        preencherSenha(login.getSenha());
        clicarBotaoLogin();
    }

    public void  realizarlloginEmailEmBranco(LoginModel login) {
        preencherUsuario(login.getLogin());
        preencherSenha(login.getSenha());
        clicarBotaoLogin();
    }

    public void  realizarlloginSenhaEmBranco(LoginModel login) {
        preencherUsuario(USUARIO_VALIDO);
        preencherSenha(login.getSenha());
        clicarBotaoLogin();
    }







}
