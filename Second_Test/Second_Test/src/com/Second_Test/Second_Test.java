package com.Second_Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second_Test extends Activity 
{
	int curYear, curMonth, curDay, curHour, curMinute, curNoon, curSecond;
	
	Calendar c;
	
	String tag = null;
	String noon = "";

	Date curMillis;	

	TimerTask second;

	TextView getData;
	
	
	private final Handler handler = new Handler();	

	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button bt1 = (Button)findViewById(R.id.Button01);
		bt1.setText("���� ��¥�� �ð� ���ϱ�");
		bt1.setOnClickListener(new View.OnClickListener() 
		{
			public void onClick(View v) 
			{
				Test();
			}
		});



	}    


	private void Test() 
	{
		getData = (TextView)findViewById(R.id.TextView01);

		second = new TimerTask() 
		{	
			private String tag;

			@Override
			public void run() 
			{
				Log.d(tag, curYear+"."+curMonth+"."+curDay+"."+curHour+":"+curMinute+"."+curSecond); 				
				Update(curSecond);     			
			}
		};     	
		Timer timer = new Timer();
		timer.schedule(second, 0, 1000);

	}


	protected void Update(final int i1) 
	{			
		c = Calendar.getInstance();
		curMillis = c.getTime();
		curYear = c.get(Calendar.YEAR);
		curMonth = c.get(Calendar.MONTH)+1;
		curDay = c.get(Calendar.DAY_OF_MONTH);		
		curHour = c.get(Calendar.HOUR_OF_DAY);
		curNoon = c.get(Calendar.AM_PM);
		if(curNoon == 0)
		{
			noon = "����";
		}
		else 
		{
			noon = "����";
			curHour -= 12;
		}
		curMinute = c.get(Calendar.MINUTE);		 
		curSecond = c.get(Calendar.SECOND);
		
		
		Runnable updater = new Runnable() 
		{	        
			public void run() 
			{  				
				getData.setText("���� ��¥�� �ð��� "+curYear+"�� "+curMonth+"�� "+curDay+"�� "+						
						noon+curHour+"�� "+curMinute+"�� "+curSecond+"�� �Դϴ�. ");				
				
			}
		};
		handler.post(updater);
	}



}



