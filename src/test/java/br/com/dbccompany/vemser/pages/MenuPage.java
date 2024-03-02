package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;


public class MenuPage extends Elementos {
    private static final String SELETOR_BOTAO_DASHBOARD = "[data-testid=\"dashboard-menu-btn\"]";
    private static final String SELETOR_BOTAO_COLABORADORES = "[data-testid=\"estagiarios-menu-btn\"]";
    private static final String SELETOR_BOTAO_COMPORTAMENTAL = "";
    private static final String SELETOR_BOTAO_TECNICO = "[data-testid=\"tecnico-menu-btn\"]";
    private static final String SELETOR_BOTAO_CONFIGURACOES = "[data-testid=\"configuracoes-menu-btn\"]";
    private static final String SELETOR_BOTAO_AUSENCIAS = "[data-testid=\"ausencias-btn\"]";

    // Métodos de CLICAR
//    public static void clicarBotaoAcompanhamentos() {
//        clicar(SELETOR_BOTAO_ACOMPANHAMENTOS);
//    }
//    public static void validarComportamental() {
//        clicar(SELETOR_BOTAO_COMPORTAMENTAL);
//        clicar(SELETOR_BOTAO_ACOMPANHAMENTO_GP);
//    }
    private static final String SELETOR_BOTAO_TECNICO_FEEDBACK = "nav svg[data-testid=\"ThumbUpOutlinedIcon\"]";
    private static final String SELETOR_BOTAO_ACOMPANHAMENTOS = "[data-testid=\"acompanhamentos-menu-btn\"]";
    private static final String SELETOC_BOTAO_ACOMPANHAMENTO_GP = "ul[class='MuiList-root MuiList-padding css-1ontqvh'] span[class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-ikw04q']";
    public static void clicarBotaoAcompanhamentos() {
        clicar(SELETOR_BOTAO_ACOMPANHAMENTOS);
    }
    public static void clicarBotaoComportamental() {
        clicar(SELETOR_BOTAO_COMPORTAMENTAL);
        clicar(SELETOC_BOTAO_ACOMPANHAMENTO_GP);
    }
    public void clicarBotaoConfiguracoes() {
        clicar(SELETOR_BOTAO_CONFIGURACOES);
    }
    public void clicarBotaoDashboard() {
        clicar(SELETOR_BOTAO_DASHBOARD);
    }
    public void clicarBotaoEstagiarios() {
        clicar(SELETOR_BOTAO_COLABORADORES);
    }

    public static void clicarBotaoTecnico() {
        clicar(SELETOR_BOTAO_TECNICO);
    }
    public static void clicarBotaoTecnicoFeedback() {
        clicar(SELETOR_BOTAO_TECNICO_FEEDBACK);
    }

    // Métodos de VALIDAR
    public boolean validarDashboard() {
        clicar(SELETOR_BOTAO_DASHBOARD);
        return estaVisivel(SELETOR_BOTAO_DASHBOARD);
    }
    public boolean validarColaboradores() {
        clicar(SELETOR_BOTAO_COLABORADORES);
        return estaVisivel(SELETOR_BOTAO_COLABORADORES);
    }
    public boolean validarTecnico() {
        clicar(SELETOR_BOTAO_TECNICO);
        return estaVisivel(SELETOR_BOTAO_TECNICO);
    }
    public boolean validarConfiguracoes() {
        clicar(SELETOR_BOTAO_CONFIGURACOES);
        return estaVisivel(SELETOR_BOTAO_CONFIGURACOES);
    }
    public boolean validarAusencias() {
        clicar(SELETOR_BOTAO_AUSENCIAS);
        return estaVisivel(SELETOR_BOTAO_AUSENCIAS);
    }

}
