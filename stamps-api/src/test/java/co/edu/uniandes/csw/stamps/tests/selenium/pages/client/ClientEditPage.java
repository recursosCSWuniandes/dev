/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages.client;

import co.edu.uniandes.csw.stamps.dtos.minimum.ClientMinimumDTO;
import static org.jboss.arquillian.graphene.Graphene.guardAjax;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrés Esguerra <afesguerra at uniandes.edu.co>
 */
public class ClientEditPage {

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "save-client")
    private WebElement saveBtn;

    @FindBy(id = "cancel-client")
    private WebElement cancelBtn;

    public void saveClient(ClientMinimumDTO client) {
        nameInput.clear();
        nameInput.sendKeys(client.getName());
        guardAjax(saveBtn).click();
    }
}
