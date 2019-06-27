package xo.chillout.nullplay.player;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import xo.chillout.nullplay.R;

// Created by mac on 6/23/19.

@SuppressWarnings("SpellCheckingInspection")
public class recycleAdapater extends RecyclerView.Adapter<recycleAdapater.customviewholder> {
private ArrayList<String> SongNames;
private Context context;
private ArrayList<Integer> Songs;
private final static String TAG = "recyclerAdapter";
recycleAdapater(ArrayList<String> songNames, Context context, ArrayList<Integer> Songs){
    this.context = context;
    this.SongNames = songNames;
    this.Songs = Songs;
}

    @NonNull
    @Override
    public customviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflated = LayoutInflater.from(parent.getContext()).inflate(R.layout.reccyle_item,parent,false);
        return new customviewholder(inflated);
    }

    @Override
    public void onBindViewHolder(@NonNull final customviewholder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Executed for "+position);
        holder.songname.setText(SongNames.get(position));
        holder.rootlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),playActivity.class);
                intent.putExtra("SongUrl",Songs.get(position));
                intent.putExtra("SongName",SongNames.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return SongNames.size();
    }

    class customviewholder extends RecyclerView.ViewHolder {
    TextView songname;
    LinearLayout rootlayout;
    customviewholder(@NonNull View itemView) {
        super(itemView);
        songname = itemView.findViewById(R.id.song_name);
        rootlayout = itemView.findViewById(R.id.rootlayout);
    }
}
}
