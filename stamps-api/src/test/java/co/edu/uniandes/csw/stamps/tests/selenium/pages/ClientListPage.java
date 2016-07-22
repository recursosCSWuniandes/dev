/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.stamps.tests.selenium.pages;

import org.jboss.arquillian.drone.api.annotation.Drone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

/**
 *
 * @author af.esguerra10
 */
public class ClientListPage {

    @Drone
    private WebDriver browser;

    @FindBy(id = "create-client")
    private WebElement createBtn;

    @FindBy(id = "refresh-client")
    private WebElement refreshBtn;

    private WebElement findNameByIndex(int index) {
        return browser.findElement(By.id(index + "-name"));
    }

    private WebElement findDetailsBtnByIndex(int index) {
        return browser.findElement(By.id(index + "-detail-btn"));
    }

    private WebElement findEditBtnByIndex(int index) {
        return browser.findElement(By.id(index + "-edit-btn"));
    }

    private WebElement findDeleteBtnByIndex(int index) {
        return browser.findElement(By.id(index + "-delete-btn"));
    }
}
