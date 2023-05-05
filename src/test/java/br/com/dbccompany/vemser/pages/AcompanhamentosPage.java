package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Tabelas;

public class AcompanhamentosPage extends Elementos {
    public static final String URL_PAGINA = URL_BASE + "/avaliacao-front/comportamental/acompanhamentos";
    // region Informações Avaliação
    private static final String SELETOR_BOTAO_AGENDAR_HORARIO = "[data-testid='AccessTimeOutlinedIcon']";
    private static final String SELETOR_BOTAO_CANCELAR_AGENDAMENTO = "div.css-k9kc57:nth-child(1) > button.MuiButton-outlined.MuiButton-outlinedError";
    private static final String SELETOR_BOTAO_CONFIRMAR_CANCELAR_AGENDAMENTO = "div.css-1lrz974 > button.MuiButton-containedError";
    private static final String SELETOR_BOTAO_AVALIAR_ESTAGIARIO = "#simple-tabpanel-0 > div > p > div.MuiBox-root.css-bls5l9 > div:nth-child(2) > button";
    private static final String SELETOR_ABA_FEEDBACK_GP = "[id='simple-tab-1']";
    public void clicarBotaoAgendarHorario() {
        clicar(SELETOR_BOTAO_AGENDAR_HORARIO);
    }
    public void clicarBotaoCancelarAgendamento() {
        clicar(SELETOR_BOTAO_CANCELAR_AGENDAMENTO);
    }
    public void clicarBotaoConfirmarCancelarAgendamento() {
        clicar(SELETOR_BOTAO_CONFIRMAR_CANCELAR_AGENDAMENTO);
    }
    public void clicarBotaoAvaliarEstagiario() {
        clicar(SELETOR_BOTAO_AVALIAR_ESTAGIARIO);
    }
    public void clicarAbaFeedbackGP() {
        clicar(SELETOR_ABA_FEEDBACK_GP);
    }
    public String consultarIdFeedback() {
        return Tabelas.consultarTextoPorDataIdDataField("1", "data");
    }
    // endregion
    // region Criar agendamento
    private static final String SELETOR_BOTAO_SELECIONAR_DIA = "[id='dia']";
    private static final String SELETOR_OPCOES_SELECIONAR_DIA = "[id='menu-dia'] ul > li";
    private static final String SELETOR_BOTAO_SELECIONAR_HORARIO = "[id='horario']";
    private static final String SELETOR_OPCOES_SELECIONAR_HORARIO = "[id='menu-horario'] ul > li";
    private static final String SELETOR_BOTAO_AGENDAR = "form > div > button";
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
    public void clicarBotaoAgendar() {
        clicar(SELETOR_BOTAO_AGENDAR);
    }
    // endregion
    public void acessarPagina() {
        acessarUrl(URL_PAGINA);
    }
    public boolean estaNaPaginaDashboard() {
        return driver.getCurrentUrl().equals(URL_PAGINA);
    }
}
