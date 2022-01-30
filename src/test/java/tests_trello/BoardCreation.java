package tests_trello;

import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test
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
}
