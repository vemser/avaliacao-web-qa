package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Stream;

public class EstagiariosPage extends Elementos {
    private static final String SELETOR_BOTAO_CADASTRO_ESTAGIARIO = "[data-testid=\"AddOutlinedIcon\"]";
    private static final String SELETOR_BOTAO_INFORMACOES_VOLTAR = "[data-testid=\"programa-create-voltar-btn\"]";
    private static final String SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO = "[data-id=\"1\"] [data-field=\"info\"] > div";
    private static final String SELETOR_BOTOES_DETELHES_DOS_ESTAGIARIOS = "[data-testid=\"ArticleOutlinedIcon\"]";
    private static final String SELETOR_CAMPO_BUSCAR_NOME_ESTAGIARIO = "[id=\"nome\"]";
    private static final String SELETOR_COLUNA_IDS_ESTAGIARIOS = "div.MuiDataGrid-row [data-field=\"id\"]";
    private static final String SELETOR_CONSULTAR_LINHA_ESTAGIARIO = "[data-id=\"%s\"]";
    private static final String SELETOR_CONSULTAR_NOME_ESTAGIARIO = "[data-colindex=\"1\"]";
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/estagiarios";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoCadastroEstagiario() {
        clicar(SELETOR_BOTAO_CADASTRO_ESTAGIARIO);
    }
    public void clicarBotaoDetalhesDoEstagiarioPorId(String idEstagiario) {
        clicar(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(idEstagiario)) + " " + SELETOR_BOTOES_DETELHES_DOS_ESTAGIARIOS);
    }
    public void clicarBotaoVoltarParaLista() {
        clicar(SELETOR_BOTAO_INFORMACOES_VOLTAR);
    }
    public List<String> consultarIdsEstagiarios() {
        //executa um getText para os 10 primeiros elementos correposndentes ao seletor
        return driver.findElements(By.cssSelector(SELETOR_COLUNA_IDS_ESTAGIARIOS)).stream().limit(10).map(webElement -> webElement.getText()).toList();
    }
    public String consultarNomeEstagiarioPorId(String idEstagiario) {
        return consultarTexto(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(idEstagiario)) + " " + SELETOR_CONSULTAR_NOME_ESTAGIARIO);
    }
    public String consultarNomeEstagiarioInformacoes() {
        esperarConteudoNaoVazio(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
        return consultarTexto(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
    }
    public boolean estaNaPaginaEstagiarios() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
