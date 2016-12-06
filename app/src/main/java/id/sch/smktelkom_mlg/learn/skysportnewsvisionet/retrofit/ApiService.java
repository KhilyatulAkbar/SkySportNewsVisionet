package id.sch.smktelkom_mlg.learn.skysportnewsvisionet.retrofit;

import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.model.ArticleList;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mang Arblu on 12/6/2016.
 */

public interface ApiService {
    @GET("articles?source=sky-sports-news&sortBy=top&apiKey=55ac049a2f8a4606a3b2b9dd18376ec7")
    Call<ArticleList> getMyJSON();
}
