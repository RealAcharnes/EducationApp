package com.example.androidproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.androidproject.R;
import com.example.androidproject.utils.Constants;

import java.text.DecimalFormat;

public class ArticleDetailFragment extends Fragment implements View.OnClickListener {

    private static DecimalFormat df = new DecimalFormat("0.00");
    private String mTitle;
    private String mDescription;
    private double mScore;

    public ArticleDetailFragment(){
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param title Title of the scientific article.
     * @param description Description of the scientific article.
     * @param score Score of the scientific article.
     * @return A new instance of fragment ArticleDetailFragment.
     */
    public static ArticleDetailFragment newInstance(String title, String description, double score) {
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        Bundle args = new Bundle();
        args.putString(Constants.Article.EXTRA_TITLE, title);
        args.putDouble(Constants.Article.EXTRA_SCORE, score);
        args.putString(Constants.Article.EXTRA_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(Constants.Article.EXTRA_TITLE);
            mScore = getArguments().getDouble(Constants.Article.EXTRA_SCORE);
            mDescription = getArguments().getString(Constants.Article.EXTRA_DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_article_detail, container, false);
        //Set the title
        ((TextView) view.findViewById(R.id.articleTitleTextView)).setText(mTitle);
        //Set the score
        String score = String.valueOf(df.format(mScore));
        score = "Score : " + score;
        ((TextView) view.findViewById(R.id.articleScoreTextView)).setText(score);
        //Set the description
        ((TextView) view.findViewById(R.id.articleDescriptionTextView)).setText(mDescription);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
