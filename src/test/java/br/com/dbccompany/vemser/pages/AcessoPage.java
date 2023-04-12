package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class AcessoPage extends Elementos {
    public static final String SELETOR_NOME_USUARIO = "div.usuario.MuiBox-root.css-0 > div :nth-child(1)";
    public static final String SELETOR_USUARIO = "div.usuario.MuiBox-root.css-0 > div :nth-child(2)";
    public String consultarNomeUsuarioLogado() {
        esperarConteudoNaoVazio(SELETOR_NOME_USUARIO);
        return consultarTexto(SELETOR_NOME_USUARIO).toLowerCase();
    }
    public String consultarUsuarioLogado() {
        esperarConteudoNaoVazio(SELETOR_USUARIO);
        return consultarTexto(SELETOR_USUARIO).toLowerCase();
    }
}
