package com.example.riversofpune;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class Article { // POJO to store articles in Database in the future.
    private String articleContentSummary;
    private String articleContent;
    private String articleTitle;
    private Date articleDate;
    private String[] sources;


    private String[] imageLinks; /* TODO array of links to images --> find how to change array of images to
    series of images in ImageView.
    In db implementation, maybe the pics can be downloaded prior to use in a cache? */

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContentSummary() {
        return articleContentSummary;
    }

    public void setArticleContentSummary(String articleContentSummary) {
        this.articleContentSummary = articleContentSummary;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public static class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleButtonViewHolder> {

        private ArrayList<Article> list_members=new ArrayList<>();
        private final LayoutInflater inflater;
        View view;
        ArticleButtonViewHolder holder;
        private Context context;

        public ArticleAdapter(Context context){
            this.context=context;
            inflater=LayoutInflater.from(context);
        }

        @NonNull
        @Override
        public ArticleButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            view=inflater.inflate(R.layout.custom_row, parent, false);
            holder=new ArticleButtonViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ArticleButtonViewHolder holder, int position) {
            Article list_items=list_members.get(position);
            holder.content_summary.setText(list_items.getArticleContentSummary());
            //holder.content.setText(list_items.getArticleContent());
            holder.date.setText(list_items.getArticleDate().toString());
            holder.title.setText(list_items.getArticleTitle());
        }

        public void setListContent(ArrayList<Article> list_members){
            this.list_members=list_members;
            notifyItemRangeChanged(0,list_members.size());
        }

        @Override
        public int getItemCount() {
            return list_members.size();
        }

        class ArticleButtonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            TextView content_summary,date,content, title;
            public ArticleButtonViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);
                content_summary=(TextView)itemView.findViewById(R.id.content_summary);
                //content=(TextView)itemView.findViewById(R.id.content);
                date=(TextView)itemView.findViewById(R.id.date);
                title = (TextView)itemView.findViewById(R.id.article_title);
                // TODO Add ImageViews as well.

            }

            @Override
            public void onClick(View v) {
                // TODO open article in new activity
            }
        }

        public void removeAt(int position) {
            list_members.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(0, list_members.size());
        }
    }
}
