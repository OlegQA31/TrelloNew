package manager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver wd;
    EventFiringWebDriver wd;

    BoardHelper board;
    UserHelper user;
    ListHelper list;
    CardHelper card;
    AtlassianHelper atlassian;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() throws InterruptedException {
        if(browser.equals(BrowserType.CHROME)){
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            wd=new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests start in 'Chrome' browser");
        }else if(browser.equals(BrowserType.EDGE)){
            EdgeOptions edgeOptions=new EdgeOptions();
            WebDriverManager.edgedriver().setup();
            wd=new EventFiringWebDriver(new EdgeDriver());
        }

        // System.setProperty("webdriver.chrome.driver", "C:/Users/julia/Documents/QA/QA_Automation/QA/QA31_Trello1/chromedriver.exe");
        logger.info("Tests start");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        wd.navigate().to("https://trello.com/");

        user= new UserHelper(wd);
        board= new BoardHelper(wd);
        list=new ListHelper(wd);
        card=new CardHelper(wd);
        atlassian=new AtlassianHelper(wd);
        user.login("ol-dyom@yandex.ru","Frencis8534@");
        wd.register(new MyListener());
    }

    public void stop() {
        logger.info("Tests are finished");
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

    public AtlassianHelper getAtlassian() {
        return atlassian;
    }

    public String getURL(){
        return wd.getCurrentUrl();
    }
}
