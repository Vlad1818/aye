package sonic.industries.aye;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.TextView;

public class SetProfileActivity extends ListActivity {
	
	private SeekBar seekBar;
	private TextView seekBarValue;
	private static final String[] items={"lorem", "ipsum", "dolor",
		"sit", "amet",
		"consectetuer", "adipiscing", "elit", "morbi", "vel",
		"ligula", "vitae", "arcu", "aliquet", "mollis",
		"etiam", "vel", "erat", "placerat", "ante",
		"porttitor", "sodales", "pellentesque", "augue", "purus"};
	
	@Override
	public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	setContentView(R.layout.activity_set_profile);
	setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,
			items));	
	
	seekBar = (SeekBar) findViewById(R.id.radiusBar);
	seekBarValue = (TextView) findViewById(R.id.radiusBarProgress);
	seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){ 

		   @Override 
		   public void onProgressChanged(SeekBar seekBar, int progress, 
		     boolean fromUser) { 
		    // TODO Auto-generated method stub 
		    seekBarValue.setText(String.valueOf(progress)); 
		   } 

		   @Override 
		   public void onStartTrackingTouch(SeekBar seekBar) { 
		    // TODO Auto-generated method stub 
		   } 

		   @Override 
		   public void onStopTrackingTouch(SeekBar seekBar) { 
		    // TODO Auto-generated method stub 
		   } 
		       }); 
	initialize();
	}
	
	public void accept(View v){
		
	}
		
	public void restore(View v){
		
	}
	
	public void initialize(){
	}
	
}
