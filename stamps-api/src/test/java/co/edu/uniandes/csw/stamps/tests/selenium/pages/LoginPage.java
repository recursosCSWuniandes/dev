/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages;

import co.edu.uniandes.csw.stamps.tests.Utils;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.jboss.arquillian.graphene.Graphene.waitGui;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrés Esguerra <afesguerra at uniandes.edu.co>
 */
@Location("#/login")
public class LoginPage {

    @FindBy(id = "login-btn")
    private WebElement goToLoginBtn;

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
        waitGui().until().element(goToLoginBtn).is().visible();
        goToLoginBtn.click();
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        registerBtn.click();
        try {
            Thread.sleep(60000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
