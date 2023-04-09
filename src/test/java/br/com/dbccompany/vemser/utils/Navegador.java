package br.com.dbccompany.vemser.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Navegador {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LocalStorage localStorage;
    public void abrirNavegador(String url){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        //Abrir navegador
        driver.get(url);
        //Maximizar tela do navegador
        driver.manage().window().maximize();
        //Aguardar 2 segundos para iniciar testes
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    public void fecharNavegador(){
        //Fecha o navegador
        driver.quit();
    }
}
