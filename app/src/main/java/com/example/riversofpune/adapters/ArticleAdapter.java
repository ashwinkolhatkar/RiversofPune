package com.example.riversofpune.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.riversofpune.Article;
import com.example.riversofpune.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private ArrayList<Article> list_members=new ArrayList<>();
    View view;
    ArticleViewHolder holder;
    private Context context;
    private OnArticleListener mOnArticleListener;

    public ArticleAdapter(ArrayList<Article> articles, OnArticleListener onArticleListener){
        this.list_members = articles;
        this.mOnArticleListener = onArticleListener;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row, parent, false);
        holder=new ArticleViewHolder(view, mOnArticleListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder holder, int position) {
        Article list_items=list_members.get(position);
        holder.content_summary.setText(list_items.getArticleContentSummary());
        //holder.content.setText(list_items.getArticleContent());
        //holder.date.setText(list_items.getArticleDate().toString());
        holder.title.setText(list_items.getArticleTitle());
        Article article = list_members.get(position);
        Glide.with(holder.thumbnail).load("file:///android_asset/" + article.getArticleContent() +
                "/" + article.getThumbnailPath()).into(holder.thumbnail);
        //holder.thumbnail.setImageResource();
    }

    public void setListContent(ArrayList<Article> list_members){
        this.list_members=list_members;
        notifyItemRangeChanged(0,list_members.size());
    }

    @Override
    public int getItemCount() {
        return list_members.size();
    }

    static class ArticleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView content_summary,date,content, title;
        ImageView thumbnail;
        OnArticleListener onArticleListener;
        public ArticleViewHolder(View itemView, OnArticleListener onArticleListener) {
            super(itemView);
            content_summary=(TextView)itemView.findViewById(R.id.content_summary);
            //content=(TextView)itemView.findViewById(R.id.content);
            //date=(TextView)itemView.findViewById(R.id.date);
            title = (TextView)itemView.findViewById(R.id.article_title);
            thumbnail = (ImageView) itemView.findViewById(R.id.picture);
            this.onArticleListener = onArticleListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onArticleListener.onArticleClick(getAdapterPosition());
        }
    }

    /*
    public void removeAt(int position) {
        list_members.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(0, list_members.size());
    }*/

    public interface OnArticleListener{
        void onArticleClick(int position);
    }
}