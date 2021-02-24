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

    /**
     * This class is the recycler view adapter. We extends this class with our custom ViewHolder class.
     */
    public MyArticleRecyclerViewAdapter(List<Article> items, ArticleListener listener) {
        this.mValues = items;
        this.mListener = listener;
    }


    /**
     * ViewHolder is the class for the custom Adapter to use the recycler view.
     * We set the view, and the characteristics of the article :  Title, description and score
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView title;
        public final TextView description;
        public final TextView score;
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

    /**
     * This function inflate the layout with the list of articles
     * @return the ViewHolder with the view
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.article_list_item, parent, false);
        return new ViewHolder(view);
    }

    /**
     * This function set the title, the description and the score from the data in our pojos.
     * The description is cut if it is too long, the user has the opportunity to click on the artcile to have more detail.
     * @param holder the holder for the recycler view
     * @param position the position of the article in the list
     */
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
