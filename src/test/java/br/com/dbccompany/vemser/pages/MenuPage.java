package br.com.dbccompany.vemser.pages;

import br.com.dbccompany.vemser.utils.Elementos;
import br.com.dbccompany.vemser.utils.Seletores;
import org.openqa.selenium.By;

public class MenuPage extends Elementos {
    public static void clicarBotaoSair() {
        esperarElemento(By.cssSelector(Seletores.menu("botaoSair")));
        driver.findElement(By.cssSelector(Seletores.menu("botaoSair"))).click();
    }
    public static String consultarUsuarioLogado() {
        esperarElemento(By.cssSelector(Seletores.menu("nomeUsuario")));
        return driver.findElement(By.cssSelector(Seletores.menu("nomeUsuario"))).getText();
    }
}
