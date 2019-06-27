package xo.chillout.nullplay.player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;
import java.util.Random;

import xo.chillout.nullplay.MainActivity;
import xo.chillout.nullplay.R;
import xo.chillout.nullplay.databinding.ActivityPlayBinding;

public class playActivity extends AppCompatActivity {
ActivityPlayBinding playBinding;
final String TAG = "PlayActivity";
ArrayList<String> songNameList = new ArrayList<>();
ArrayList<Integer> songs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playBinding = DataBindingUtil.setContentView(this,R.layout.activity_play);
        Playsong(playBinding);
        playBinding.playlistIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }



    private void Playsong(final ActivityPlayBinding playBinding) {
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
        if(getIntent().hasExtra("SongUrl")&&(getIntent().hasExtra("SongName"))){
            Log.d(TAG, "PlaySong: Successfully Received Intent");
            int Song = getIntent().getExtras().getInt("SongUrl");
            String SongName = getIntent().getExtras().getString("SongName");
            playBinding.PlaySongName.setText(SongName);
            final MediaPlayer player = MediaPlayer.create(this, Song);
            player.start();
            playBinding.playButton.setImageResource(R.drawable.ic_action_name);
            playBinding.playButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SongPlayPause(playBinding,player);
                }
            });
            playBinding.nextButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    player.pause();
                    int num = new Random().nextInt(songNameList.size());
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(num));
                    mediaPlayer.start();
                }
            });
            playBinding.previousButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    player.pause();
                    player.pause();
                    int num = new Random().nextInt(songNameList.size());
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),songs.get(num));
                    mediaPlayer.start();
                }
            });
        }
        else{
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
            playnow(songNameList,songs);
        }
    }

    private void playnow(final ArrayList<String> songNameList, final ArrayList<Integer> songs) {
        int random = new Random().nextInt(songNameList.size());
        int currentSong = songs.get(random);
        ArrayList<String> Songlist = songNameList;
        String currentSongName = songNameList.get(random);
        final MediaPlayer player = MediaPlayer.create(this,currentSong);
        playBinding.PlaySongName.setText(currentSongName);
        playBinding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
                playNext(new Random().nextInt(songNameList.size()),songNameList,songs);
            }
        });
        playBinding.previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player.pause();
                playPrevious(new Random().nextInt(songNameList.size()),songNameList,songs);
            }
        });
    }

    private void playPrevious(int i, ArrayList<String> songNameList, ArrayList<Integer> songs) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,songs.get(i));
        playBinding.PlaySongName.setText(songNameList.get(i));
        mediaPlayer.start();
        SongPlayPause(playBinding,mediaPlayer);
    }

    private void playNext(int i, ArrayList<String> songNameList, ArrayList<Integer> songs) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this,songs.get(i));
        playBinding.PlaySongName.setText(songNameList.get(i));
        mediaPlayer.start();
        SongPlayPause(playBinding,mediaPlayer);
    }

    private void SongPlayPause(ActivityPlayBinding playBinding, MediaPlayer player) {
        if(!player.isPlaying()){
            playBinding.playButton.setImageResource(R.drawable.ic_action_name);
            player.start();
        }
        else{
            playBinding.playButton.setImageResource(R.drawable.ic_play_button);
            player.pause();
        }
    }
}
