package sonic.industries.aye;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;


/*
 * activity using by the user that requests aid
 * user also to configure buttons
 * */

public class MainActivity extends Activity {

	private static final Logger log = Logger.getLogger( MainActivity.class.getName() );
	public static String appPrefs = "SolacePref";
	public static String androidId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    	androidId = Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID);
    	
        SharedPreferences settings = getSharedPreferences(appPrefs, 0);
        String profile = settings.getString("BigBtn1", "Not Found");
        if(profile=="Not Found"){
        	Initiallize();
        }
        

        Intent i = new Intent(this, HttpClientService.class);
        startService(i);
        
      	try{
      		log.info("starting loading gps");
            LocationManager locationManager = (LocationManager) 
            		getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String bestProvider = locationManager.getBestProvider(criteria, false);
            Location location = locationManager.getLastKnownLocation(bestProvider);

        LocationListener loc_listener = new LocationListener() {

            public void onLocationChanged(Location l) {}

            public void onProviderEnabled(String p) {}

            public void onProviderDisabled(String p) {}

            public void onStatusChanged(String p, int status, Bundle extras) {}
        };
        locationManager
                .requestLocationUpdates(bestProvider, 0, 0, loc_listener);
  		log.info("did request to gps");
        } catch (Exception e) {
            log.info("Error"+e.getMessage());
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
    	startActivity(new Intent(this, SetProfileActivity.class));
    	

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
