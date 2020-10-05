package com.automationpractice.steps.views;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("/index.php?controller=contact")
public class Contact extends PageObject {

    public static Target EMAIL = Target.the("Email").located(By.id("email"));
    public static Target MESSAGE = Target.the("Message").located(By.id("message"));
    public static Target SUBJECT_HEADING = Target.the("Subject Heading").located(By.id("id_contact"));
    public static Target SUBMIT_MESSAGE = Target.the("Submit Message").located(By.cssSelector("#submitMessage > span"));
    public static Target ALERT_MESSAGE = Target.the("Alert message").located(By.cssSelector(".alert"));
    public static String SUCCESS_MESSAGE = "Your message has been successfully sent to our team.";
    public static String ERROR_MESSAGE = "Invalid email address.";


}
