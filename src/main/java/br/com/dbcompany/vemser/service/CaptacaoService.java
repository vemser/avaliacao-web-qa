package br.com.dbcompany.vemser.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class CaptacaoService {
    private static final String URL_CAPTACAO = "http://vemser-dbc.dbccompany.com.br:39000/vemser/captacao-back";
    private static final Object TOKEN = UsuarioService.gerarToken();

    public static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    public static String consultarEdicaoAtual() {
//        setUp();
        return
            given()
                .contentType(ContentType.JSON)
                .baseUri(URL_CAPTACAO)
                .header("Authorization", TOKEN)
            .when()
                .get("/edicao/edicao-atual")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().asString()
        ;
    }
    public static Boolean consultarSeCandidatoEstaNaEdicaoAtual(String cpf) {
        //Demora muito tempo para consultar
        //Se tiver o idCandidato é atual
        return
            given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN).baseUri(URL_CAPTACAO)
                .queryParam("cpf", cpf)
            .when()
                .get("/candidato/edicao-atual")
            .then()
                .extract().asString()
                .contains("idCandidato")
        ;
    }
    //http://vemser-dbc.dbccompany.com.br:39000/vemser/captacao-back/candidato?pagina=0&tamanho=20&sort=edicao&order=1
    public static ValidatableResponse consultarListaDeCandidatos(Integer pagina, Integer tamanho, String sort, Integer order) {
//        setUp();
        return
            given()
                .contentType(ContentType.JSON)
                .header("Authorization", TOKEN).baseUri(URL_CAPTACAO)
                .queryParam("pagina", pagina)
                .queryParam("tamanho", tamanho)
                .queryParam("sort", sort)
                .queryParam("order", order)
            .when()
                .get("/candidato")
            .then()
                .statusCode(HttpStatus.SC_OK)
        ;
    }
    public CaptacaoService() {
        setUp();
    }
}
