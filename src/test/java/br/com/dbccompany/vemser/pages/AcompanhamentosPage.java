package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;

public class AcompanhamentosPage extends Elementos {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/comportamental/acompanhamentos";
    // region Informações Avaliação
    private static final String SELETOR_BOTAO_AGENDAR_HORARIO = "[data-testid='AccessTimeOutlinedIcon']";
    private static final String SELETOR_BOTAO_SELECIONAR_DIA = "[id='dia']";
    private static final String SELETOR_OPCOES_SELECIONAR_DIA = "[id='menu-dia'] ul > li";
    private static final String SELETOR_BOTAO_SELECIONAR_HORARIO = "[id='horario']";
    private static final String SELETOR_OPCOES_SELECIONAR_HORARIO = "[id='menu-horario'] ul > li";
    public void clicarBotaoAgendarHorario() {
        clicar(SELETOR_BOTAO_AGENDAR_HORARIO);
    }
    public void clicarBotaoSelecionarDia() {
        clicar(SELETOR_BOTAO_SELECIONAR_DIA);
    }
    public void selecionarOpcaoDia(int index) {
        clicarNoElementoIndex(SELETOR_OPCOES_SELECIONAR_DIA, index);
    }
    public void clicarBotaoSelecionarHorario() {
        clicar(SELETOR_BOTAO_SELECIONAR_HORARIO);
    }
    public void selecionarOpcaoHorario(int index) {
        clicarNoElementoIndex(SELETOR_OPCOES_SELECIONAR_HORARIO, index);
    }
    // endregion
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public boolean estaNaPaginaDashboard() {
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
