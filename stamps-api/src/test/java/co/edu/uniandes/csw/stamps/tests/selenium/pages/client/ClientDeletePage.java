/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages.client;

import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author af.esguerra10
 */
public class ClientDeletePage {

    @FindBy(id = "confirm-delete")
    private WebElement confirmDeleteBtn;

    @FindBy(id = "cancel-delete")
    private WebElement cancelDeleteBtn;

    public void confirm() {
        guardAjax(confirmDeleteBtn).click();
    }

    public void cancel() {
        cancelDeleteBtn.click();
    }
}