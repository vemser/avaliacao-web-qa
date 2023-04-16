package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Tabelas;

import java.util.List;

public class ConfiguracoesProgramasPage extends Elementos {
    private static final String SELETOR_BOTAO_CRIAR_PROGRAMA = "button[data-testid='programas-create-btn']";
    private static final String SELETOR_CAMPO_CRIAR_NOME_PROGRAMA = "input[id='nome']";
    private static final String SELETOR_CAMPO_CRIAR_DESCRICAO_PROGRAMA = "textarea[id='descricao']";
    private static final String SELETOR_CAMPO_CRIAR_DATA_INICIO_PROGRAMA = "input[id='dataInicio']";
    private static final String SELETOR_CAMPO_CRIAR_DATA_FIM_PROGRAMA = "input[id='dataFim']";
    private static final String SELETOR_BOTAO_CRIAR_SITUACAO_PROGRAMA = "#status";
    private static final String SELETOR_BOTAO_CRIAR_SITUACAO_OPCOES = " [role=\"listbox\"] > li";
    private static final String SELETOR_BOTAO_CRIAR_PROSSEGUIR_PROGRAMA = "button[class*='MuiButton-root']";
    public static final String URL_PAGINA = ConfiguracoesPage.URL_PAGINA + "/programas";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoCriarPrograma() {
        clicar(SELETOR_BOTAO_CRIAR_PROGRAMA);
    }
    public void clicarBotaoCriarSituacaoPrograma() {
        clicar(SELETOR_BOTAO_CRIAR_SITUACAO_PROGRAMA);
    }
    public void clicarBotaoCriarSituacaoOpcoes(int index) {
        clicarNoElementoIndex(SELETOR_BOTAO_CRIAR_SITUACAO_OPCOES, index);
    }
    public void clicarBotaoCriarProsseguirPrograma() {
        clicar(SELETOR_BOTAO_CRIAR_PROSSEGUIR_PROGRAMA);
    }
    public boolean estaNaPaginaConfiguracoesPrograma() {
        return consultarUrl().equals(URL_PAGINA);
    }
    public boolean estaNaPaginaCriarPrograma() {
        return driver.getCurrentUrl().equals(URL_PAGINA + "/create");
    }
    public void preencherCampoCriarNomePrograma(String nome) {
        preencher(SELETOR_CAMPO_CRIAR_NOME_PROGRAMA, nome);
    }
    public void preencherCampoCriarDescricaoPrograma(String descricao) {
        preencher(SELETOR_CAMPO_CRIAR_DESCRICAO_PROGRAMA, descricao);
    }
    public void preencherCampoCriarDataInicioPrograma(String dataInicio) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_CRIAR_DATA_INICIO_PROGRAMA, dataInicio);
    }
    public void preencherCampoCriarDataFimPrograma(String dataFim) {
        preencherDepoisDeLimpar(SELETOR_CAMPO_CRIAR_DATA_FIM_PROGRAMA, dataFim);
    }
    public List<String> consultarIdsProgramas() {
        return Tabelas.consultarIds(10);
    }
    public boolean estaNaPaginaConfiguracoesProgramas() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
