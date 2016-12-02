package com.xlx.firstdemo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		
        //使用intent隐式打开activity
        final Button button = (Button) findViewById(R.id.buttonId);
        button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
			    Intent intent = new Intent("second");
			    startActivity(intent);
			}
		});
        
        final Button buttonToast = (Button) findViewById(R.id.toastId);
        buttonToast.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
				Toast t = Toast.makeText(getApplicationContext(), "this is toast", Toast.LENGTH_LONG);
				t.show();
			}
		});
        
    }
    
    //显示打开activity
//    public void openSecondActivity(View view){
//      Intent intent = new Intent(this, SecondActivity.class);
//      startActivity(intent);
//    }
}