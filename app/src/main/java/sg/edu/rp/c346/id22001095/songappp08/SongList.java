package sg.edu.rp.c346.id22001095.songappp08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SongList extends AppCompatActivity {

    ListView lvSongs;
    Button btnBack;
    ArrayAdapter aaSongs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);

        lvSongs = findViewById(R.id.lvSongs);
        btnBack = findViewById(R.id.buttonBack);

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
    }
}