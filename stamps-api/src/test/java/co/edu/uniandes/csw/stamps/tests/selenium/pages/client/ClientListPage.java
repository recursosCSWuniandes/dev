/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages.client;

import static org.jboss.arquillian.graphene.Graphene.waitGui;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.graphene.page.Location;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author af.esguerra10
 */
@Location("#/clients/list")
public class ClientListPage {

    @Drone
    private WebDriver browser;

    @FindBy(id = "create-client")
    private WebElement createBtn;

    @FindBy(id = "refresh-client")
    private WebElement refreshBtn;

    private String findNameByIndex(Integer index) {
        return browser.findElement(By.id(index + "-name")).getText();
    }

    private WebElement findDetailsBtnByIndex(Integer index) {
        By selector = By.id(index + "-detail-btn");
        waitGui().until().element(selector).is().visible();
        return browser.findElement(selector);
    }

    private WebElement findEditBtnByIndex(Integer index) {
        By selector = By.id(index + "-edit-btn");
        waitGui().until().element(selector).is().visible();
        return browser.findElement(selector);
    }

    private WebElement findDeleteBtnByIndex(Integer index) {
        By selector = By.id(index + "-delete-btn");
        waitGui().until().element(selector).is().visible();
        return browser.findElement(selector);
    }

    public void editClient(Integer index) {
        WebElement editButton = findEditBtnByIndex(index);
        editButton.click();
    }

    public void deleteClient(Integer index) {
        WebElement deleteButton = findDeleteBtnByIndex(index);
        deleteButton.click();
    }

    public void viewClientDetails(Integer index) {
        WebElement detailsButton = findDetailsBtnByIndex(index);
        detailsButton.click();
    }

    public void refresh() {
        waitGui().until().element(createBtn).is().visible();
        refreshBtn.click();
    }

    public void create() {
        waitGui().until().element(createBtn).is().visible();
        createBtn.click();
    }

    public Integer countClients() {
        return browser.findElements(By.cssSelector("tbody > tr")).size();
    }
}
