package app.com.example.bobi.gameofpredictions.models;

import android.widget.RelativeLayout;


        import android.content.Context;
        import android.util.AttributeSet;
        import android.widget.ImageView;
        import android.widget.TextView;

import app.com.example.bobi.gameofpredictions.R;


public class Card extends RelativeLayout {
private TextView title;
private TextView description;
private ImageView thumbnail;

public Card(Context context) {
        super(context);
        init();
        }

public Card(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        }

public Card(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
        }

private void init() {
        inflate(getContext(), R.layout.recyclerview_questions, this);
        this.description = (TextView)findViewById(R.id.info);
        this.thumbnail = (ImageView)findViewById(R.id.thumbnail);
        }
}