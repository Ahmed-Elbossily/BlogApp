package com.ahmedelbossily.app.blogapp.Data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmedelbossily.app.blogapp.Model.Blog;
import com.ahmedelbossily.app.blogapp.R;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

/**
 * Created by a_anw on 11/03/2018.
 */

public class BlogRecyclerAdapter extends RecyclerView.Adapter<BlogRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Blog> blogList;

    public BlogRecyclerAdapter(Context context, List<Blog> blogList) {
        this.context = context;
        this.blogList = blogList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Blog blog = blogList.get(position);
        String imageUrl = null;

        holder.title.setText(blog.getTitle());
        holder.desc.setText(blog.getDesc());

        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(blog.getTimestamp())).getTime());

        holder.timestamp.setText(formattedDate);
        imageUrl = blog.getImage();
        Picasso.with(context).load(imageUrl).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return blogList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public TextView timestamp;
        public ImageView image;
        String userid;

        public ViewHolder(View view, Context ctx) {
            super(view);
            context = ctx;

            title = (TextView) view.findViewById(R.id.postTitleList);
            desc = (TextView) view.findViewById(R.id.postTextList);
            timestamp = (TextView) view.findViewById(R.id.timestampList);
            image = (ImageView) view.findViewById(R.id.postImageList);
            userid = null;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
