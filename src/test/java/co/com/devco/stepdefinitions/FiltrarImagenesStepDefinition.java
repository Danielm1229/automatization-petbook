package co.com.devco.stepdefinitions;

import co.com.devco.questions.TodasLasImagenes;
import co.com.devco.tasks.Filtrar;
import io.cucumber.java.Before;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FiltrarImagenesStepDefinition {

    @Before
    public void prepareTests() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("^(.*) filtra por (.*) en petbook$")
    public void usuarioFiltraPorPerroEnPetbook(String actor, String algo) {
        theActorCalled(actor).attemptsTo(
                Filtrar.por(algo)
        );
    }

    @Entonces("^debe ver solo fotos de (.*)")
    public void debeVerSoloFotosDePerros(String algo) {
        theActorInTheSpotlight().should(seeThat(
                TodasLasImagenes.son(algo)
        ));
    }
}
