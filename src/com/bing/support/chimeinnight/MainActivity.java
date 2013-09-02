package com.bing.support.chimeinnight;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

/**
 * TODO:
 * 1. Add service to monitor hardware key: power + volume down, to report current time
 * 2. How to use tts(Text to Speech)
 * @author Administrator
 *
 */
public class MainActivity extends Activity implements OnClickListener, OnSeekBarChangeListener{
	
	private SeekBar soundBar = null;
	private Button btnTestVolume = null;
	private Button btnConfirmVolume = null;
	private TextView tVolume = null;
	private AudioManager audiomanage = null;
	private int maxVolume;
	private int currentVolume;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initComponents();
	}
	
	private void initComponents(){
		soundBar = (SeekBar)findViewById(R.id.adjust_volume);
		btnTestVolume = (Button)findViewById(R.id.test_volume);
		btnConfirmVolume = (Button)findViewById(R.id.confirm_volume);
		tVolume = (TextView)findViewById(R.id.current_volume);
		audiomanage = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		maxVolume = audiomanage.getStreamMaxVolume(AudioManager.STREAM_MUSIC);  //获取系统最大音量  
        soundBar.setMax(maxVolume);   //拖动条最高值与系统最大声匹配  
        currentVolume = audiomanage.getStreamVolume(AudioManager.STREAM_MUSIC);  //获取当前值  
        soundBar.setProgress(currentVolume);
        tVolume.setText(currentVolume*100/maxVolume + " %");
        soundBar.setOnSeekBarChangeListener(this);
        
        btnTestVolume.setWillNotDraw(true);
        btnConfirmVolume.setWillNotDraw(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.test_volume:
			break;
		case R.id.confirm_volume:
			break;
		default:
			break;
		
		}
	}

	@Override
	public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser) {
		 audiomanage.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_SHOW_UI);    
         currentVolume = audiomanage.getStreamVolume(AudioManager.STREAM_MUSIC);  //获取当前值  
//         soundBar.setProgress(currentVolume);
         tVolume.setText(currentVolume*100/maxVolume + " %");   
	}

	@Override
	public void onStartTrackingTouch(SeekBar arg0) {
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar arg0) {
		
	}

}
