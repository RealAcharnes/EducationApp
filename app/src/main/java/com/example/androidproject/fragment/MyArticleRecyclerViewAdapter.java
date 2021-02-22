package com.example.androidproject.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.R;
import com.example.androidproject.interfaces.ArticleListener;
import com.example.androidproject.pojo.Article;

import java.text.DecimalFormat;
import java.util.List;

public class MyArticleRecyclerViewAdapter extends RecyclerView.Adapter<MyArticleRecyclerViewAdapter.ViewHolder> {

    private static DecimalFormat df = new DecimalFormat("0.00");
    private final List<Article> mValues;
    private final ArticleListener mListener;
    private Context mContext;

    public MyArticleRecyclerViewAdapter(List<Article> items, ArticleListener listener) {
        this.mValues = items;
        this.mListener = listener;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView description;
        public final TextView score;
        //public ImageView image;
        public Article mArticle;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            title = (TextView) view.findViewById(R.id.articleListItemTitleTextView);
            description = (TextView) view.findViewById(R.id.articleListItemDescriptionTextView);
            score = (TextView) view.findViewById(R.id.articleListItemScoreTextView);

            view.setOnClickListener((v)->{
                if(mListener!=null) mListener.onViewArticle(mArticle);
                }
            );

        }

        @Override
        public String toString() {
            return super.toString() + " '" + title.getText() + "'";
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.article_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Article article = (Article) mValues.get(position);

        String fullDescription = article.getSource().getDescription();

        if (fullDescription != null){
            int lenFullDescription = fullDescription.length();
            if (lenFullDescription >= 200){
                String shortDescription = fullDescription.substring(0, 200);
                shortDescription += "   [...] (Click to view more)";
                holder.description.setText(shortDescription);
            }
            else{
                holder.description.setText(fullDescription);
            }
        }
        else{
            holder.description.setText(null);
        }

        holder.title.setText(article.getSource().getTitle());
        String score = String.valueOf(df.format(article.getScore()));
        score = "Score : " + score;
        holder.score.setText(score);
        holder.mArticle = article;

    }

    @Override
    public int getItemCount() {
        return this.mValues.size();
    }

}
