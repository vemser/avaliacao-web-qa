package br.com.dbcompany.vemser.dataFactory;

import br.com.dbcompany.vemser.model.CriaProgramaModel;
import br.com.dbcompany.vemser.utils.DataFakerGenerator;

public class CriarProgramaData {

    public static CriaProgramaModel programaValido(){
        CriaProgramaModel programa = new CriaProgramaModel();
        programa.setNome("VEM SER " + DataFakerGenerator.gerarNumeroIntAlto());
        programa.setDataInicial(DataFakerGenerator.dataInicialFaker());
        programa.setDataFinal(DataFakerGenerator.dataFimFaker());
        programa.setDescricao("Programa de Teste do VEM SER (WEB SELENIUM)");
        programa.setSituacaoPrograma(false);
        return programa;
    }

    public static CriaProgramaModel programaComNomeRepetido(){
        CriaProgramaModel programa = new CriaProgramaModel();
        programa.setNome("VemSer 12");
        programa.setDataInicial(DataFakerGenerator.dataInicialFaker());
        programa.setDataFinal(DataFakerGenerator.dataFimFaker());
        programa.setDescricao("Programa de Teste do VEM SER (WEB SELENIUM)");
        programa.setSituacaoPrograma(false);
        return programa;
    }
}
