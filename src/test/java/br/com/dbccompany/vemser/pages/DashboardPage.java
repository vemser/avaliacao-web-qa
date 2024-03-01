package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

import java.util.ArrayList;

public class DashboardPage extends Elementos {
    static LoginPage login = new LoginPage();
    private static final String SELETOR_DASHBOARD_HEADER = "[data-testid=\"dashboard-header\"]";
    private static final String SELETOR_CAMPO_FILTRO_NOME = "[data-testid=\"textfield-nome-dashboard\"]";
    private static final String DASH_DIV_TRILHAS = "div#root div.MuiBox-root.css-i51og3 > h2";
    private static final String DASH_DIV_RANKING = "#root > div.MuiBox-root.css-1ecwpr0 > div > div.MuiBox-root.css-i51og3 > div.MuiBox-root.css-0";
    private static final String DASH_DIV_ATIVOS = "#bar-chart";

    // Estes métodos abaixos ACESSAR PAGINA E ESTANAPAGINA serão retirados
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front";
    public static void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public boolean estaNaPaginaDashboard() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }

    public static void fluxoDeLogin() {
        login.realizarLoginComSucesso();
    }
    public static boolean validaTrilhasNaTela() {
        return estaVisivel(DASH_DIV_TRILHAS);
    }
    public static boolean validarRankingNaTela() {
        return estaVisivel(DASH_DIV_RANKING);
    }
    public static boolean validarAtivosNaTela() {
        return estaVisivel(DASH_DIV_ATIVOS);
    }

    // Este método adicionar todas as validações de elementos na tela e colocar em um Array
    // E então realizo teste se existe algum elemento que retornou false (não está na tela)
    // Caso aconteceça ele retorna false e falha o teste. O critério de aceite diz que todos esses elementos tem que estar em tela
    public boolean validarElementosNaTelaDashboardHighCredentials(){
        ArrayList<Boolean> list = new ArrayList<>();
        list.add(validaTrilhasNaTela());
        list.add(validarRankingNaTela());
        list.add(validarAtivosNaTela());

        return !list.contains(false);
    }


}
