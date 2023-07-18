package sg.edu.rp.c346.id22001095.songappp08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Song> {
    Context context;
    ArrayList<Song> al;
    int resource;

    public CustomAdapter(Context context, int resource, ArrayList<Song> al) {
        super(context, resource, al);
        this.context = context;
        this.resource = resource;
        this.al = al;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(resource, parent, false);

        TextView tvName = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvStars = rowView.findViewById(R.id.tvStars);
        TextView tvSinger = rowView.findViewById(R.id.tvSinger);

        Song currentVersion = al.get(position);

        tvName.setText(currentVersion.getTitle());
        tvYear.setText(String.valueOf(currentVersion.getYear()));
        tvStars.setText(currentVersion.toString());
        tvSinger.setText(currentVersion.getSingers());

        return rowView;
    }
}

