package br.com.dbccompany.vemser.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elementos extends Navegador {
    public static void acessarUrl(String url){
        driver.navigate().to(url);
    }
    public void clicar(String seletor){
        esperarElemento(By.cssSelector(seletor));
        driver.findElement(By.cssSelector(seletor)).click();
    }
    public static String consultarTexto(String seletor){
        esperarElemento(By.cssSelector(seletor));
        return driver.findElement(By.cssSelector(seletor)).getText();
    }
    public static String consultarUrl(){
        return driver.getCurrentUrl();
    }
    public static void esperarConteudoNaoVazio(String seletor){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.cssSelector(seletor), "")));
    }
    public static void esperarElemento(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
    public static void esperarTempo(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void esperarUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public static Boolean estaVisivel(String seletor){
        esperarElemento(By.cssSelector(seletor));
        return driver.findElement(By.cssSelector(seletor)).isDisplayed();
    }
    public static void preencher(String seletor, String texto){
        esperarElemento(By.cssSelector(seletor));
        driver.findElement(By.cssSelector(seletor)).sendKeys(texto);
    }
}
