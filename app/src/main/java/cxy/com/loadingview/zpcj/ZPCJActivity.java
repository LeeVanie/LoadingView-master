package cxy.com.loadingview.zpcj;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
public class ZPCJActivity extends AppCompatActivity implements View.OnClickListener {

    private LuckyTurntable mTurntable;
    private ImageView mIvStart;

    private String[] mTitles = new String[]{"单反相机", "恭喜发财", "IPad", "再来一次",
            "IPhone", "谢谢光临", "MacBookPro", "再接再厉"};
    private int[] mImgRes = {R.drawable.danfan, R.drawable.f015, R.drawable.ipad, R.drawable.f040,
            R.drawable.iphone, R.drawable.f015, R.drawable.mac, R.drawable.f040};
    private int[] mColors = {0xffffc300, 0xfff17101, 0xffffc300, 0xfff17101,
            0xffffc300, 0xfff17101, 0xffffc300, 0xfff17101};

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mIvStart.setImageResource(R.drawable.start);
                    break;

                case 1:
                    if (msg.arg1 % 2 == 1) {// no win
                        Toast.makeText(ZPCJActivity.this, "很遗憾，请下次再来", 0).show();
                    } else {
                        Toast.makeText(ZPCJActivity.this, "恭喜中得大奖：" + mTitles[msg.arg1], 0).show();
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RelativeLayout root = new RelativeLayout(this);
        setContentView(root);

        RelativeLayout turntableLayout = new RelativeLayout(this);
        root.addView(turntableLayout);

        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        int edgeLength = Math.min(widthPixels, heightPixels);
        turntableLayout.setLayoutParams(new RelativeLayout.LayoutParams(edgeLength, edgeLength));

        mTurntable = new LuckyTurntable(this);
        mTurntable.setPadding(50, 0, 0, 0);
        turntableLayout.addView(mTurntable);

        mTurntable.setTiles(mTitles);
        mTurntable.setImgRes(mImgRes);
        mTurntable.setItemBackColors(mColors);

        mIvStart = new ImageView(this);
        RelativeLayout.LayoutParams ivStartLp = new RelativeLayout.LayoutParams(edgeLength / 4, edgeLength / 4);
        ivStartLp.addRule(RelativeLayout.CENTER_IN_PARENT);
        turntableLayout.addView(mIvStart, ivStartLp);
        mIvStart.setImageResource(R.drawable.start);
        mIvStart.setOnClickListener(this);


        mTurntable.setOnStopRotateListener(new LuckyTurntable.OnStopRotateListener() {
            @Override
            public void onStopRotate() {
                mHandler.sendEmptyMessage(0);
            }
        });

        mTurntable.setOnWinListener(new LuckyTurntable.OnWinListener() {
            @Override
            public void onWin(int index) {
                Message.obtain(mHandler, 1, index, -1).sendToTarget();
            }

            @Override
            public void onFail() {
                Message.obtain(mHandler, 1, 1, -1).sendToTarget();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == mIvStart) {
            if (!mTurntable.isStart()) {
                mIvStart.setImageResource(R.drawable.stop);
                mTurntable.setSpeed(30);
                mTurntable.luckyStart();

            } else {
                if (!mTurntable.isShouldEnd()) {
                    mTurntable.luckyStop();
                }
            }
        }
    }
}
