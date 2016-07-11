package app.com.example.bobi.gameofpredictions;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by Bobi on 4.7.2016 г..
 */
public class ListViewRowHolder extends RecyclerView.ViewHolder {

    protected NetworkImageView thumbnail;
    protected TextView title;
    protected TextView info;
    protected TextView url;
    protected TextView author;
    protected RelativeLayout relativeLayout;


    public ListViewRowHolder(View itemView) {
        super(itemView);
        this.thumbnail = (NetworkImageView) itemView.findViewById(R.id.thumbnail);
        this.title = (TextView) itemView.findViewById(R.id.title);
        this.info = (TextView) itemView.findViewById(R.id.info);
        this.url = (TextView) itemView.findViewById(R.id.url);
        this.author = (TextView) itemView.findViewById(R.id.author);
        this.relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relLayout);

        itemView.setClickable(true);
    }
}
