package cxy.com.loadingview.loading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cxy.com.loadingview.R;

public class LoadMainActivity extends AppCompatActivity {
    private LoadingView loadingview;
    private Button btnStart;
    private Button btnStop;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingview = (LoadingView) findViewById(R.id.loadingview);

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingview.start();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingview.stop();
            }
        });



    }
}
