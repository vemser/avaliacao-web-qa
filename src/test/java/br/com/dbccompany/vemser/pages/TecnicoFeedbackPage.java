package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class TecnicoFeedbackPage extends Elementos {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/tecnico/feedback";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
}
