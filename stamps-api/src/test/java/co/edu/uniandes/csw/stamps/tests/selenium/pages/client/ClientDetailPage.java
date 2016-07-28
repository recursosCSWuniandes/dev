/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages.client;

import co.edu.uniandes.csw.stamps.dtos.minimum.ClientMinimumDTO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andrés Esguerra <afesguerra at uniandes.edu.co>
 */
public class ClientDetailPage {

    @FindBy(id = "delete-client")
    private WebElement deleteBtn;

    @FindBy(id = "edit-client")
    private WebElement editBtn;

    @FindBy(id = "list-client")
    private WebElement listBtn;

    @FindBy(id = "name")
    private WebElement name;

    public void list() {
        listBtn.click();
    }

    public void edit() {
        editBtn.click();
    }

    public void delete() {
        deleteBtn.click();
    }

    public ClientMinimumDTO getData() {
        ClientMinimumDTO client = new ClientMinimumDTO();
        client.setName(name.getText());
        return client;
    }
}
