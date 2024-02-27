package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class ColaboradoresInformacoesPage extends Elementos{
    private static final String SELETOR_TABELA_NOME = "[data-id='1'] > [data-field='info'] > div";
    private static final String SELETOR_BOTAO_VOLTAR = "[data-testid=\"programa-create-voltar-btn\"]";
    private static final String SELETOR_BOTAO_DESATIVAR_ESTAGIARIO = ".MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedError.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.MuiButton-root.MuiButton-outlined.MuiButton-outlinedError.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-mg7184";
    public static final String URL_PAGINA = ColaboradoresPage.URL_PAGINA + "/informacoes";
    public String consultarNomeEstagiario() {
        esperarConteudoNaoVazio(SELETOR_TABELA_NOME);
        return consultarTexto(SELETOR_TABELA_NOME);
    }
    public void clicarBotaoDesativarEstagiario() {
        clicar(SELETOR_BOTAO_DESATIVAR_ESTAGIARIO);
    }
    public void clicarBotaoVoltarParaLista() {
        clicar(SELETOR_BOTAO_VOLTAR);
    }
}
