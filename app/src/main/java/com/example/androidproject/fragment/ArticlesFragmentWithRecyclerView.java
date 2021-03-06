package com.example.androidproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject.HomeActivity;
import com.example.androidproject.R;
import com.example.androidproject.interfaces.ArticleChangeListener;
import com.example.androidproject.interfaces.ArticleListener;
import com.example.androidproject.interfaces.GetDataService;
import com.example.androidproject.network.RetrofitClientInstance;
import com.example.androidproject.pojo.Article;
import com.example.androidproject.pojo.Infos;
import com.example.androidproject.utils.Constants;
import com.example.androidproject.utils.Preferences;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ArticlesFragmentWithRecyclerView extends Fragment implements ArticleChangeListener, View.OnClickListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;

    private RecyclerView mRecyclerView;
    private ArticleListener mArticleListener;
    private ProgressBar mProgressBar;
    private EditText mEditText;
    private Button mButton;
    private MyArticleRecyclerViewAdapter adapter;
    private List<Article> articles;

    private EditText mSearchUserInput;
    private String mUserInput = "science";

    public ArticlesFragmentWithRecyclerView(){}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        /** We get the date stored in the bundle of the previous intent, here we get the search input of the user. **/
        final Intent intent = getActivity().getIntent();
        if(null != intent){
            final Bundle extras = intent.getExtras();
            if (null != extras){
                mUserInput = extras.getString(Constants.CORE.EXTRA_SEARCH_INPUT);
            }
        }


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof ArticleListener)
        {
            mArticleListener = (ArticleListener) context;
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_articles_with_recycler_view_list, container, false);

        this.articles = new ArrayList<>();
        /**
         * Here we get all we need, the context, the recycler view, the progress barr, the edits text,
         * and the button. Then we create our View Adapter from our class MyArticleRecyclerViewAdapter.
         **/
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        mProgressBar = view.findViewById(R.id.loadingPanel);
        mEditText = view.findViewById(R.id.userSearchInput);
        mButton = view.findViewById(R.id.searchButton);
        adapter = new MyArticleRecyclerViewAdapter(articles, mArticleListener);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.retrieveData();

        return view;
    }


    @Override
    public void onArticleRetrieved(List<Article> articles) {
        mRecyclerView.setAdapter(new MyArticleRecyclerViewAdapter(articles, mArticleListener));
    }

    /**
     * Here we create a function to get the data from the API CORE,
     * we create an handle for the RetrofitInstance interface, then we call our function from this interface.
     * if the request is successful and we got the data we call the update function.
     * If there is a problem with the request, a toast is display to warn the user.
     */
    public void retrieveData(){

        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<Infos> call = service.doGetListArticles(mUserInput);
        call.enqueue(new Callback<Infos>() {
            @Override
            public void onResponse(@NotNull Call<Infos> call, @NotNull Response<Infos> response) {
                List<Article> articles = response.body().getArticle();
                updateData(articles);

                if(null != mArticleListener && null != articles) onArticleRetrieved(articles);


            }

            @Override
            public void onFailure(@NotNull Call<Infos> call, Throwable t) {
                Toast.makeText(getContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                Log.d("errorTag", t.getMessage());
            }
        });

    }

    /**
     * In this function we add the list of article to our local variable, then we disable the progress bar
     * because the loading is finished and we display the ViewList.
     *
     * We set a button  for the user search bar with a click listener.
     * @param articlesRetrieved the list of the article we got from the API call
     */
    public void updateData(List<Article> articlesRetrieved){
        articles.addAll(articlesRetrieved);
        adapter.notifyDataSetChanged();
        mRecyclerView.setVisibility(View.VISIBLE);
        mProgressBar.setVisibility(View.GONE);
        mEditText.setVisibility(View.VISIBLE);
        mButton.setVisibility(View.VISIBLE);


        mSearchUserInput = (EditText) getView().findViewById(R.id.userSearchInput);
        getView().findViewById(R.id.searchButton).setOnClickListener(this);
        String userInput = mSearchUserInput.getText().toString();

        if(!TextUtils.isEmpty(userInput)){
            startActivity(getHomeIntent(userInput));
        }

    }

    /**
     * On click of the search button, we put the variable into Preferences and we start the activity
     * with this String in parameter.
     * @param v the view
     */
    @Override
    public void onClick(View v) {
        String userInput;
        if(TextUtils.isEmpty(mSearchUserInput.getText())){
            return;
        }
        userInput = mSearchUserInput.getText().toString();
        Preferences.setInputSearch(userInput);

        startActivity(getHomeIntent(userInput));

    }

    /**
     * The getHomeIntent function is used to create the bundle with the search input we want to store.
     * @param userSearch the input search of the user
     * @return the Intent
     */
    private Intent getHomeIntent(String userSearch){
        Intent intent = new Intent(getActivity(), HomeActivity.class);
        final Bundle extras = new Bundle();
        extras.putString(Constants.CORE.EXTRA_SEARCH_INPUT, userSearch);
        intent.putExtras(extras);
        return intent;
    }
}
