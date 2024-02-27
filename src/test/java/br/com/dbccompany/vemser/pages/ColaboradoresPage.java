package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Tabelas;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ColaboradoresPage extends Elementos {
    private static final String SELETOR_BOTAO_CADASTRO_ESTAGIARIO = "[data-testid=\"AddOutlinedIcon\"]";
    private static final String SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO = "[data-rowindex='0'] [data-field='nome'] div";
    private static final String SELETOR_BOTOES_DETELHES_DOS_ESTAGIARIOS = "[data-testid=\"ArticleOutlinedIcon\"]";
    private static final String SELETOR_BOTAO_EDITAR_ESTAGIARIO = "div > div.MuiBox-root.css-69i1ev > div.MuiBox-root.css-k9kc57 > button.MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-7j2ur2";
    private static final String SELETOR_CAMPO_FILTRO_NOME_ESTAGIARIO = "#nome";
    private static final String SELETOR_CONSULTAR_LINHA_ESTAGIARIO = "div[class='MuiDataGrid-virtualScrollerRenderZone css-1inm7gi'] div:nth-child(1) div:nth-child(7) div:nth-child(1) button:nth-child(1)";
    private static final String SELETOR_CONSULTAR_NOME_ESTAGIARIO = "[data-colindex='1']";
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
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/colaboradores";
    public static final String URL_PAGINA_CADASTRO = URL_BASE + "/avaliacao-front/colaboradores/cadastro";
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public void clicarBotaoBuscar() {
        clicar("form button [data-testid='SearchIcon']");
    }
    public void clicarBotaoCadastroEstagiario() {
        clicar(SELETOR_BOTAO_CADASTRO_ESTAGIARIO);
    }
    public void clicarBotaoDetalhesDoEstagiarioPorId(String idEstagiario) {
        clicar(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(idEstagiario)) + ">div");
    }
    public void clicarBotaoDetalhesDoEstagiarioPorIdValido() {
        clicar(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(consultarIdsEstagiarios().get(0))));
    }
    public void clicarBotaoEditarEstagiario() {
        clicar(SELETOR_BOTAO_EDITAR_ESTAGIARIO);
    }
    public List<String> consultarIdsEstagiarios() {
        return Tabelas.consultarIds(10);
    }
    public String consultarNomeEstagiarioPorId(String idEstagiario) {
        // return consultarTexto(String.format(SELETOR_CONSULTAR_LINHA_ESTAGIARIO.formatted(idEstagiario)) + " " + SELETOR_CONSULTAR_NOME_ESTAGIARIO);
        return Tabelas.consultarNomePorId(idEstagiario);
    }
    public String consultarNomeEstagiarioInformacoes() {
        esperarConteudoNaoVazio(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
        return consultarTexto(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
    }
    public void esperarBuscaPorNome(String nomeEstagiario) {
        esperarConteudoNaoVazio(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(SELETOR_CONSULTAR_INFORMACOES_NOME_ESTAGIARIO), nomeEstagiario));
    }
    public String consultarMensagemModal() {
        esperarConteudoNaoVazio(SELETOR_MODAL);
        return consultarTexto(SELETOR_MODAL);
    }
    public boolean estaNaPaginaEstagiarios() {
        esperarUrl(URL_PAGINA_CADASTRO);
        return driver.getCurrentUrl().equals(URL_PAGINA_CADASTRO);
    }
    public boolean existeMensagemModal() {
        esperarConteudoNaoVazio(SELETOR_MODAL);
        return estaVisivel(SELETOR_MODAL);
    }
    public void filtrarEstagiarioPorNome(String string) {
        preencher(SELETOR_CAMPO_FILTRO_NOME_ESTAGIARIO, string);
    }
    public void filtrarEstagiarioPorNomeValido() {
        preencher(SELETOR_CAMPO_FILTRO_NOME_ESTAGIARIO, consultarNomeEstagiarioInformacoes());
    }
}
