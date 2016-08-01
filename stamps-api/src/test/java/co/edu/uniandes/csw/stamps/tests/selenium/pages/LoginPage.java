/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages;

import co.edu.uniandes.csw.stamps.tests.Utils;
import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import static org.jboss.arquillian.graphene.Graphene.waitModel;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrés Esguerra <afesguerra at uniandes.edu.co>
 */
@Location("#/login")
public class LoginPage {

    @FindBy(id = "username-input")
    private WebElement usernameInput;

    @FindBy(id = "password-input")
    private WebElement passwordInput;

    @FindBy(id = "log-in-btn")
    private WebElement registerBtn;

    public void login() {
        login(Utils.username, Utils.password);
    }

    public void login(String username, String password) {
        waitModel().until().element(usernameInput).is().visible();
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        guardAjax(registerBtn).click();
    }
}
