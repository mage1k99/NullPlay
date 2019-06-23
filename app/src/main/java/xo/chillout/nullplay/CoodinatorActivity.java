package xo.chillout.nullplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import xo.chillout.nullplay.databinding.ActivityCoodinatorBinding;

public class CoodinatorActivity extends AppCompatActivity {
ActivityCoodinatorBinding activityCoodinatorBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCoodinatorBinding = DataBindingUtil.setContentView(this,R.layout.activity_coodinator);
        activityCoodinatorBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"First Snackbar",Snackbar.LENGTH_SHORT).setAction("Home", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                }).show();
            }
        });
    }
}
