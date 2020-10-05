package com.automationpractice.steps.configuration;


import com.automationpractice.utils.WebController;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;


import static com.automationpractice.utils.WebController.getDriver;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;


public class SetUp {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Fernando").can(BrowseTheWeb.with(getDriver()));
    }

    @After
    public void afterStep() {
        WebController.quitDriver();
    }
}
