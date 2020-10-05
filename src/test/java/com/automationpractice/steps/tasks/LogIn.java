package com.automationpractice.steps.tasks;

import com.automationpractice.steps.views.Authentication;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

public class LogIn implements Task {
    private String email;
    private String pass;

    public LogIn(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public static LogIn loginWithUserAndPassword(String email, String pass) {
        return Instrumented.instanceOf(LogIn.class).withProperties(email, pass);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(Authentication.class),
                Enter.keyValues(this.email).into(Authentication.EMAIL),
                Enter.keyValues(this.pass).into(Authentication.PASSWORD),
                Click.on(Authentication.SUBMIT_LOGIN));
    }
}
