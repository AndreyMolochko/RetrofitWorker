package com.example.retrofitworker.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitworker.R;
import com.example.retrofitworker.networking.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    List<Post> postList = new ArrayList<>();

    public PostAdapter(){

    }

    PostAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =
                LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_post,
                                                                    viewGroup, false);

        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder postHolder, int i) {
        Post post = postList.get(i);
        postHolder.bind(post);
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void setList(List<Post> postList){
        this.postList=postList;
    }

    public void update(){
        notifyDataSetChanged();
    }

    public class PostHolder extends RecyclerView.ViewHolder {
        private TextView textViewId;
        private TextView textViewUserId;
        private TextView textViewTitle;
        private TextView textViewBody;


        public PostHolder(@NonNull View itemView) {
            super(itemView);

            initViews(itemView);
        }

        private void initViews(View view){
            textViewId = view.findViewById(R.id.item_recycler_post_id);
            textViewUserId = view.findViewById(R.id.item_recycler_post_user_id);
            textViewTitle = view.findViewById(R.id.item_recycler_post_title);
            textViewBody = view.findViewById(R.id.item_recycler_post_body);
        }

        private void bind(Post post){
            textViewId.setText(String.valueOf(post.getId()));
            textViewUserId.setText(String.valueOf(post.getUserId()));
            textViewBody.setText(post.getBody());
            textViewTitle.setText(post.getTitle());
        }
    }
}
