package cxy.com.loadingview.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import cxy.com.loadingview.R;

public class MenuActivity extends AppCompatActivity {
    
    private MenuStyle01 menu;
    private SateliteMenu mSateliteMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu = (MenuStyle01)findViewById(R.id.lMenu);
        mSateliteMenu = (SateliteMenu) findViewById(R.id.sm_menu);

        menu.setonMenuClickListener(new MenuStyle01.onMenuClickListener() {
            @Override
            public void Pic1() {
                Toast.makeText(MenuActivity.this, "点击了Pic1", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void Pic2() {
                Toast.makeText(MenuActivity.this, "点击了Pic2", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void Pic3() {
                Toast.makeText(MenuActivity.this, "点击了Pic3", Toast.LENGTH_SHORT).show();
            }
            
            @Override
            public void Pic4() {
                Toast.makeText(MenuActivity.this, "点击了Pic4", Toast.LENGTH_SHORT).show();
            }
        });
        mSateliteMenu.setOnMenuItemClickListener(new SateliteMenu.onMenuItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), view.getTag().toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_caidan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_leftTop) {
            mSateliteMenu.setPosition(SateliteMenu.Position.POS_LEFT_TOP);
            return true;
        }
        if (id == R.id.action_rightTop) {
            mSateliteMenu.setPosition(SateliteMenu.Position.POS_RIGHT_TOP);
            return true;
        }
        if (id == R.id.action_leftBottom) {
            mSateliteMenu.setPosition(SateliteMenu.Position.POS_LEFT_BOTTOM);
            return true;
        }
        if (id == R.id.action_rightBottom) {
            mSateliteMenu.setPosition(SateliteMenu.Position.POS_RIGHT_BOTTOM);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
