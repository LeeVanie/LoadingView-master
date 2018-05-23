package cxy.com.loadingview.zfjp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;

import cxy.com.loadingview.R;
import cxy.com.loadingview.zfjp.widget.PopEnterPassword;


public class PaymentKeyBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_key_board);
    }

    public void showPayKeyBoard(View view) {

        PopEnterPassword popEnterPassword = new PopEnterPassword(this);

        // 显示窗口
        popEnterPassword.showAtLocation(this.findViewById(R.id.layoutContent),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
    }
}
