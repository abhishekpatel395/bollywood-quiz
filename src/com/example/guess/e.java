package com.example.guess;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class e extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e);
        final Button b;
     
      final TextView tv1,tv2,tv3;
        final EditText et;        
        b=(Button) findViewById(R.id.button1);
  
       et=(EditText) findViewById(R.id.editText1);
        tv1=(TextView) findViewById(R.id.textView1);
      
        tv2=(TextView)findViewById(R.id.textView2); 
        tv3=(TextView)findViewById(R.id.textView3); 
        new CountDownTimer(50000, 1000) { // adjust the milli seconds here

            public void onTick(long millisUntilFinished) {
         	   int seconds = (int) (millisUntilFinished / 1000) % 60 ;
         	   int minutes = (int) ((millisUntilFinished / (1000*60)) % 60);
         	   int hours   = (int) ((millisUntilFinished / (1000*60*60)) % 24);
            tv2.setText(""+String.format("%d min, %d sec", 
                            minutes,seconds));
            }

            public void onFinish() {
               tv2.setText("you lost");
               
            }
         }.start();
        
        b.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			String x=et.getText().toString();
			if(x.equalsIgnoreCase("3 idiots")){
			
			tv1.setText("you are correct");
			tv3.setText("50");
			
		//	Intent ix=new Intent(getApplicationContext(),c.class);
			//startActivity(ix);
		
			
			
			// TODO Auto-generated method stub
			}
			else{
			tv1.setText("you are wrong");
			
			
			}
			
			}
				
		
	});
    }
   
    
   
  
}

