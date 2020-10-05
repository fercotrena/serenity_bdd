package com.automationpractice.steps;

import com.automationpractice.steps.views.Contact;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Open;

import static com.automationpractice.steps.tasks.LogIn.loginWithUserAndPassword;
import static com.automationpractice.steps.tasks.SendAMessage.sendAMessage;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class SendAMessageSteps {
    @Dado("un usuario contectado en la aplicacion")
    public void unUsuarioContectadoALaAplicacion() {
        theActorInTheSpotlight().attemptsTo(loginWithUserAndPassword("fernandocotrena@gmail.com", "admin123456"));
    }

    @Cuando("accede a la vista de Servicio al cliente")
    public void accedeALaVistaDeServicioAlCliente() {
        theActorInTheSpotlight().attemptsTo(Open.browserOn().the(Contact.class));
    }

    @Y("envia el mensaje de reclamos con los datos requeridos")
    public void enviaElMensajeDeReclamosConLosDatosRequeridos() {
        theActorInTheSpotlight()
                .attemptsTo(
                        sendAMessage("Customer service", "fernandocotrena@gmail.com", "testing"));
    }

    @Entonces("se notifica que el mensaje ha sido enviado con éxito")
    public void seNotificaQueElMensajeHaSidoEnviadoConÉxito() {
        theActorInTheSpotlight().should(eventually(seeThat(
                the(Contact.ALERT_MESSAGE), containsText(Contact.SUCCESS_MESSAGE))
        ));

    }

    @Y("envia el mensaje de reclamo sin incluir el email de contacto")
    public void enviaElMensajeDeReclamoSinIncluirElEmailDeContacto() {
        theActorInTheSpotlight()
                .attemptsTo(
                        sendAMessage("Customer service", "", "testing"));
    }

    @Entonces("se notifica que el mensaje no se pudo enviar")
    public void seNotificaQueElMensajeNoSePudoEnviar() {
        theActorInTheSpotlight().
                should(eventually(seeThat(
                        the(Contact.ALERT_MESSAGE), containsText(Contact.ERROR_MESSAGE))
                ));
    }
}
