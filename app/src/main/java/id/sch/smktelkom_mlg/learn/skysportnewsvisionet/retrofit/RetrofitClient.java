package id.sch.smktelkom_mlg.learn.skysportnewsvisionet.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mang Arblu on 12/6/2016.
 */

public class RetrofitClient {
    private static final String ROOT_URL = "https://newsapi.org/v1/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Get API Service
     *
     * @return API Service
     */
    public static ApiService getApiSerrvice() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
