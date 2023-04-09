package br.com.dbccompany.vemser.utils;

public class Seletores {
    public static String login(String info) {
        switch (info) {
            case "campoUsuario":
                return "#usuario";
            case "campoSenha":
                return "#senha";
            case "botaoLogin":
                return "#botao-logar";
            default:
                return null;
        }
    }
    public static String menu(String info) {
        switch (info) {
            case "nomeUsuario":
                return "div.MuiBox-root.css-iexd2a > p > span > strong";
            case "botaoSair":
                return "nav > div:nth-child(6) > div.MuiListItemIcon-root.css-1f8bwsm";
            default:
                return null;
        }
    }
}
