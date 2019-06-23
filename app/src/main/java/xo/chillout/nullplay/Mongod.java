package xo.chillout.nullplay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import xo.chillout.nullplay.databinding.ActivityMongodBinding;

public class Mongod extends AppCompatActivity {
ActivityMongodBinding activityMongodBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMongodBinding = DataBindingUtil.setContentView(this,R.layout.activity_mongod);
        activityMongodBinding.fetchDbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),CoodinatorActivity.class);
                startActivity(intent);
            }
        });
    }
}
