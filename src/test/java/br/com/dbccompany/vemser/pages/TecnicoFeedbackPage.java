package br.com.dbccompany.vemser.pages;

public class TecnicoFeedbackPage extends SearchPage {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/tecnico/feedback";
    private static final String SELETOR_ACOMPANHAMENTOS = "[data-testid^='tecnico-card-menu-acompanhamento-']";
    // region Pagina detalhes
    private static final String SELETOR_BOTAO_AVALIAR = "[title='Botão Avaliar']";
    public static void clicarBotaoAvaliar() {
        clicar(SELETOR_BOTAO_AVALIAR);
    }
    public String consultarIdFeedback() {
        return Tabela.consultarTextoPorDataIdDataField("1", "data");
    }
    // endregion
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public static void clicarAcompanhamento() {
        clicar(SELETOR_ACOMPANHAMENTOS);
    }
    public void clicarPrimeiroBotaoDetalhes() {
        Tabela.clicarBotaoDetalhes();
    }
}
