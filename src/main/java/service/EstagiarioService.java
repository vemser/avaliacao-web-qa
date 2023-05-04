package service;

import io.restassured.response.Response;
import model.EstagiarioModel;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;

public class EstagiarioService {
    private static final String URL_AVALIACAO_API = "http://vemser-dbc.dbccompany.com.br:39000/vemser/avaliacao-back";
    public static void deletarEstagiariosTeste() {
        given()
            .contentType(ContentType.JSON)
            .header("Authorization", UsuarioService.gerarToken()).baseUri(URL_AVALIACAO_API)
            .queryParam("pagina", 0)
            .queryParam("tamanho", 5)
            .queryParam("nomeEstagiario", "teste")
        .when()
            .get("/estagiario/list-all")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .jsonPath().getList("elementos", EstagiarioModel.class)
            .forEach(estagiario -> {
                deletarEstagiarioPorIdEstagiario(estagiario.getIdEstagiario());
            });
        ;
    }
    // region DELETE Estagiario
    private static void deletarEstagiarioPorIdEstagiario(Integer idEstagiario) {
        given()
            .header("Authorization", UsuarioService.gerarToken()).baseUri(URL_AVALIACAO_API)
            .pathParam("idEstagiario", idEstagiario)
        .when()
            .delete("/estagiario/delete/{idEstagiario}")
        .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
        ;
    }
    // endregion
}
