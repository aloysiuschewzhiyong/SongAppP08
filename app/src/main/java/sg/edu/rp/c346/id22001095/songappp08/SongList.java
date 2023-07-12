package sg.edu.rp.c346.id22001095.songappp08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

public class SongList extends AppCompatActivity {

    ListView lvSongs;
    Button btnBack;
    ToggleButton toggle5Stars;
    ArrayAdapter aaSongs, aaFilteredSongs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lvSongs = findViewById(R.id.lvSongs);
        btnBack = findViewById(R.id.buttonBack);
        toggle5Stars = findViewById(R.id.toggle5Stars);

        DBHelper db = new DBHelper(SongList.this);

        ArrayList<Song> songs = db.getSongs();

        db.close();


        aaSongs = new ArrayAdapter(SongList.this, android.R.layout.simple_list_item_1, songs);
        lvSongs.setAdapter(aaSongs);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SongList.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lvSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song song = songs.get(position);
                Intent i = new Intent(SongList.this, MainActivityUpdate.class);
                i.putExtra("song", song);
                startActivity(i);

            } });

        toggle5Stars.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ArrayList<Object> filteredList = new ArrayList<>();
                    for (int i = 0; i < db.getSongs().size(); i++) {
                        if (songs.get(i).getStars() == 5) {
                            filteredList.add(songs.get(i));
                        }
                        ArrayAdapter aaFilteredList = new ArrayAdapter<>(SongList.this, android.R.layout.simple_list_item_1, filteredList);
                        lvSongs.setAdapter(aaFilteredList);
                    }


                } else {
                    lvSongs.setAdapter(aaSongs);
                }
            }
        });



    }
    @Override
    protected void onResume() {
        super.onResume();

        DBHelper db = new DBHelper(SongList.this);

        ArrayList<Song> songs = db.getSongs();

        db.close();

        songs.clear();
        songs.addAll(db.getSongs());


        aaSongs = new ArrayAdapter(SongList.this, android.R.layout.simple_list_item_1, songs);
        lvSongs.setAdapter(aaSongs);
        aaSongs.notifyDataSetChanged();


    }
    }


