package br.com.dbccompany.vemser.utils;

public class Usuarios {
    //Variavel de ambiente DBC_USER = usuario,senha,nome
//    public static final String[] USUARIO_DADOS = System.getenv("DBC_USER").split(",");

//    public static final String USUARIO = USUARIO_DADOS[0];
//    public static final String SENHA = USUARIO_DADOS[1];
//    public static final String NOME = USUARIO_DADOS[2];
    public static final String USUARIO = System.getenv("DBC_USER");
    public static final String NOME = USUARIO.split("\\.")[0];
    public static final String SENHA = System.getenv("DBC_PASSWORD");
}