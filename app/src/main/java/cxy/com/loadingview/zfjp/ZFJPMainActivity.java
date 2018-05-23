package cxy.com.loadingview.zfjp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cxy.com.loadingview.R;

public class ZFJPMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zfjp_main);
    }

    public void toNormalKeyBoard(View view) {
        startActivity(new Intent(this, NormalKeyBoardActivity.class));
    }

    public void toPayKeyBoard(View view) {
        startActivity(new Intent(this, PaymentKeyBoardActivity.class));
    }
}
