package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase{
    public ListHelper(WebDriver wd) {
        super(wd);
    }

    public void createList(String listName) {
        click(By.cssSelector(".js-add-list"));
        type(By.cssSelector(".list-name-input"),listName);
        click(By.cssSelector(".js-save-edit"));
    }

}
