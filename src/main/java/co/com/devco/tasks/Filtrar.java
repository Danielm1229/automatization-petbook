package co.com.devco.tasks;

import groovy.util.logging.Log4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import java.text.MessageFormat;

import static co.com.devco.userinterfaces.PetbookPage.PETBOOK_URL;
//import static co.com.devco.userinterfaces.PetbookPage.getFilterButton;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Filtrar implements Task {
    private String filtro;

    public Filtrar(String filtro) {
        this.filtro = filtro;
    }

    public static Performable por(String filtro) {
        return instrumented(Filtrar.class, filtro);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String xPath = "//button[.=\"{0}\"]";
        MessageFormat fmt = new MessageFormat(xPath);
        xPath = fmt.format(new String[]{this.filtro});
        Target boton = Target.the("Botón de filtro de todos").located(By.xpath(xPath));
        actor.attemptsTo(
                Open.url(PETBOOK_URL),
                Click.on(boton)
        );
    }
}
