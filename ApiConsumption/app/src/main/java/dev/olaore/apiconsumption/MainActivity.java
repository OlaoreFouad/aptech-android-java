package dev.olaore.apiconsumption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        Post post = new Post(2, "Posted Title", "Post Content");
        apiService.addPost(post).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                int statusCode = response.code();
                Post returnedPost = response.body();

                Log.d(TAG, "Status Code: " + statusCode + "\nPost: " + returnedPost.toString());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Log.d(TAG, "Error: " + t.getMessage());
            }
        });

        Button sendReqButton = findViewById(R.id.send_req_button);
        EditText postIdEditText = findViewById(R.id.id_edit_text);
        sendReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!postIdEditText.getText().toString().isEmpty()) {
                    int postId = Integer.parseInt(postIdEditText.getText().toString());
                    getPost(postId);
                }
            }
        });

        Button userSendReqButton = findViewById(R.id.send_req_button_user_id);
        EditText userIdEditText = findViewById(R.id.user_id_edit_text);
        userSendReqButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!userIdEditText.getText().toString().isEmpty()) {
                    int userId = Integer.parseInt(userIdEditText.getText().toString());
                    getPostsByUser(userId);
                }
            }
        });

    }

    private void getPost(int postId) {
        TextView result = findViewById(R.id.text_result);

        apiService.getPost(postId).enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                int statusCode = response.code();
                Post post = response.body();

                result.setText("");
                result.append("Status Code: " + statusCode + "\n");
                result.append(post.toString());

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                result.setText("Error: " + t.getMessage());
            }
        });

    }

    private void getPostsByUser(int userId) {
        TextView userTextResult = findViewById(R.id.user_id_text_result);

        apiService.getPostsByUser(userId).enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                int statusCode = response.code();
                if (!response.isSuccessful()) {
                    userTextResult.setText("Status Code: " + statusCode);
                    return;
                }

                userTextResult.setText("");
                List<Post> postsByUser = response.body();
                userTextResult.append("Status Code: " + statusCode + "\n");
                userTextResult.append("Number Of Posts By UserId " + userId + " is: " + postsByUser.size());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                userTextResult.setText("Error: " + t.getMessage());
            }
        });

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
//                    Log.d(TAG, post.toString());
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
