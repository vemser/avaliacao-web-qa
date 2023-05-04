package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class TecnicoFeedbackPage extends Elementos {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/tecnico/feedback";
    private static final String SELETOR_ACOMPANHAMENTOS = "[data-testid^='tecnico-card-menu-acompanhamento-']";
    private static final String SELETOR_BOTOES_DETALHES = "[data-field='acoes'] [title='Botão Visualizar']";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarAcompanhamento() {
        clicar(SELETOR_ACOMPANHAMENTOS);
    }
    public void clicarPrimeiroBotaoDetalhes() {
        clicar(SELETOR_BOTOES_DETALHES);
    }
}
