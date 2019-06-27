package xo.chillout.nullplay.player;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import xo.chillout.nullplay.R;

// Created by mac on 6/26/19.
public class PlayFragment extends Fragment {
    final static String TAG = "PlayFragment";
    public int SongURL;
    public String SongName;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.now_playing_fragment,container,false);
        ImageView play = view.findViewById(R.id.play_button_fragment);
        ImageView previous = view.findViewById(R.id.previous_button_fragment);
        ImageView next = view.findViewById(R.id.next_button_fragment);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playnow(view);
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playnow(view);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playnow(view);
            }
        });
        return view;
    }

    @NonNull
    private void playpause(MediaPlayer mediaPlayer) {

        if(mediaPlayer.isPlaying()){
            ImageView pause = Objects.requireNonNull(getActivity()).findViewById(R.id.play_button_fragment);
            pause.setImageResource(R.drawable.ic_play_button);
        }
        else {
            ImageView resume = Objects.requireNonNull(getActivity()).findViewById(R.id.play_button_fragment);
            resume.setImageResource(R.drawable.ic_action_name);
            playnow(getView());
        }
    }
    @NonNull
    private void playnow(View view) {
        ArrayList<Integer> songs= new ArrayList<>();
        ArrayList<String> songNameList= new ArrayList<>();
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
        int random = new Random().nextInt(songNameList.size());
        final MediaPlayer mediaPlayer = MediaPlayer.create(getContext(),songs.get(random));
        mediaPlayer.start();
        TextView songname = Objects.requireNonNull(getActivity()).findViewById(R.id.song_name_fragment);
        songname.setText(songNameList.get(random));
        final ImageView play = view.findViewById(R.id.play_button_fragment);
        play.setImageResource(R.drawable.ic_action_name);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    play.setImageResource(R.drawable.ic_play_button);
                    mediaPlayer.pause();
                }
                else {
                    play.setImageResource(R.drawable.ic_action_name);
                    mediaPlayer.start();
                }
            }
        });
    }

    public PlayFragment(){
        Log.d(TAG, "PlayFragment: Constructor called with No params");
    }
}
