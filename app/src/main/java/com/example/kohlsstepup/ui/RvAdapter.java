package com.example.kohlsstepup.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kohlsstepup.R;
import com.example.kohlsstepup.data.model.Post;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {

    List<Post> postList;
    public static final String TAG = "FRANK: ";
    private ItemClickListener clickListener;
    //CallTask result;

    public RvAdapter(List<Post> postList) {
        this.postList = postList;
    }

    @NonNull
    @Override
    public RvAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvAdapter.ViewHolder viewHolder, int position) {

        Post post = postList.get(position);
        if (post != null) {
            viewHolder.setItemPost(post);
            String title = post.getTitle();

            viewHolder.tv_Title.setText(title);
        }
    }

    @Override
    public int getItemCount() {
        return postList != null ? postList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_Title;
        Post itemPost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_Title = itemView.findViewById(R.id.tvTitle);
        }

        public void setItemPost(Post itemPost) {
            this.itemPost = itemPost;
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onClick(view, getAdapterPosition());
                Log.d(TAG, "onClick:");
            }
        }
    }

    public interface ItemClickListener {
        void onClick(View view, int position);
    }
}

