package sonic.industries.aye;

import android.app.Activity;
import android.os.Bundle;

/*
 * this activity is started whenever a a user has accepted an aid request
 */
public class ChatActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
	}
	
	
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

}
