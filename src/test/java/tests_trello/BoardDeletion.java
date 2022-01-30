package tests_trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase {

    @Test
    public void testBoardDeletion() throws InterruptedException {
        int boardCountBeforeDeletion=app.getBoard().getBoardCount();
        app.getBoard().clickOnFirstBoard();
        app.getBoard().openSideBoardMenu();
        app.getBoard().openMore();
        app.getBoard().closeBoard();

        int boardCountAfterDeletion=app.getBoard().getBoardCount();
        //Assert.assertEquals(boardCountAfterDeletion,boardCountBeforeDeletion+1);
    }

}
