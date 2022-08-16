package dev.oure.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev.oure.myposts.databinding.ActivityMainBinding
import dev.oure.myposts.databinding.RetrofitPostsListBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPosts()
//        displayPosts()
    }
    fun getPosts(){
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        val request = apiClient.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                if (response.isSuccessful){
                    val post = response.body()!!
                    Log.d("TAG", post.toString())
                    var adapter = RetrofitRvAdapter(baseContext, post)
                    binding.rvRetrofit.adapter = adapter
                    binding.rvRetrofit.layoutManager = LinearLayoutManager(baseContext)
                    Toast.makeText(baseContext,"fetched ${post.size} posts",
                        Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    fun displayPosts(postlist: List<Post>){
        binding.rvRetrofit.layoutManager = LinearLayoutManager(this)
        val postsAdapter = RetrofitRvAdapter(baseContext,postlist)
        binding.rvRetrofit.adapter = postsAdapter
    }

}