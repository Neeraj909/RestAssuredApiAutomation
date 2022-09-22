package testvagrant;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MakeTeam {
    @Test
    public void makeTeam(){
        RCB rcb = null;
        Gson gson = new Gson();
        try {
            rcb = gson.fromJson(
                    new FileReader("" + System.getProperty("user.dir") + "/resources/RCB.json"),
                    RCB.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int foreignPlayer=0;
        int wicketkeeper=0;
        for(int i=0;i<rcb.getPlayer().size();i++){
             if(!rcb.getPlayer().get(i).getCountry().equalsIgnoreCase("india") ){
                 foreignPlayer++;
             }
             if(rcb.getPlayer().get(i).getRole().equals("Wicket-keeper")){
                 wicketkeeper++;
             }
        }
        Assert.assertTrue("foreignPlayer should not be grater than four ",foreignPlayer<=4);
        Assert.assertTrue("should be have one wicket keeper",wicketkeeper>=1);
    }
}
