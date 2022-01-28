package tests_trello;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preConditions(){
        if (app.getUser().isLogged()) {
            app.getUser().logout();
        }
    }

    @Test
    public void loginTest1() throws InterruptedException {
        //User user=new User().withEmail("ol-dyom@yandex.ru").withPassword("Frencis8534@"); //class model

        User user= User.builder()    //lombok model
                .email("ol-dyom@yandex.ru")
                .password("Frencis8534@")
                .build();
        app.getUser().initLogin();
        //app.getUser().fillLoginForm("ol-dyom@yandex.ru","Frencis8534@");
        app.getUser().fillLoginForm(user);
        app.getUser().submitLogin();
        app.getUser().isLoggedSuccess();//Thread.sleep(5000);

        Assert.assertTrue(app.getUser().isLoggedSuccess());

    }
//    @Test(enabled = false)
//    public void loginTest2() {
//
//        initLogin();
//        type(By.cssSelector("#user"), "ol-dyom@yandex.ru");
//        click(By.cssSelector("#login"));
//        click(By.cssSelector(".dlMUdg"));
//        type(By.cssSelector("#password"),"Frencis8534@");
//        submitLogin();
//
//    }







}

