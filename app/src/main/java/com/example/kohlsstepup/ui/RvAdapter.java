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
    private OnEntryClickListener mOnEntryClickListener;

    public RvAdapter(List<Post> postList) {
        this.postList = postList;
    }
    //This interface allows Main activity to access the clicklistener set in the viewholder
    public interface OnEntryClickListener {
        void onEntryClick(View view, int position);
    }
    //This method allows the clicklistener to be set in another activity / fragment
    public void setOnEntryClickListener(OnEntryClickListener onEntryClickListener) {
        mOnEntryClickListener = onEntryClickListener;
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
            //Set the clicklistener
            itemView.setOnClickListener(this);
        }

        public void setItemPost(Post itemPost) {
            this.itemPost = itemPost;
        }

        @Override
        public void onClick(View v) {
            // This sets the clicklistener for the items
            if (mOnEntryClickListener != null) {
                mOnEntryClickListener.onEntryClick(v, getLayoutPosition());
            }
        }
    }
}

