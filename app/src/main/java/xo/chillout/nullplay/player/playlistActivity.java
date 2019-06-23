package xo.chillout.nullplay.player;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import xo.chillout.nullplay.R;
import xo.chillout.nullplay.databinding.ActivityPlaylistBinding;

public class playlistActivity extends AppCompatActivity {
final String TAG = "playlistActivity";
ActivityPlaylistBinding playlistBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playlistBinding = DataBindingUtil.setContentView(this,R.layout.activity_playlist);
        ArrayList<String> songNameList = new ArrayList<>();
        ArrayList<Integer> songs = new ArrayList<>();
        Addsongs(songNameList,songs);
        playlistBinding.playIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),playActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Addsongs(ArrayList<String> songNameList, ArrayList<Integer> songs) {
        songNameList.add("A girl in Oakland");
        songs.add(R.raw.a_girl_in_oakland);
        songNameList.add("Buddy");
        songs.add(R.raw.buddy);
        songNameList.add("Cute");
        songs.add(R.raw.cute);
        songNameList.add("find My way Home");
        songs.add(R.raw.find_my_way_home);
        songNameList.add("Fingers");
        songs.add(R.raw.fingers);
        songNameList.add("Happiness");
        songs.add(R.raw.happiness);
        songNameList.add("In case you forget");
        songs.add(R.raw.in_casae_you_forget);
        Log.d(TAG, "Addsongs: Size of Addsongs Array is "+songNameList.size());
        Log.d(TAG, "Addsongs: SIze of songs Array is "+songs.size());
        setupRecycleView(songNameList,songs);
    }

    private void setupRecycleView(ArrayList<String> songNameList, ArrayList<Integer> songs) {
        recycleAdapater recycleAdapater = new recycleAdapater(songNameList,this,songs);
        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        recyclerView.setAdapter(recycleAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}
