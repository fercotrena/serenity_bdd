package com.automationpractice.steps.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.automationpractice.steps.views.Contact.*;

public class SendAMessage implements Task {

    private String subject_heading;
    private String email;
    private String message;

    public SendAMessage(String subject_heading, String email, String message) {
        this.subject_heading = subject_heading;
        this.email = email;
        this.message = message;
    }

    public static SendAMessage sendAMessage(String subject_heading, String email, String message) {
        return Instrumented.instanceOf(SendAMessage.class).withProperties(subject_heading, email, message);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Clear.field(EMAIL),
                Enter.keyValues(this.email).into(EMAIL),
                SelectFromOptions.byVisibleText(this.subject_heading).from(SUBJECT_HEADING),
                Enter.keyValues(this.message).into(MESSAGE),
                Click.on(SUBMIT_MESSAGE)
        );
    }
}
