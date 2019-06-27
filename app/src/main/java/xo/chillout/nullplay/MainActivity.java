package xo.chillout.nullplay;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import xo.chillout.nullplay.databinding.ActivityMainBinding;
import xo.chillout.nullplay.player.PlayFragment;
import xo.chillout.nullplay.player.PlaylistFragement;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,new PlaylistFragement()).commit();
        mainBinding.bottomNavigationAndroid.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selected = null;
                switch (item.getItemId()){
                    case R.id.playlist:
                        selected = new PlaylistFragement();
                        break;
                    case R.id.playing:
                        selected = new PlayFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,selected).commit();
                return true;
            }
        });
    }

}
