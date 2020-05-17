package dev.olaore.apiconsumption;

import java.util.List;

import dev.olaore.apiconsumption.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();

}
