package tests_trello;

import manager.MyDataProvider;
import models.Board;
import models.Card;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreation extends TestBase {

    @Test(groups ={"logs"})
    public void boardCreationTest(){
        int i=(int)System.currentTimeMillis()/1000%3600;
        Board board= Board.builder()
                .title("TestQA"+i).build();

        int boardCountBeforeCreation= app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        //app.getBoard().fillBoardCreationForm("TestQA"+i);
        app.getBoard().fillBoardCreationForm(board);
        app.getBoard().scrollDownTheForm();

        app.getBoard().submitBoardCreation();

        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation= app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1 );
    }

    @Test(dataProvider = "boardDataModel",dataProviderClass = MyDataProvider.class, enabled = false)
    public void boardCreationTest2(Board board){


        int boardCountBeforeCreation= app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();

        app.getBoard().fillBoardCreationForm(board);

        app.getBoard().scrollDownTheForm();

        app.getBoard().submitBoardCreation();

        app.getBoard().isCreated();
        app.getBoard().returnToHomePage();


        int boardCountAfterCreation= app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation,boardCountBeforeCreation+1 );
    }

}
