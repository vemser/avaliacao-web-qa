package br.com.dbccompany.vemser.steps;

import br.com.dbccompany.vemser.utils.Navegador;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Navegador {
    private static final String BASE_URL = "http://vemser-dbc.dbccompany.com.br:39000/vemser/avaliacao-front/alunos";

    @Before
    public void abrirNavegador(){
        abrirNavegador(BASE_URL);
    }
    @After
    public void fecharNavegador(){
        super.fecharNavegador();
    }
}
