package sg.edu.rp.c346.id22001095.songappp08;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etTitle, etSingers, etYear;
    RadioGroup rgStars;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.editTextTitle);
        etSingers = findViewById(R.id.editTextSingers);
        etYear = findViewById(R.id.editTextYear);
        rgStars = findViewById(R.id.radioGroupStars);
        btnInsert = findViewById(R.id.buttonInsert);
        btnShowList = findViewById(R.id.buttonShowList);



        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                int stars;

                if (rgStars.getCheckedRadioButtonId() == R.id.radioButton1) {
                    stars = 1;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton2) {
                    stars = 2;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton3) {
                    stars = 3;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton4) {
                    stars = 4;
                } else if (rgStars.getCheckedRadioButtonId() == R.id.radioButton5) {
                    stars = 5;
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    return;
                }

                DBHelper db = new DBHelper(MainActivity.this);

                if(etTitle.getText().toString().trim().length() != 0 && etSingers.getText().toString().trim().length() != 0 && etYear.getText().toString().trim().length() != 0 && rgStars.getCheckedRadioButtonId() != -1){
                    db.insertSong(etTitle.getText().toString(), etSingers.getText().toString(), Integer.parseInt(etYear.getText().toString()), stars);
                }
                else{
                    Toast.makeText(MainActivity.this,"Error empty fields",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SongList.class);
                startActivity(intent);
            }
        });






    }
}

