package app.com.example.bobi.gameofpredictions.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import app.com.example.bobi.gameofpredictions.R;

/**
 * Created by Bobi on 14.7.2016 г..
 */
public class DetailsActivity extends AppCompatActivity{

    TextView detQuest;
    ImageView butYes;
    ImageView butNo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detQuest = (TextView) findViewById(R.id.detailQuestion);
        butYes = (ImageView) findViewById(R.id.buttonYes);
        butNo = (ImageView) findViewById(R.id.buttonNo);

        detQuest.setText(getIntent().getStringExtra(QuestionsActivity.QUESTION_TITLE));

        butYes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DetailsActivity.super.onBackPressed();
                Toast.makeText(getApplicationContext(), "Answer Saved", Toast.LENGTH_SHORT).show();
            }
        });

        butNo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DetailsActivity.super.onBackPressed();
                Toast.makeText(getApplicationContext(), "Answer Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

