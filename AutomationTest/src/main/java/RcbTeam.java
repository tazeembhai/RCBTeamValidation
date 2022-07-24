import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;


public class RcbTeam {
	
	@Test
	public void rcbTeamValidation()
	{
		JSONParser parser = new JSONParser();
        try
         {
        	String path = System.getProperty("user.dir");
        	
        	String filePAth = path+"\\src\\test\\resources\\TestData\\RCBTeam.json";
        	System.out.println(filePAth);
        	FileReader file = new FileReader(filePAth);
        	
        	JSONObject jsonObject = (JSONObject) parser.parse(file);
        	
             JSONArray jsonArray = (JSONArray) jsonObject.get("player");
             int foreignPlayerCount=0;
             int wicketkeeperCount=0;
             for(int  i=0;i<jsonArray.size();i++)
             {
            	 JSONObject ob= (JSONObject) jsonArray.get(i);
               	 if(!ob.get("country").toString().equalsIgnoreCase("India"))
            	 {
            		 foreignPlayerCount++;
            	 }
            	 if(ob.get("role").toString().equalsIgnoreCase("Wicket-keeper"))
            	 {
            		 wicketkeeperCount++;
            	 }
             }
             if(foreignPlayerCount == 4 && wicketkeeperCount>=1)
             {
            	 System.out.println("Validation SuccessFull team has "+foreignPlayerCount+" foreign Player and "+wicketkeeperCount+" wicket keeper");
             }else
             {
            	 System.out.println("Validation Failed team has "+foreignPlayerCount+" foreign Player and "+wicketkeeperCount+" wicket keeper");
             }
       
        }
        catch(FileNotFoundException fe)
        {
            fe.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

	}

}
