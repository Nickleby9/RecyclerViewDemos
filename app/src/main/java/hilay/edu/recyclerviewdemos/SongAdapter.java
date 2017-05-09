package hilay.edu.recyclerviewdemos;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Android2017 on 5/9/2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<SongItem> data;

    public SongAdapter(Context context, List<SongItem> data) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.data = data;
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.song_item, parent, false);
        return new SongViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        SongItem song = data.get(position);
        holder.tvTitle.setText(song.getTitle());
        holder.tvArtist.setText(song.getArtist());
        holder.ivThumb.setImageResource(song.getThumbResId());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvArtist;
        ImageView ivThumb;

        public SongViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvArtist = (TextView) itemView.findViewById(R.id.tvArtist);
            ivThumb = (ImageView) itemView.findViewById(R.id.ivThumb);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    SongItem song = data.get(position);
                    Toast.makeText(context,
                            "\"" + song.getTitle() + "\"\nby \"" + song.getArtist() + "\"",
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("Song", song);
                    context.startActivity(intent);
                }
            });
        }
    }
}
