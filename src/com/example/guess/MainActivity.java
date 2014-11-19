package com.example.guess;

import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	private TextView bat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
      
        final Button b,b2;
      
        final TextView tv1,tv,tv2,tv3;
        final EditText et;       
        b=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
       et=(EditText)findViewById(R.id.editText1);
        tv1=(TextView)findViewById(R.id.textView2);
        tv=(TextView)findViewById(R.id.textView1); 
        tv2=(TextView)findViewById(R.id.textView3); 
        tv3=(TextView)findViewById(R.id.textView5);
        bat=(TextView)findViewById(R.id.textView4);
        this.registerReceiver(this.batteryinfoReciever,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        new CountDownTimer(50000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
         	   int seconds = (int) (millisUntilFinished / 1000) % 60 ;
         	   int minutes = (int) ((millisUntilFinished / (1000*60)) % 60);
         	   int hours   = (int) ((millisUntilFinished / (1000*60*60)) % 24);
            tv3.setText(""+String.format("%d min, %d sec", 
                            minutes,seconds));
            }

            public void onFinish() {
               tv3.setText("you lost");
             
            }
         }.start();
        b2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				

				
				tv2.setText("first movie directed by rajkumar hirani");
	
				
			}
		});
    b.setOnClickListener(new OnClickListener() {
		
		public void onClick(View v) {
			String x=et.getText().toString();
			
			if(x.equalsIgnoreCase("munna bhai mbbs")){
			
			tv1.setText("you are correct");
			tv.setText("your score 10");

			Intent i=new Intent(MainActivity.this,b.class);
		startActivity(i);
			
			
			// TODO Auto-generated method stub
			}
			else{
			tv1.setText("you are wrong");
			tv.setText("your score 0");
			
			
			}
				
		}
	});
    }
    private BroadcastReceiver   batteryinfoReciever=new  BroadcastReceiver(){
    	public void onReceive(Context context,Intent intent){
    		int health=intent.getIntExtra(BatteryManager.EXTRA_HEALTH,0);
    		int icon_small=intent.getIntExtra(BatteryManager.EXTRA_ICON_SMALL,0);
    		int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
    		int plugged=intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,0);
    		boolean present=intent.getExtras().getBoolean(BatteryManager.EXTRA_PRESENT);
    		int scale=intent.getIntExtra(BatteryManager.EXTRA_SCALE,0);
    		int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
    		String technology=intent.getExtras().getString(BatteryManager.EXTRA_TECHNOLOGY);
    	int temp=intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0);
    	int voltage=intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE, 0);
    	bat.setText("Health:"+health+"\n"+"Level:"+level);
    	Toast.makeText(context, "Battery Level Fine",8000).show();
    	
    	
    	}
    };
  


}
