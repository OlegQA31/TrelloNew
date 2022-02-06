package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class AtlassianHelper extends HelperBase{
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }

    public void initChangePhoto() {
        new Actions(wd).moveToElement(wd.findElement(new By
                .ByCssSelector("[data-test-selector='profile-hover-info']")))
                .pause(3).click(wd.findElement(By.cssSelector(".css-1ujqpe8"))).perform();

        click(By.xpath("//*[@role='menuitem'] [1]"));
    }

    public void uploadPhoto() throws InterruptedException {
        attachFile((By.cssSelector("[id='image-input']")),
        new File("D:/Rep/TrelloNew/src/main/resources/3.jpg"));
        Thread.sleep(3000);
        waitForElementAndClick(By.xpath("//div[@class='sc-hgRTRy eovPat']//button[1]"),10);
    }
}
