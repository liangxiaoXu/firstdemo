package com.xlx.firstdemo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.provider.SyncStateContract.Constants;
import android.view.Surface;
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
        
        //选择一个联系人
        final Button selectContact = (Button) findViewById(R.id.selectContactId);
        selectContact.setOnClickListener(new View.OnClickListener() {
			public void onClick(View paramView) {
			    Intent intent = new Intent(Intent.ACTION_PICK, Contacts.CONTENT_URI);
			    startActivityForResult(intent, 1);
			}
		});
        
    }
    
    /**
     * 回调，取数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//    	super.onActivityResult(requestCode, resultCode, data);
    	if(resultCode == Activity.RESULT_OK &&
    			requestCode == 1 ){
    		Cursor cursor = getContentResolver().query(data.getData(), new String[]{Contacts.DISPLAY_NAME}, 
    				null, null, null);
    		if(cursor.moveToFirst()){
    			int columnIndex = cursor.getColumnIndex(Contacts.DISPLAY_NAME);
    			String name = cursor.getString(columnIndex);
    			Toast t = Toast.makeText(getApplicationContext(), "你选择的联系人名字是:" + name, Toast.LENGTH_LONG);
    			t.show();
    		}
    	}
    	
    }
    
    //显式打开activity
//    public void openSecondActivity(View view){
//      Intent intent = new Intent(this, SecondActivity.class);
//      startActivity(intent);
//    }
}