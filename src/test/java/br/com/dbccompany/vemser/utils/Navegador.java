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
    public static final String URL_BASE = "https://avaliacao-front-five.vercel.app";
    @BeforeAll
    public static void abrirNavegador(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.navigate().to(URL_BASE + "/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }
    @AfterAll
    public static void fecharNavegador(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.quit();
    }
}
