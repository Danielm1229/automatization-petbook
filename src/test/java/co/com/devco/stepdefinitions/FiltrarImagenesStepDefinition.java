package co.com.devco.stepdefinitions;

import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.devco.userinterfaces.GoogleResultadosPage.PRIMER_RESULTADO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GoogleSearchStepDefinitions {

    @Cuando("^(.*) busca (.*) en Google Search$")
    public void BuscaEnGoogleSearch(String actor, String palabra) {
        theActorCalled(actor).attemptsTo(
                BuscarEnGoogle.laPalabra(palabra)
        );
    }

    @Entonces("^debe ver como primer resultado (.*)$")
    public void debeVerComoPrimerResultado(String resultado) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(PRIMER_RESULTADO).attribute("href").contains(resultado)
        );
    }
}
