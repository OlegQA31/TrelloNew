package tests_trello;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger= LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() throws InterruptedException {
        app.init();

    }


    @AfterSuite
    public void  tearDown(){
        app.stop();
    }

    @BeforeMethod(alwaysRun = true)
    public void startLogger(Method method){
        logger.info("Start test--->"+method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void finishLog(){
        logger.info("****************************************************************");
    }

}
