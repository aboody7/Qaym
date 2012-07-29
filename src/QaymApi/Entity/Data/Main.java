package QaymApi.Entity.Data;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;





import Qaym.API.Connection.Connection;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Main extends Activity{
	
	
	protected Object obj;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
       
        
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
      
      //Get the data (see above)
        JSONArray json = null;
		
			json = Connection.getJsonArray("tags/key=");
		
   
     
             try{
            	 
          //  JSONArray	 json = new JSONArray(Sjson);
            	 
      	//Get the element that holds the earthquakes ( JSONArray )
      	//JSONArray  earthquakes = json.getJSONArray("results");

            	       	//Loop the Array
              for(int i=0;i < json.length();i++){						

              	HashMap<String, String> map = new HashMap<String, String>();
              	JSONObject e = json.getJSONObject(i);

              //	map.put("id",  String.valueOf(i));
                //map.put("id", e.getString("country_id")) ;
              
              	map.put("name", "" + e.getString("tag"));
              //	map.put("magnitude", "Magnitude: " +  e.getString("magnitude"));
              	mylist.add(map);
              
      	}
             }catch(JSONException e)        {
             	 Log.e("log_tag", "Error parsing data "+e.toString());
             }

    
   }


}