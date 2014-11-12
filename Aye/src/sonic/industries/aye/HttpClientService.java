package sonic.industries.aye;

import android.app.IntentService;
import android.content.Intent;

/*
 * service that is used by the requesting user
 * gathers gps and wifi data and posts it to the server
 */
public class HttpClientService extends IntentService {

	public HttpClientService(){
		super("HttpClientService");
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
	}

}
