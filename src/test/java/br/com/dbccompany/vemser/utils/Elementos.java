package br.com.dbccompany.vemser.utils;

import br.com.dbccompany.vemser.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Elementos extends BaseSteps {
    public static void esperarTempo(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void esperarElemento(By element){
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
