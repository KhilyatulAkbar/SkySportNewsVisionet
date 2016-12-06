package id.sch.smktelkom_mlg.learn.skysportnewsvisionet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Mang Arblu on 12/6/2016.
 */

public class ArticleList {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("sortBy")
    @Expose
    private String sortBy;

    @SerializedName("articles")
    @Expose
    private ArrayList<Articles> articles = new ArrayList<>();

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
