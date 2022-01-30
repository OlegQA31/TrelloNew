package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    BoardHelper board;
    UserHelper user;
    ListHelper list;
    CardHelper card;



    public void init() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        // System.setProperty("webdriver.chrome.driver", "C:/Users/julia/Documents/QA/QA_Automation/QA/QA31_Trello1/chromedriver.exe");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

        user= new UserHelper(wd);
        board= new BoardHelper(wd);
        list=new ListHelper(wd);
        card=new CardHelper(wd);
        user.login("ol-dyom@yandex.ru","Frencis8534@");
    }

    public void stop() {
        //wd.close();
        //wd.quit();
    }

    public BoardHelper getBoard() {
        return board;
    }

    public UserHelper getUser() {
        return user;
    }

    public ListHelper getList() {
        return list;
    }

    public CardHelper getCard() {
        return card;
    }
}
