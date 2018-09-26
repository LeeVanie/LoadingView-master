package cxy.com.loadingview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cxy.com.loadingview.biaopan.BPMainActivity;
import cxy.com.loadingview.download.DownLoadActivity;
import cxy.com.loadingview.flow01.FlowMainActivity;
import cxy.com.loadingview.ggl.GGLActivity;
import cxy.com.loadingview.loading.LoadMainActivity;
import cxy.com.loadingview.loading01.Loading01Activity;
import cxy.com.loadingview.menu.MenuActivity;
import cxy.com.loadingview.miclock.MiClockActivity;
import cxy.com.loadingview.timezhou.TimeMainActivity;
import cxy.com.loadingview.water.SigleWaveActivity;
import cxy.com.loadingview.water.WaveActivity;
import cxy.com.loadingview.waterloading.WaveActivty;
import cxy.com.loadingview.zfjp.ZFJPMainActivity;
import cxy.com.loadingview.zpcj.ZPCJActivity;

public class MainActivity extends AppCompatActivity {
    
    private ListView listview;
    private List<String> mStringList;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_adapter);
        
        mStringList = new ArrayList<>();
        getListDatas();
        listview = (ListView) findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStringList);
        
        listview.setAdapter(adapter);
        
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(MainActivity.this, DownLoadActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, FlowMainActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, LoadMainActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, Loading01Activity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, TimeMainActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, WaveActivty.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, BPMainActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, MiClockActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, ZFJPMainActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, MenuActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, ZPCJActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, SigleWaveActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, WaveActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(MainActivity.this, GGLActivity.class));
                        break;
                }
            }
        });

    }

    public void getListDatas() {
        mStringList.add("下载样式");
        mStringList.add("流式布局（单选、多选、点击）");
        mStringList.add("旋转加载样式");
        mStringList.add("弹跳下载样式");
        mStringList.add("时间轴（水平、垂直）");
        mStringList.add("水波下载样式");
        mStringList.add("表盘样式");
        mStringList.add("小米时钟");
        mStringList.add("支付键盘");
        mStringList.add("菜单");
        mStringList.add("转盘抽奖");
        mStringList.add("一个水波");
        mStringList.add("多个水波");
        mStringList.add("刮刮乐");
    }
}
//jhfghfh