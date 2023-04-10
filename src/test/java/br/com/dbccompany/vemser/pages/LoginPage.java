package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Seletores;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Elementos {
    public static final String USUARIO_VALIDO = System.getenv("DBC_USER");
    public static final String NOME_VALIDO = USUARIO_VALIDO.split("\\.")[0];
    public static final String SENHA_VALIDO = System.getenv("DBC_PASSWORD");
    public static void preencherUsuario(String usuario) {
        esperarElemento(By.cssSelector(Seletores.login("campoUsuario")));
        driver.findElement(By.cssSelector(Seletores.login("campoUsuario"))).sendKeys(usuario);
    }
    public static void preencherSenha(String senha) {
        driver.findElement(By.cssSelector(Seletores.login("campoSenha"))).sendKeys(senha);
    }
    public static void clicarBotaoLogin() {
        driver.findElement(By.cssSelector(Seletores.login("botaoLogin"))).click();
        //Espere até que a url seja a da pagina de avaliacao
        wait.until(ExpectedConditions.urlToBe("http://vemser-dbc.dbccompany.com.br:39000/vemser/avaliacao-front/alunos"));
        //Se o elemento tiver um valor vazio, atualize a pagina
        if (driver.findElement(By.cssSelector(Seletores.menu("nomeUsuario"))).getText().equals("")){
            driver.navigate().refresh();
        }
    }
    public static boolean isPaginaDeLogin() {
        return driver.findElement(By.cssSelector(Seletores.login("campoUsuario"))).isDisplayed() &&
                driver.findElement(By.cssSelector(Seletores.login("campoSenha"))).isDisplayed() &&
                driver.findElement(By.cssSelector(Seletores.login("botaoLogin"))).isDisplayed();
    }
}
