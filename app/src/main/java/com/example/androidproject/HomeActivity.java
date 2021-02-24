package com.example.androidproject;


import android.os.Bundle;

import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.fragment.ArticleDetailFragment;
import com.example.androidproject.fragment.ArticlesFragmentWithRecyclerView;
import com.example.androidproject.fragment.MyArticleRecyclerViewAdapter;
import com.example.androidproject.interfaces.ArticleListener;

import com.example.androidproject.pojo.Article;



public class HomeActivity extends AppCompatActivity implements ArticleListener {

    /**
     * In this class we load the fragment we need, if the user click on particular article it display
     * another fragment with more details about the article.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);


        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().add(R.id.container, new ArticlesFragmentWithRecyclerView()).commit();
        }

    }

    @Override
    public void onViewArticle(Article article) {

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        final ArticleDetailFragment fragment = ArticleDetailFragment.newInstance(article.getSource().getTitle(),
                article.getSource().getDescription(), article.getScore());
        transaction.add(R.id.container, fragment);
        transaction.addToBackStack(null).commit();

    }


}
