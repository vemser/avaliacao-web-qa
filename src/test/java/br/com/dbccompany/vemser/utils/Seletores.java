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
                return "div.MuiBox-root.css-iexd2a > p > strong";
            case "botaoSair":
                return "#root > div.MuiDrawer-root.MuiDrawer-docked.css-1tu59u4 > div > aside > div.MuiBox-root.css-1rr4qq7 > nav > div:nth-child(4)";
            default:
                return null;
        }
    }
}
