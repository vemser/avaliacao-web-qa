package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

import java.util.ArrayList;

public class DashboardPage extends Elementos {

    private static final String DASHBOARD_DADOS = "[data-testid=\"dados-dash\"]";

    public boolean validarDadosDashboard(){
        return estaVisivel(DASHBOARD_DADOS);
    }


}
