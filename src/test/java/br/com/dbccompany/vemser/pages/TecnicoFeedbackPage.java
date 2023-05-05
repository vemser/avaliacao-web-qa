package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class TecnicoFeedbackPage extends Elementos {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/tecnico/feedback";
    private static final String SELETOR_ACOMPANHAMENTOS = "[data-testid^='tecnico-card-menu-acompanhamento-']";
    private static final String SELETOR_BOTOES_DETALHES = "[data-field='acoes'] [title='Botão Visualizar']";
    // region Pagina detalhes
    private static final String SELETOR_BOTAO_AVALIAR = "[title='Botão Avaliar']";
    private static final String SELETOR_TEXTO_ID_FEEDBACK = "[data-id='1'] > [data-field='data'] > div";
    public void clicarBotaoAvaliar() {
        clicar(SELETOR_BOTAO_AVALIAR);
    }
    public String pegarIdFeedback() {
        return consultarTexto(SELETOR_TEXTO_ID_FEEDBACK);
    }
    // endregion
    // region Pagina Criar Feedback
    private static final String SELETOR_BOTAO_TIPO_FEEDBACK = "[id='tipoFeedback']";
    private static final String SELETOR_OPCOES_TIPO_FEEDBACK = "[id='menu-tipoFeedback'] li";
    private static final String SELETOR_CAMPO_DESCRICAO = "[id='descricao']";
    private static final String SELETOR_CAMPO_NOTA = "[id='nota']";
    private static final String SELETOR_BOTAO_CADASTRAR = "div.MuiBox-root > div > form > div > button";
    public void clicarTipoFeedback() {
        clicar(SELETOR_BOTAO_TIPO_FEEDBACK);
    }
    public void selecionarTipoFeedback(int index) {
        clicarNoElementoIndex(SELETOR_OPCOES_TIPO_FEEDBACK, index);
    }
    public void preencherCampoDescricao(String descricao) {
        preencher(SELETOR_CAMPO_DESCRICAO, descricao);
    }
    public void preencherCampoNota(String nota) {
        preencher(SELETOR_CAMPO_NOTA, nota);
    }
    public void clicarBotaoCadastrar() {
        clicar(SELETOR_BOTAO_CADASTRAR);
    }
    // endregion
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
