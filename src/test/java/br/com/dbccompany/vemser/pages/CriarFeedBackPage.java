package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class CriarFeedBackPage extends Elementos{
    private static final String SELETOR_BOTAO_TIPO_FEEDBACK = "[id='tipoFeedback']";
    private static final String SELETOR_OPCOES_TIPO_FEEDBACK = "[id='menu-tipoFeedback'] li";
    private static final String SELETOR_BOTAO_TIPO_STATUS = "[id='status']";
    private static final String SELETOR_OPCOES_TIPO_STATUS = "[id='menu-status'] li";
    private static final String SELETOR_CAMPO_DESCRICAO = "[id='descricao']";
    private static final String SELETOR_CAMPO_NOTA = "[id='nota']";
    private static final String SELETOR_CAMPO_OBJETIVO = "[id='objetivoProfissional']";
    private static final String SELETOR_CAMPO_RECOMENDACAO = "[id='recomendacaoMelhorias']";
    private static final String SELETOR_BOTAO_CADASTRAR = "div.MuiBox-root > div > form > div > button";
    public static void clicarTipoFeedback() {
        clicar(SELETOR_BOTAO_TIPO_FEEDBACK);
    }
    public static void selecionarTipoFeedback(int index) {
        clicarNoElementoIndex(SELETOR_OPCOES_TIPO_FEEDBACK, index);
    }
    public static void preencherCampoDescricao(String descricao) {
        preencher(SELETOR_CAMPO_DESCRICAO, descricao);
    }
    public static void preencherCampoNota(String nota) {
        preencher(SELETOR_CAMPO_NOTA, nota);
    }
    public static void clicarBotaoCadastrar() {
        clicar(SELETOR_BOTAO_CADASTRAR);
    }
    public static void clicarTipoStatus() {
        clicar(SELETOR_BOTAO_TIPO_STATUS);
    }
    public static void selecionarTipoStatus(int index) {
        clicarNoElementoIndex(SELETOR_OPCOES_TIPO_STATUS, index);
    }
    public static void preencherCampoObjetivo(String objetivo) {
        preencher(SELETOR_CAMPO_OBJETIVO, objetivo);
    }
    public static void preencherCampoRecomendacao(String recomendacao) {
        preencher(SELETOR_CAMPO_RECOMENDACAO, recomendacao);
    }
}
