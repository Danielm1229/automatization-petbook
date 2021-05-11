package co.com.devco.questions;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class TodasLasImagenes implements Question<Boolean> {
    private String algo;

    public TodasLasImagenes(String algo){
        this.algo = algo;
    }

    public static TodasLasImagenes son(String algo){

        return new TodasLasImagenes(algo);

    }

    @Override
    public Boolean answeredBy(Actor actor) {

        WebDriver driver = getDriver();
        List<WebElement> fotos = getDriver().findElements(By.tagName("li"));

        System.out.println("cantidad de fotos "+fotos.size());
        System.out.println(this.algo);


        HashMap<String, Integer> MapaFotos = new HashMap<String, Integer>();
        MapaFotos.put("perro", 3);
        MapaFotos.put("gato", 2);
        if(this.algo.equalsIgnoreCase("perro")){
            System.out.println("estado perros : "+ (MapaFotos.get(this.algo)==fotos.size()));
            return (MapaFotos.get(this.algo).equals(fotos.size()));
        }else {
            return (MapaFotos.get(this.algo).equals(fotos.size()));
        }

    }
}
