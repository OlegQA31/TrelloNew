package manager;

import models.Board;
import models.Card;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> boardData(){
        List<Object[]> list=new ArrayList<>();

        list.add(new Object[]{"test11"});
        list.add(new Object[]{"test12"});
        list.add(new Object[]{"test13"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> boardDataModel(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{Board.builder().title("test21").build()});
        list.add(new Object[]{Board.builder().title("test22").build()});
        list.add(new Object[]{Board.builder().title("test22").build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> dataCardCSV() throws IOException {
        List<Object[]> list=new ArrayList<>();

        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/dataCardCSV.csv")));
        String line = reader.readLine();
        while(line!=null){
            String [] split=line.split(",");
            list.add(new Object[]{Card.builder()
                    .cardName(split[0])
                    .color(split[1])
                    .build()});
            line=reader.readLine();
        }
        return list.iterator();
    }
}
