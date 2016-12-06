package id.sch.smktelkom_mlg.learn.skysportnewsvisionet;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.adapter.ArticleAdapter;
import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.model.ArticleList;
import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.model.Articles;
import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.retrofit.ApiService;
import id.sch.smktelkom_mlg.learn.skysportnewsvisionet.retrofit.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /**
     * Views
     */
    private ListView listView;
    private View parentView;

    private ArrayList<Articles> articlesList;
    private ArticleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /**
         * Array List for Binding Data from JSON to this List
         */
        articlesList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(parentView, articlesList.get(position).getTitle() + " => " + articlesList.get(position).getAuthor(), Snackbar.LENGTH_LONG).show();
            }
        });

        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */
        Toast toast = Toast.makeText(getApplicationContext(), R.string.string_click_to_load, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull final View view) {

                if (InternetConnection.checkConnection(getApplicationContext())) {
                    final ProgressDialog dialog;
                    /**
                     * Progress Dialog for User Interaction
                     */
                    dialog = new ProgressDialog(MainActivity.this);
                    dialog.setTitle(getString(R.string.string_getting_json_title));
                    dialog.setMessage(getString(R.string.string_getting_json_message));
                    dialog.show();

                    //Creating an object of our api interface
                    ApiService api = RetrofitClient.getApiSerrvice();

                    /**
                     * Calling JSON
                     */
                    Call<ArticleList> call = api.getMyJSON();

                    /**
                     * Enqueue Callback will be call when get response...
                     */
                    call.enqueue(new Callback<ArticleList>() {
                        @Override
                        public void onResponse(Call<ArticleList> call, Response<ArticleList> response) {
                            //Dismiss Dialog
                            dialog.dismiss();

                            if (response.isSuccessful()) {
                                /**
                                 * Got Successfully
                                 */
                                articlesList = response.body().getArticles();

                                /**
                                 * Binding that List to Adapter
                                 */
                                adapter = new ArticleAdapter(MainActivity.this, articlesList);
                                listView.setAdapter(adapter);

                            } else {
                                Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ArticleList> call, Throwable t) {
                            dialog.dismiss();
                        }
                    });

                } else {
                    Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
