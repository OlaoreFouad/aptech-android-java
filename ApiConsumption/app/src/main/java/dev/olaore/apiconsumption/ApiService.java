package dev.olaore.apiconsumption;

import java.util.List;

import dev.olaore.apiconsumption.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{postId}")
    Call<Post> getPost(
            @Path("postId") int id
    );

    @GET("posts")
    Call<List<Post>> getPostsByUser(
            @Query("userId") int userId
    );

    // baseUrl/posts?userId=4
//    query parameter

//    "SELECT * FROM posts WHERE userId = 4 AND id = 4"
}
