package com.jeevitnadi.riversofpune;

import java.util.Date;

public class Article { // POJO to store articles in Database in the future.
    private String articleContentSummary;
    private String articleContent;
    private String articleTitle;
    private Date articleDate;
    private String thumbnailPath;


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

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }
}
