package app.com.example.bobi.gameofpredictions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import app.com.example.bobi.gameofpredictions.R;
import app.com.example.bobi.gameofpredictions.adapters.HorizontalRecyclerAdapter;
import app.com.example.bobi.gameofpredictions.models.Category;

public class MainActivity extends AppCompatActivity {
    public final static String CATEGORY_ID = "CATEGORY_ID";
    private List<Category> listItemsList = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareData();

        final HorizontalRecyclerAdapter adapter = new HorizontalRecyclerAdapter(listItemsList);
        adapter.setOnItemClickListener( new HorizontalRecyclerAdapter.ClickListener(){
            @Override
            public void onItemClick(int position, View v) {
                Intent intent = new Intent(getApplicationContext(), QuestionsActivity.class);
                intent.putExtra(CATEGORY_ID, adapter.getItem(position).getId());
                startActivity(intent);
            }
        });

        RecyclerView mRecyclerView2 = (RecyclerView) findViewById(R.id.recycler_view_horizontal);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView2.setAdapter(adapter);
    }

    private void prepareData() {
        Category category = new Category(1, "Mad Max: Fury Road", "Action & Adventure", "2015", "","");
        listItemsList.add(category);

        category = new Category(2, "Inside Out", "Animation, Kids & Family", "2015", "","");
        listItemsList.add(category);

        category = new Category(3, "Star Wars: Episode VII - The Force Awakens", "Action", "2015", "","");
        listItemsList.add(category);

        category = new Category(4, "Shaun the Sheep", "Animation", "2015", "","");
        listItemsList.add(category);

        category = new Category(5, "The Martian", "Science Fiction & Fantasy", "2015", "","");
        listItemsList.add(category);

        category = new Category(6, "Mission: Impossible Rogue Nation", "Action", "2015", "","");
        listItemsList.add(category);
    }
}