package sonic.industries.aye;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;


/*
 * activity using by the user that requests aid
 * user also to configure buttons
 * */

public class MainActivity extends Activity {
	
	public static String appPrefs = "SolacePref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(appPrefs, 0);
        String profile = settings.getString("BigBtn1", "Not Found");
        if(profile=="Not Found"){
        	Initiallize();
        }
    }
    
    public void distressButtonHandler(View v) {

    	switch(v.getId())
    	{
	    	case R.id.ImageButton1:
	    		sendIntentonDistress("BigBtn1");
	    	break;
	    	case R.id.ImageButton2:
	    		sendIntentonDistress("BigBtn2");
	    	break;
	    	case R.id.ImageButton3:
	    		sendIntentonDistress("SmallBtn1");
	    	break;
	    	case R.id.ImageButton4:
	    		sendIntentonDistress("SmallBtn4");
	    	break;
	    	case R.id.ImageButton5:
	    		sendIntentonDistress("SmallBtn2");
	    	break;
	    	case R.id.ImageButton6:
	    		sendIntentonDistress("SmallBtn5");
	    	break;
	    	case R.id.ImageButton7:
	    		sendIntentonDistress("SmallBtn3");
	    	break;
	    	case R.id.ImageButton8:
	    		sendIntentonDistress("SmallBtn6");
	    	break;
	    	default:
	    	throw new RuntimeException("Unknow button ID");
    	}
    	
    }
    
    private void sendIntentonDistress(String btn){
        SharedPreferences settings = getSharedPreferences(appPrefs, 0);
        String profile = settings.getString(btn, "Not Found");
        if(profile=="Not Found"){
        	Initiallize();
        }
    }
    

    public void startButtonChangeActivity(View v){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("wrong password or username");
        dlgAlert.setTitle("Error Message...");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();

    }

    public void startProfileChangeActivity(View v){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

        dlgAlert.setMessage("wrong password or username");
        dlgAlert.setTitle("Error Message...");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();

    }
    
    
    private void Initiallize(){
        SharedPreferences settings = getSharedPreferences(appPrefs, 0);
        Editor editor = settings.edit();
        editor.putString("BigBtn1", "A");
        editor.putString("BigBtn2", "B");
        editor.putString("SmallBtn1", "C");
        editor.putString("SmallBtn2", "D");
        editor.putString("SmallBtn3", "E");
        editor.putString("SmallBtn4", "F");
        editor.putString("SmallBtn5", "G");
        editor.putString("SmallBtn6", "H");
        
        String profiles = "A,B,C,D,E,F,G,H,U,X";
        editor.putString("profiles", profiles);
        
        editor.putInt("radius", 500);
        
        editor.commit(); 
    }

}   
