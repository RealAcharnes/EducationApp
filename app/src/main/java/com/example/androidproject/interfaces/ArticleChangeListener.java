package com.example.androidproject.interfaces;

import com.example.androidproject.pojo.Article;

import java.util.List;

public interface ArticleChangeListener {
    public void onArticleRetrieved(List<Article> articles);
}
