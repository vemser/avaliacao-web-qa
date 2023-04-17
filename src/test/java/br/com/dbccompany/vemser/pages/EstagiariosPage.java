package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Tabelas;
import org.junit.jupiter.params.provider.Arguments;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Stream;

public class EstagiariosPage extends Elementos {
    private static final String SELETOR_BOTAO_CADASTRO_ESTAGIARIO = "[data-testid=\"AddOutlinedIcon\"]";
    private static final String SELETOR_BOTAO_INFORMACOES_VOLTAR = "[data-testid=\"programa-create-voltar-btn\"]";
    private static final String SELETOR_BOTAO_INFORMACOES_DESATIVAR_ESTAGIARIO = "button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedError.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.MuiButton-root.MuiButton-outlined.MuiButton-outlinedError.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-mg7184";
    private static final String SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO = "[data-id=\"1\"] [data-field=\"info\"] > div";
    private static final String SELETOR_BOTOES_DETELHES_DOS_ESTAGIARIOS = "[data-testid=\"ArticleOutlinedIcon\"]";
    private static final String SELETOR_BOTAO_EDITAR_ESTAGIARIO = "div > div.MuiBox-root.css-69i1ev > div.MuiBox-root.css-k9kc57 > button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-7j2ur2";
    private static final String SELETOR_CAMPO_BUSCAR_NOME_ESTAGIARIO = "[id=\"nome\"]";
    private static final String SELETOR_CONSULTAR_LINHA_ESTAGIARIO = "[data-id=\"%s\"]";
    private static final String SELETOR_CONSULTAR_NOME_ESTAGIARIO = "[data-colindex=\"1\"]";
    private static final String SELETOR_MODAL = "div.Toastify__toast-body > div:nth-child(2)";
    // region Página desativar estagiário
    private static final String SELETOR_BOTAO_DESATIVAR_ESTAGIARIO = "div > form > div > button";
    private static final String SELETOR_BOTAO_CAMPO_MOTIVO_DESATIVACAO = "[id=\"observacao\"]";
    public void clicarBotaoConfirmarDesativarEstagiario() {
        clicar(SELETOR_BOTAO_DESATIVAR_ESTAGIARIO);
    }
    public void preencherCampoMotivoDesativacao(String motivo) {
        preencher(SELETOR_BOTAO_CAMPO_MOTIVO_DESATIVACAO, motivo);
    }
    public void preencherCampoMotivoDesativacaoValido() {
        preencherCampoMotivoDesativacao("Quando se trata de trabalho em equipe, é importante que todos os membros estejam alinhados com os objetivos e metas do projeto. Infelizmente, às vezes pode ser necessário realizar o desligamento de algum integrante da equipe. Embora seja uma decisão difícil, pode ser necessária para garantir que o projeto continue progredindo de forma eficiente e eficaz.");
    }
    // endregion
    // region Página detalhes do estagiário
    private static final String SELETOR_BOTAO_ABA_INFORMACOES_DO_PROGRAMA = "[id=\"simple-tab-1\"]";
    private static final String SELETOR_BOTAO_ABA_ACOMPANHAMENTOS_DO_ESTAGIARIO = "[id=\"simple-tab-2\"]";
    public void clicarAbaInformacoesDoPrograma() {
        clicar(SELETOR_BOTAO_ABA_INFORMACOES_DO_PROGRAMA);
    }
    public void clicarAbaAcompanhamentosDoEstagiario() {
        clicar(SELETOR_BOTAO_ABA_ACOMPANHAMENTOS_DO_ESTAGIARIO);
    }
    // endregion
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/estagiarios";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoCadastroEstagiario() {
        clicar(SELETOR_BOTAO_CADASTRO_ESTAGIARIO);
    }
    public void clicarBotaoDesativarEstagiario() {
        clicar(SELETOR_BOTAO_INFORMACOES_DESATIVAR_ESTAGIARIO);
    }
    public void clicarBotaoDetalhesDoEstagiarioPorId(String idEstagiario) {
        clicar(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(idEstagiario)) + " " + SELETOR_BOTOES_DETELHES_DOS_ESTAGIARIOS);
    }
    public void clicarBotaoDetalhesDoEstagiarioPorIdValido() {
        clicar(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(consultarIdsEstagiarios().get(0))) + " " + SELETOR_BOTOES_DETELHES_DOS_ESTAGIARIOS);
    }
    public void clicarBotaoEditarEstagiario() {
        clicar(SELETOR_BOTAO_EDITAR_ESTAGIARIO);
    }
    public void clicarBotaoVoltarParaLista() {
        clicar(SELETOR_BOTAO_INFORMACOES_VOLTAR);
    }
    public List<String> consultarIdsEstagiarios() {
        //executa um getText para os 10 primeiros elementos correposndentes ao seletor
//        return driver.findElements(By.cssSelector(SELETOR_COLUNA_IDS_ESTAGIARIOS)).stream().limit(10).map(webElement -> webElement.getText()).toList();
        return Tabelas.consultarIds(10);
    }
    public String consultarNomeEstagiarioPorId(String idEstagiario) {
        return consultarTexto(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(idEstagiario)) + " " + SELETOR_CONSULTAR_NOME_ESTAGIARIO);
    }
    public String consultarNomeEstagiarioInformacoes() {
        esperarConteudoNaoVazio(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
        return consultarTexto(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
    }
    public String consultarMensagemModal() {
        esperarConteudoNaoVazio(SELETOR_MODAL);
        return consultarTexto(SELETOR_MODAL);
    }
    public boolean estaNaPaginaEstagiarios() {
        esperarUrl(URL_PAGINA);
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
    public boolean existeMensagemModal() {
        esperarConteudoNaoVazio(SELETOR_MODAL);
        return estaVisivel(SELETOR_MODAL);
    }
    // esperar modal fechar
    public void esperarModalFechar() {
        while (driver.findElement(By.cssSelector(SELETOR_MODAL)).isDisplayed()) {
            esperarTempo(1000);
        }
    }
}
