package br.com.dbccompany.vemser.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Navegador {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static final String URL_BASE = "https://avaliacao-front-five.vercel.app";
    @BeforeEach
    public void abrirNavegador(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        driver.navigate().to(URL_BASE + "/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
    }
    @AfterEach
    public void fecharNavegador(){
        driver.quit();
    }
}
