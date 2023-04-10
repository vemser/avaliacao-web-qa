package br.com.dbccompany.vemser.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static br.com.dbccompany.vemser.utils.Elementos.esperarTempo;

public class Navegador {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeEach
    public void abrirNavegador(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //Abrir navegador
        driver.navigate().to("http://vemser-dbc.dbccompany.com.br:39000/vemser/avaliacao-front");
        //Maximizar tela do navegador
        driver.manage().window().maximize();
        //Aguardar para iniciar testes
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
    }
    @AfterEach
    public void fecharNavegador(){
        driver.quit();
    }
}
