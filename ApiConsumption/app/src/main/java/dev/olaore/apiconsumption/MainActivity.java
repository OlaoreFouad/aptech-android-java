package dev.olaore.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import dev.olaore.apiconsumption.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private ApiService apiService;
    private final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

        getPosts();

    }

    private void getPosts() {
        apiService.getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    Log.d(TAG, "Request got bounced for some reason!");
                    return;
                }
                Log.d(TAG, "Status Code: " + response.code());
                List<Post> posts = response.body();
                Log.d(TAG, "Posts size: " + posts.size());
                for (Post post: posts) {
                    Log.d(TAG, post.toString());
                }

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                // tell the user that the request failed!
                Log.d(TAG, "Message: " + t.getMessage());
            }
        });
    }

}
