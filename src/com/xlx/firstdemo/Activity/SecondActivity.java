package com.xlx.firstdemo.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SecondActivity extends Activity{
	Handler handler = new Handler();
	Toast t = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
	}
	
	/**
	 * 默认toast
	 * @param v
	 */
	public void openToast1(View v){
		t = Toast.makeText(getApplicationContext(), "默认", Toast.LENGTH_SHORT);
		t.show();
		
	}
	
	/**
	 * 自定义显示位置
	 * @param v
	 */
	public void openToast2(View v){
		t = Toast.makeText(getApplicationContext(), "自定义显示位置", Toast.LENGTH_SHORT);
		t.setGravity(Gravity.CENTER, 0, 0);
		t.show();
	}
	
	/**
	 *带图片
	 * @param v
	 */
	public void openToast3(View v){
		t = Toast.makeText(getApplicationContext(), "带图片", Toast.LENGTH_SHORT);
		t.setGravity(Gravity.CENTER, 0, 0);
		LinearLayout layout = (LinearLayout) t.getView();
		ImageView imageView = new ImageView(getApplicationContext());
		imageView.setImageResource(R.drawable.icon);
		layout.addView(imageView, 0);
		t.show();
	}
	
	/**
	 *其它线程
	 * @param v
	 */
	public void openToast4(View v){
		
		handler.post(new Runnable() {
			public void run() {
				t = Toast.makeText(getApplicationContext(), "其它线程", Toast.LENGTH_LONG);
				t.show();
			}
		});
		
	}
	
}
