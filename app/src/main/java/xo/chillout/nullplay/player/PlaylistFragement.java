package xo.chillout.nullplay.player;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import xo.chillout.nullplay.R;

// Created by mac on 6/26/19.
public class PlaylistFragement extends Fragment {
ArrayList<String> songNameList = new ArrayList<>();
ArrayList<Integer> songs = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.playlist_fragment,container,false);
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
        recycleAdapater recycleAdapater = new recycleAdapater(songNameList,container.getContext(),songs);
        RecyclerView recyclerView = v.findViewById(R.id.recycle_view1);
        recyclerView.setAdapter(recycleAdapater);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        return v;
    }

}
