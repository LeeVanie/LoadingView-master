package cxy.com.loadingview.ggl;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import cxy.com.loadingview.R;

/**
 * @类名: ${type_name}
 * @功能描述:
 * @作者: ${user}
 * @时间: ${date}
 * @最后修改者:
 * @最后修改内容:
 */
public class GGLActivity extends AppCompatActivity {

    GuaView mGuaGuaKaView;
    GuaView mGuaGuaKaView2;

    RipClothes mRipClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ggl);

        mGuaGuaKaView = (GuaView) findViewById(R.id.st_guaguaka);
        mGuaGuaKaView.setOnGuaGuaKaCompletedListener(new GuaView.onGuaGuaKaCompletedListener() {
            @Override
            public void complete(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        mGuaGuaKaView2 = (GuaView) findViewById(R.id.st_guaguaka2);
        mGuaGuaKaView2.setOnGuaGuaKaCompletedListener(new GuaView.onGuaGuaKaCompletedListener() {
            @Override
            public void complete(String message) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        mRipClothes = (RipClothes) findViewById(R.id.rc_rip);

//        startActivity(new Intent(this, OverlayActivity.class));
    }

}
