package br.com.dbcompany.vemser.service;

import br.com.dbcompany.vemser.model.ColaboradorModel;
import model.FeedBackModel;

import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;

public class ColaboradorService {
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
            .jsonPath().getList("elementos", ColaboradorModel.class)
            .forEach(estagiario -> {
                deletarEstagiarioPorIdEstagiario(estagiario.getIdEstagiario());
            });
        ;
    }
    public static String buscarNomeEstagiarioTesteFluxoAvaliacao() {
        //Busca o nome de um estagiário que não tem avaliações no Acompanhamento em Aberto do Programa atual em Aberto
        String token = UsuarioService.gerarToken();
        int idPrograma = 
            given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .baseUri(URL_AVALIACAO_API)
            .when()
                .get("/programa/get-open")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("idPrograma");
        int idAcompanhamento =
            given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .baseUri(URL_AVALIACAO_API)
                .pathParam("idPrograma", idPrograma)
                .queryParam("pagina", 0)
                .queryParam("tamanho", 10)
            .when()
                .get("/acompanhamento/list-by-programa/{idPrograma}")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("acompanhamentos.elementos.find{it.status == 'ABERTO' && it.ativo == true}.idAcompanhamento");
        String nomeEstagiario =
            given()
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .baseUri(URL_AVALIACAO_API)
                .pathParam("idAcompanhamento", idAcompanhamento)
                .queryParam("pagina", 0)
                .queryParam("tamanho", 10)
            .when()
                .get("/avaliacao/list-by-acompanhamento/{idAcompanhamento}")
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getString("elementos.find{it.status == 'ABERTO' && it.qtdFeedBacks == 0}.nomeEstagiario");
        return nomeEstagiario;
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
    // region Feedback
    public static void deletarFeedBacksByIdAvaliacao(Integer idAvaliacao) {
        given()
            .header("Authorization", UsuarioService.gerarToken())
            .baseUri(URL_AVALIACAO_API)
            .pathParam("idAvaliacao", idAvaliacao)
        .when()
            .get("/avaliacao/get-by-id/{idAvaliacao}")
        .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .jsonPath()
            .getList("feedbacks", FeedBackModel.class)
            .forEach(feedBack -> {
                deletarFeedBackById(feedBack.getIdFeedBack());
            });
    }
    public static void deletarFeedBackById(Integer idFeedback) {
        given()
            .header("Authorization", UsuarioService.gerarToken())
            .baseUri(URL_AVALIACAO_API)
            .pathParam("idFeedback", idFeedback)
        .when()
            .delete("/feedback/delete/{idFeedback}")
        .then()
            .statusCode(HttpStatus.SC_NO_CONTENT);
        ;
    }
    // endregion
}
