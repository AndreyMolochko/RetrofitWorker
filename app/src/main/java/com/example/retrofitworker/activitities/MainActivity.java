package com.example.retrofitworker.activitities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.retrofitworker.App;
import com.example.retrofitworker.R;
import com.example.retrofitworker.adapters.PostAdapter;
import com.example.retrofitworker.networking.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post>postList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
        initPostListFromApi();
    }

    private void initPostListFromApi(){
        Call<List<Post>> call = App.jsonPlaceHolderApi.getPosts();
        initCall(call);
    }

    private void initRecycler(){
        postAdapter = new PostAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.activity_main_post_recycler);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                                                                                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(postAdapter);
    }

    private void initCall(Call<List<Post>> call){
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                postList = response.body();
                postAdapter.setList(postList);
                postAdapter.update();
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
    }

}
