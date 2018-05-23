package cxy.com.loadingview.waterloading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import cxy.com.loadingview.R;

public class WaveActivty extends AppCompatActivity {

	WaterWaveProgress waveProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.water_wave_activity);
		SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
		waveProgress = (WaterWaveProgress) findViewById(R.id.waterWaveProgress1);
		waveProgress.setShowProgress(true);
		waveProgress.animateWave();
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
//				setTitle("" + progress);
				waveProgress.setProgress(progress);

			}
		});
		((CheckBox)findViewById(R.id.checkBox1)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					waveProgress.setShowProgress(isChecked);
			}
		});
((CheckBox)findViewById(R.id.checkBox2)).setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					waveProgress.setShowNumerical(isChecked);
			}
		});
	}
}
