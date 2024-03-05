package br.com.dbccompany.vemser.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elementos extends Navegador {

    public static void refresh(){
        driver.navigate().refresh();
    }

    public static void acessarUrl(String url){
        driver.navigate().to(url);
    }

    public static void clicar(String seletor){
        esperarElemento(By.cssSelector(seletor));
        driver.findElement(By.cssSelector(seletor)).click();
    }
    public static void clicarNoElementoIndex(String seletor, int index){
        esperarElemento(By.cssSelector(seletor));
        driver.findElements(By.cssSelector(seletor)).get(index).click();
    }
    public static String consultarTexto(String seletor){
        esperarElemento(By.cssSelector(seletor));
        return driver.findElement(By.cssSelector(seletor)).getText();
    }
    public static String consultarUrl(){
        return driver.getCurrentUrl();
    }
    public static String consultarValor(String seletor){
        esperarElemento(By.cssSelector(seletor));
        return driver.findElement(By.cssSelector(seletor)).getAttribute("value");
    }
    public static void esperarConteudoNaoVazio(String seletor){
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(By.cssSelector(seletor), "")));
    }
    public static void esperarElemento(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void esperarElementoSerVisivel(String elemento){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elemento)));
    }
    public static void esperarElementoSerClicavel(String element){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(element)));
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
    public static void preencherDepoisDeLimpar(String seletor, String texto){
        esperarElemento(By.cssSelector(seletor));
        driver.findElement(By.cssSelector(seletor)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
        driver.findElement(By.cssSelector(seletor)).sendKeys(texto);
    }
    public static void limparCampo(String seletor){
        esperarElemento(By.cssSelector(seletor));
        driver.findElement(By.cssSelector(seletor)).click();
        driver.findElement(By.cssSelector(seletor)).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    public class Modal {
        private static final String SELETOR_MODAL = "div.Toastify__toast-body > div:nth-child(2)";

        public static String consultarMensagemModal() {
            esperarConteudoNaoVazio(SELETOR_MODAL);
            return consultarTexto(SELETOR_MODAL);
        }
        public static boolean existeMensagemModal() {
            esperarConteudoNaoVazio(SELETOR_MODAL);
            return estaVisivel(SELETOR_MODAL);
        }
        public static void esperarModalAbrir() {
            esperarElemento(By.cssSelector(".Toastify__toast-body"));
        }
        public static void esperarModalFechar() {
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".Toastify__toast-body"))));
        }
        public static void fecharModal() {
            clicar("button.Toastify__close-button");
        }
    }
}
