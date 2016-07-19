package app.com.example.bobi.gameofpredictions.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.com.example.bobi.gameofpredictions.R;
import app.com.example.bobi.gameofpredictions.models.Question;

/**
 * Created by Bobi on 4.7.2016 г..
 */
public class VerticalRecyclerAdapter extends RecyclerView.Adapter<VerticalRecyclerAdapter.MyViewHolder> {

    private List<Question> questions;
    private static ClickListener clickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public
                int catId, id;
                TextView title, author, info;
                ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            itemView.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.article_title);
            info = (TextView) view.findViewById(R.id.info);
            author = (TextView) view.findViewById(R.id.author);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        VerticalRecyclerAdapter.clickListener = clickListener;
    }

    public Question getItem(int position) {
        return questions.get(position);
    }

    public VerticalRecyclerAdapter(List<Question> questions) {
        this.questions = questions;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_questions, parent, false);
        return new MyViewHolder(itemView);
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        Question question = questions.get(position);
        holder.title.setText(question.getTitle());
        holder.info.setText(question.getInfo());
        holder.author.setText(question.getAuthor());
    }

    public void clearAdapter(){
        questions.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return questions.size();
    }
}
