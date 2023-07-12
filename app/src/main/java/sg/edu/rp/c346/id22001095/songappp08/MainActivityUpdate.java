package sg.edu.rp.c346.id22001095.songappp08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityUpdate extends AppCompatActivity {
    EditText etTitle, etSingers, etYear;
    RadioGroup rgStars;
    RadioButton radio1, radio2,radio3,radio4,radio5;
    Button btnUpdate, btnDelete;
    Song song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_update);

        etTitle = findViewById(R.id.editTextTitle);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        rgStars = findViewById(R.id.radioGroupStars);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        radio1 = findViewById(R.id.radioButton1);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);
        radio4 = findViewById(R.id.radioButton4);
        radio5 = findViewById(R.id.radioButton5);

        Intent i = getIntent();
        song = (Song) i.getSerializableExtra("song");

        etTitle.setText(song.getTitle());
        etSingers.setText(song.getSingers());
        etYear.setText(String.valueOf(song.getYear()));
        int stars = song.getStars();

        if(stars == 1){
            radio1.setChecked(true);
        }
        else if(stars ==2){
            radio2.setChecked(true);
        }
        else if(stars ==3){
            radio3.setChecked(true);
        }
        else if(stars ==4){
            radio4.setChecked(true);
        }
        else if(stars ==5){
            radio5.setChecked(true);
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivityUpdate.this);
                song.setTitle(etTitle.getText().toString());
                song.setTitle(etTitle.getText().toString());
                song.setYear(Integer.parseInt(etYear.getText().toString()));

                int newStars;
                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton1) {
                    newStars = 1;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton2) {
                    newStars = 2;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton3) {
                    newStars = 3;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton4) {
                    newStars = 4;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton5) {
                    newStars = 5;
                } else {
                    Toast.makeText(MainActivityUpdate.this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                song.setStars(newStars);

                dbh.updateSong(song);
                dbh.close();
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivityUpdate.this);
                dbh.deleteSong(song.getId());

                finish();

            }
        });


    }


}