package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Seletores;
import org.openqa.selenium.By;
import org.openqa.selenium.html5.WebStorage;

public class BasePage extends Elementos {
    public static String consultarUsuarioLogado() {
        esperarElemento(By.cssSelector(Seletores.menu("nomeUsuario")));
        return driver.findElement(By.cssSelector(Seletores.menu("nomeUsuario"))).getText();
    }
    public void logarComToken(String token){
        //Setar token no localStorage
        localStorage = ((WebStorage) driver).getLocalStorage();
        localStorage.setItem("token", token);
        //Atualizar página
        driver.navigate().refresh();
        //Define delay antes de iniciar teste
        esperarTempo(2000);
    }
    public static void logarComUsuario(String usuario, String senha) {
        esperarElemento(By.cssSelector(Seletores.login("campoUsuario")));
        driver.findElement(By.cssSelector(Seletores.login("campoUsuario"))).sendKeys(usuario);
        driver.findElement(By.cssSelector(Seletores.login("campoSenha"))).sendKeys(senha);
        driver.findElement(By.cssSelector(Seletores.login("botaoLogin"))).click();
        //Recarrega página por conta de um erro recorrente no login
        esperarElemento(By.cssSelector(Seletores.menu("nomeUsuario")));
        driver.navigate().refresh();
        //Define delay antes de iniciar teste
        esperarTempo(2000);
    }

    public static void sairDaConta() {
        esperarElemento(By.cssSelector(Seletores.menu("botaoSair")));
        driver.findElement(By.cssSelector(Seletores.menu("botaoSair"))).click();
    }
    public static boolean isPaginaDeLogin() {
        return driver.findElement(By.cssSelector(Seletores.login("campoUsuario"))).isDisplayed() &&
                driver.findElement(By.cssSelector(Seletores.login("campoSenha"))).isDisplayed() &&
                driver.findElement(By.cssSelector(Seletores.login("botaoLogin"))).isDisplayed();
    }
}
