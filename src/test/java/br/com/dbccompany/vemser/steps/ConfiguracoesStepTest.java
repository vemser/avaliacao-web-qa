package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.pages.AcessoPage;
import br.com.dbccompany.vemser.pages.ConfiguracoesPage;
import br.com.dbccompany.vemser.pages.ConfiguracoesProgramasPage;
import br.com.dbccompany.vemser.pages.LoginPage;
import br.com.dbccompany.vemser.utils.Navegador;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class ConfiguracoesStepTest extends Navegador {
    static LoginPage loginPage = new LoginPage();
    static AcessoPage acessoPage = new AcessoPage();
    static ConfiguracoesPage configuracoesPage = new ConfiguracoesPage();
    static ConfiguracoesProgramasPage configuracoesProgramasPage = new ConfiguracoesProgramasPage();
    @BeforeAll
    public static void acessarPaginaAvaliacao() {
        loginPage.realizarLoginComSucesso();
        acessoPage.estaNaPaginaAcesso();
        configuracoesPage.acessarPagina();
    }
    @Test
    @Disabled
    @Story("Configurações de Programas")
    @Description("Criar um novo programa")
    @DisplayName("Criar um novo programa")
    public void testCriarNovoPrograma() {
        Assertions.assertTrue(configuracoesPage.estaNaPaginaConfiguracoes());
        configuracoesPage.clicarBotaoProgramasConfig();
        Assertions.assertTrue(configuracoesProgramasPage.estaNaPaginaConfiguracoesPrograma());
        configuracoesProgramasPage.clicarBotaoCriarPrograma();
        Assertions.assertTrue(configuracoesProgramasPage.estaNaPaginaCriarPrograma());
        configuracoesProgramasPage.preencherCampoCriarNomePrograma("Programa Teste");
        configuracoesProgramasPage.preencherCampoCriarDataInicioPrograma("05-05-2023");
        configuracoesProgramasPage.preencherCampoCriarDataFimPrograma("08-08-2023");
        configuracoesProgramasPage.preencherCampoCriarDescricaoPrograma("Programa Teste");
        configuracoesProgramasPage.clicarBotaoCriarSituacaoPrograma();
        configuracoesProgramasPage.clicarBotaoCriarSituacaoOpcoes(1);
        // configuracoesProgramasPage.clicarBotaoCriarProsseguirPrograma();
        // Assertions.assertFalse(configuracoesProgramasPage.estaNaPaginaCriarPrograma());
        //Necessário aguardar pelo deploy das páginas seguintes
    }
}
