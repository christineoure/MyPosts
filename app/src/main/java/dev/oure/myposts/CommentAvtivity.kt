package dev.oure.myposts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import dev.oure.myposts.databinding.ActivityCommentAvtivityBinding
import retrofit2.Response
import retrofit2.http.POST
import java.util.*
import javax.security.auth.callback.Callback

class CommentAvtivity : AppCompatActivity() {
    var postId = 0
    lateinit var binding: ActivityCommentAvtivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCommentAvtivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchpost()

    }

    fun obtainPostId(){
        postId = intent.extras?.getInt("POST_ID") ?: 0
    }
    fun fetchpost(){
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.gerPostById(postId)

        request.enqueue(object: retrofit2.Callback<Post>{
            override fun onResponse(call: retrofit2.Call<Post>, response: Response<Post>) {

                    var post = response.body()
                    if (post!= null){
                        binding.tvPostTitle.text = post.title
                        binding.tvPostBody.text = post.body
                    }
            }

            override fun onFailure(call: retrofit2.Call<Post>, t: Throwable) {

            }
        })
    }
}