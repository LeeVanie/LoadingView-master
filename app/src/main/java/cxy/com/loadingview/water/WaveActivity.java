package cxy.com.loadingview.water;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class WaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new WaterWaveViewWithMove(this));
    }
}
