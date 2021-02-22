package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.fragment.ArticleDetailFragment;
import com.example.androidproject.fragment.ArticlesFragmentWithRecyclerView;
import com.example.androidproject.fragment.MyArticleRecyclerViewAdapter;
import com.example.androidproject.interfaces.ArticleListener;

import com.example.androidproject.pojo.Article;
import com.example.androidproject.utils.Constants;
import com.example.androidproject.utils.Preferences;

import androidx.appcompat.widget.Toolbar;



public class HomeActivity extends AppCompatActivity implements ArticleListener {

    private MyArticleRecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private EditText mSearchUserInput;

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
        //We can add an animation
        transaction.addToBackStack(null).commit();

    }


}
