package xo.chillout.nullplay;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import xo.chillout.nullplay.databinding.ActivityMainBinding;
import xo.chillout.nullplay.player.playlistActivity;
import xo.chillout.nullplay.player.playActivity;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
AHBottomNavigationItem playlist , now_playing, about;
AHBottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"Fetch Successfull from remote",Toast.LENGTH_LONG).show();
        sleep(1000);
        Intent intent = new Intent(this, playlistActivity.class);
        Intent intent1 = new Intent(this,playActivity.class);
        startActivity(intent);
    }

}
