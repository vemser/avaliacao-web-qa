package br.com.dbccompany.vemser.utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Navegador {
    public static WebDriver driver;
    public static WebDriverWait wait;
    @BeforeAll
    public static void abrirNavegador(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("http://vemser-dbc.dbccompany.com.br:39000/vemser/vemser-front");
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
    }
    @AfterAll
    public static void fecharNavegador(){
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.quit();
    }
}
