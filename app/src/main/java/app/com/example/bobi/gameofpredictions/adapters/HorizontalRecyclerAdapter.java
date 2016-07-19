package app.com.example.bobi.gameofpredictions.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.com.example.bobi.gameofpredictions.R;
import app.com.example.bobi.gameofpredictions.models.Category;

/**
 * Created by Bobi on 4.7.2016 г..
 */
public class HorizontalRecyclerAdapter extends RecyclerView.Adapter<HorizontalRecyclerAdapter.MyViewHolder> {
    private static ClickListener clickListener;
    private List<Category> categories;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, author, info;
        ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            itemView.setOnClickListener(this);
            title = (TextView) view.findViewById(R.id.card_title);
            info = (TextView) view.findViewById(R.id.info);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        HorizontalRecyclerAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public Category getItem(int position) {
        return categories.get(position);
    }

    public HorizontalRecyclerAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_categories, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position){
        final Category category = categories.get(position);
        holder.title.setText(category.getTitle());
        holder.info.setText(category.getInfo());
    }

    public void clearAdapter(){
        categories.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount(){
        return categories.size();
    }
}
