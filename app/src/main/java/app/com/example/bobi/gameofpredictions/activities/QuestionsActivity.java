package app.com.example.bobi.gameofpredictions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.com.example.bobi.gameofpredictions.R;
import app.com.example.bobi.gameofpredictions.adapters.VerticalRecyclerAdapter;
import app.com.example.bobi.gameofpredictions.models.Question;

/**
 * Created by Bobi on 13.7.2016 г..
 */
public class QuestionsActivity extends AppCompatActivity {

    private List<Question> questions = new ArrayList<Question>();
    public final static String QUESTION_TITLE = "QUESTION_TITLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        prepareData();

        Integer id = getIntent().getIntExtra(MainActivity.CATEGORY_ID, -1);

        ArrayList<Question> specificQuestions = new ArrayList<Question>();
        for(Iterator<Question> i = questions.iterator(); i.hasNext(); ) {
            Question question = i.next();
            if (question.getCatId() == id) { specificQuestions.add(question); }
        }

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_horizontal);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerView.setAdapter(new VerticalRecyclerAdapter(specificQuestions));


        final VerticalRecyclerAdapter adapter = new VerticalRecyclerAdapter(questions);
        adapter.setOnItemClickListener( new VerticalRecyclerAdapter.ClickListener(){
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra(QUESTION_TITLE, adapter.getItem(position).getTitle());
                startActivity(intent);
            }
        });
    }

    private void prepareData() {
        Question questions = new Question(1,1,"Is Michael Bay the producer of the movie?", "Action & Adventure", "2015", "");
        this.questions.add(questions);

        questions = new Question(1,2,"Is the budget of the movie higher than $10 mil. ?", "Animation, Kids & Family", "2015", "");
        this.questions.add(questions);

        questions = new Question(2,1,"Is Michael Bay the producer of the movie?", "Action", "2015", "");
        this.questions.add(questions);

        questions = new Question(2,2,"Is the budget of the movie less than $15 mil. ?", "Animation", "2015", "");
        this.questions.add(questions);

        questions = new Question(3,1,"Does Hugh Jackman star in the movie?", "Science Fiction & Fantasy", "2015", "");
        this.questions.add(questions);

        questions = new Question(4,1,"Is the budget of the movie less than $15 mil. ?", "Action", "2015", "");
        this.questions.add(questions);

        questions = new Question(5,1,"Is the budget of the movie less than $35 mil. ?", "Action", "2015", "");
        this.questions.add(questions);

        questions = new Question(6,1,"Is the budget of the movie more than $15 mil. ?", "Action", "2015", "");
        this.questions.add(questions);
    }
}