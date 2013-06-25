package hss.mirim;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class AlarmSampleActivity extends Activity {
	
	private AlarmManager am;
	private PendingIntent pIntent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        pIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        
        findViewById(R.id.btnSetAlarm).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				am.setRepeating(AlarmManager.RTC, System.currentTimeMillis() + 5000, 5000, pIntent);
				//현재 시간 기준으로, 현재 시간으로 부터 5초 후, 5초마다
			}
		});
        
        findViewById(R.id.btnReset).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				am.cancel(pIntent);
			}
		});
        
    }//onCreate
}