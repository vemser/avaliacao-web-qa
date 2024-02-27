package br.com.dbcompany.vemser.service;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class UsuarioService {
    private static final String URL_BASE = "http://vemser-dbc.dbccompany.com.br:39000/vemser/usuario-back/usuario";
    public static String gerarToken() {
        return
                given()
                    .contentType(ContentType.JSON).baseUri(URL_BASE)
                    .body("""
                            {
                             "username": "%s",
                             "password": "%s" 
                            }
                            """.formatted(
                                    System.getenv("DBC_USER"),
                                    System.getenv("DBC_PASSWORD")))
                .when()
                    .post("/login")
                .then()
                    .statusCode(HttpStatus.SC_OK)
                    .extract().asString();
    }
    public Integer consultarIdUsuario() {
        return
                given()
                        .contentType(ContentType.JSON).baseUri(URL_BASE)
                        .header("Authorization", gerarToken())
                .when()
                        .get("/logged-user")
                .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                            .jsonPath()
                            .getInt("idUsuario")
                ;
    }
    public void definirCargo(String json) {
        given()
            .contentType(ContentType.JSON)
            .header("Authorization", gerarToken()).baseUri(URL_BASE)
            .pathParam("idUsuario", consultarIdUsuario())
            .body(json)
        .when()
            .put("/update-cargos/{idUsuarop}")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getInt("idUsuario")
        ;
        /*
        {
          "cargos": [
            {"nome":"ROLE_INSTRUTOR","descricao":"Instrutor"}
          ]
        }
         */
    }
}
