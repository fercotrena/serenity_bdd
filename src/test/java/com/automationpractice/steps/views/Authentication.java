package com.automationpractice.steps.views;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/index.php?controller=authentication&back=my-account")
public class Authentication extends PageObject {

    public static Target EMAIL = Target.the("Email").located(By.id("email"));
    public static Target PASSWORD = Target.the("Password").located(By.id("passwd"));
    public static Target SUBMIT_LOGIN = Target.the("Submit Login").located(By.cssSelector("#SubmitLogin > span"));

}
