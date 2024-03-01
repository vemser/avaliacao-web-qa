package br.com.dbcompany.vemser.dataFactory;

import br.com.dbcompany.vemser.model.AcompanhamentoModel;
import br.com.dbcompany.vemser.utils.DataFakerGenerator;
import org.apache.commons.lang3.StringUtils;

import java.sql.Time;

public class AcompanhamentoData {

    public static AcompanhamentoModel acompanhamentoComDadosValidos(){
        AcompanhamentoModel acompanhamentoDTO = new AcompanhamentoModel();
        acompanhamentoDTO.setTitulo("Teste " + DataFakerGenerator.observacoesFaker());
        acompanhamentoDTO.setDataInicio(DataFakerGenerator.dataInicialFaker());
        acompanhamentoDTO.setDataFim(DataFakerGenerator.dataFimFaker());
        acompanhamentoDTO.setHoraInicio(String.valueOf(Time.valueOf("08:00:00")));
        acompanhamentoDTO.setHoraFim(String.valueOf(Time.valueOf("12:00:00")));
        acompanhamentoDTO.setSessao(30);
        acompanhamentoDTO.setResposaveis(1);
        acompanhamentoDTO.setDescricao(DataFakerGenerator.observacoesFaker());
        return acompanhamentoDTO;
    }

    public static AcompanhamentoModel acompanhamentoComTituloEmBranco(){
        AcompanhamentoModel acompanhamentoDTO = new AcompanhamentoModel();
        acompanhamentoDTO.setTitulo(StringUtils.EMPTY);
        acompanhamentoDTO.setDataInicio(DataFakerGenerator.dataInicialFaker());
        acompanhamentoDTO.setDataFim(DataFakerGenerator.dataFimFaker());
        acompanhamentoDTO.setHoraInicio(String.valueOf(Time.valueOf("08:00:00")));
        acompanhamentoDTO.setHoraFim(String.valueOf(Time.valueOf("12:00:00")));
        acompanhamentoDTO.setSessao(30);
        acompanhamentoDTO.setResposaveis(1);
        acompanhamentoDTO.setDescricao(DataFakerGenerator.observacoesFaker());
        return acompanhamentoDTO;
    }

    public static AcompanhamentoModel acompanhamentoComResponsaveisZerados(){
        AcompanhamentoModel acompanhamentoDTO = new AcompanhamentoModel();
        acompanhamentoDTO.setTitulo("Teste " + DataFakerGenerator.observacoesFaker());
        acompanhamentoDTO.setDataInicio(DataFakerGenerator.dataInicialFaker());
        acompanhamentoDTO.setDataFim(DataFakerGenerator.dataFimFaker());
        acompanhamentoDTO.setHoraInicio(String.valueOf(Time.valueOf("08:00:00")));
        acompanhamentoDTO.setHoraFim(String.valueOf(Time.valueOf("12:00:00")));
        acompanhamentoDTO.setSessao(30);
        acompanhamentoDTO.setResposaveis(0);
        acompanhamentoDTO.setDescricao(DataFakerGenerator.observacoesFaker());
        return acompanhamentoDTO;
    }

    public static AcompanhamentoModel acompanhamentoComHorariosIguais(){
        AcompanhamentoModel acompanhamentoDTO = new AcompanhamentoModel();
        acompanhamentoDTO.setTitulo("Teste " + DataFakerGenerator.observacoesFaker());
        acompanhamentoDTO.setDataInicio(DataFakerGenerator.dataInicialFaker());
        acompanhamentoDTO.setDataFim(DataFakerGenerator.dataFimFaker());
        acompanhamentoDTO.setHoraInicio(String.valueOf(Time.valueOf("12:00:00")));
        acompanhamentoDTO.setHoraFim(String.valueOf(Time.valueOf("12:00:00")));
        acompanhamentoDTO.setSessao(30);
        acompanhamentoDTO.setResposaveis(1);
        acompanhamentoDTO.setDescricao(DataFakerGenerator.observacoesFaker());
        return acompanhamentoDTO;
    }

    public static AcompanhamentoModel acompanhamentoComDataInicialMaiorQueFinal(){
        AcompanhamentoModel acompanhamentoDTO = new AcompanhamentoModel();
        acompanhamentoDTO.setTitulo("Teste " + DataFakerGenerator.observacoesFaker());
        acompanhamentoDTO.setDataInicio("10-04-2024");
        acompanhamentoDTO.setDataFim("10-03-2024");
        acompanhamentoDTO.setHoraInicio(String.valueOf(Time.valueOf("08:00:00")));
        acompanhamentoDTO.setHoraFim(String.valueOf(Time.valueOf("12:00:00")));
        acompanhamentoDTO.setSessao(30);
        acompanhamentoDTO.setResposaveis(1);
        acompanhamentoDTO.setDescricao(DataFakerGenerator.observacoesFaker());
        return acompanhamentoDTO;
    }
}
