package app.com.example.bobi.gameofpredictions;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bobi on 4.7.2016 г..
 */
public class RecyclerAdapter extends RecyclerView.Adapter<ListViewRowHolder> {

    private List<Category> categories = new ArrayList<>();
    private Context mContext;
    private ImageLoader mImageLoader;
    private int focusedItem = 0;

    public RecyclerAdapter(Context context, List<Category> categories){
        this.categories = categories;
        this.mContext = context;
    }

    @Override
    public ListViewRowHolder onCreateViewHolder(final ViewGroup viewGroup, int position){
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card2, null);
        ListViewRowHolder holder = new ListViewRowHolder(v);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView redditUrl = (TextView) v.findViewById(R.id.url);
                String postUrl = redditUrl.getText().toString();
                Intent intent = new Intent(mContext, WebActivity.class);
                intent.putExtra("url",postUrl);
                mContext.startActivity(intent);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(final ListViewRowHolder listViewRowHolder, int position){
        Category category = categories.get(position);
        listViewRowHolder.itemView.setSelected(focusedItem == position); //?
        listViewRowHolder.getLayoutPosition();

        mImageLoader = MySingleton.getInstance(mContext).getImageLoader();
        listViewRowHolder.thumbnail.setImageUrl(category.getThumbnail(),mImageLoader);
        listViewRowHolder.thumbnail.setDefaultImageResId(R.drawable.placeholder);

        listViewRowHolder.title.setText(category.getTitle());
        listViewRowHolder.info.setText(category.getInfo());
        listViewRowHolder.author.setText(category.getAuthor());
        listViewRowHolder.url.setText(category.getUrl());
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
