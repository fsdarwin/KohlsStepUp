
package com.example.kohlsstepup.data.model;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostResults implements Parcelable
{

    @SerializedName("Post")
    @Expose
    private ArrayList<Post> posts = null;
    public final static Creator<PostResults> CREATOR = new Creator<PostResults>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostResults createFromParcel(Parcel in) {
            return new PostResults(in);
        }

        public PostResults[] newArray(int size) {
            return (new PostResults[size]);
        }

    }
    ;

    protected PostResults(Parcel in) {
        in.readList(this.posts, (com.example.kohlsstepup.data.model.Post.class.getClassLoader()));
    }

    public PostResults() {
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPost(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(posts);
    }

    public int describeContents() {
        return  0;
    }

}
