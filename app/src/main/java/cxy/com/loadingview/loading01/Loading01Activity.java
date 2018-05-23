package cxy.com.loadingview.loading01;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import cxy.com.loadingview.R;

public class Loading01Activity extends Activity implements View.OnClickListener {

    private int progress = 0;
    ZYDownloading zyDownloading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_01);
        zyDownloading = (ZYDownloading) findViewById(R.id.acd_zydownloading);
        zyDownloading.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.acd_zydownloading:
                if (!zyDownloading.isDownloading()) {
                    progress = 0;
                    zyDownloading.startDownload();
                    handler.sendMessageDelayed(Message.obtain(), 1500);
                }
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            zyDownloading.setProgress(progress);
            if (progress < 100) {
                progress += 1;
                handler.sendMessageDelayed(Message.obtain(), 20);
            }

            super.handleMessage(msg);
        }
    };
}
