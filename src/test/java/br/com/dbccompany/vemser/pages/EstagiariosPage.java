package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class EstagiariosPage extends Elementos {
    private static final String URL_PAGINA = URL_BASE + "/avaliacao-front/estagiarios";
    public boolean estaNaPaginaDashboard() {
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
