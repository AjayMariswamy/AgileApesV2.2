package com.example.agileapes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // On creation of this activity, the score is set using a reference to the Global class
        TextView tvHomeBananaNumber = findViewById(R.id.tvHomeBananaNumber);
        tvHomeBananaNumber.setText("" + Global.bananas);

        Button btHomePlay = (Button) findViewById(R.id.btHomePlay);
        btHomePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(getBaseContext()));

                Intent myIntent = new Intent(getBaseContext(), QuizActivity.class);
                startActivity(myIntent);

            }
        });
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    // Go to settings screen
    public void launchSettingsScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), SettingsActivity.class);
        startActivity(myIntent);
    }

    // Go to map API
    public void launchMapScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), MapActivity.class);
        startActivity(myIntent);
    }

    public void launchLearningScreen(View v) {
        Intent myIntent = new Intent(getBaseContext(), LearningActivity.class);
        startActivity(myIntent);
    }

}
