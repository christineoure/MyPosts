package dev.oure.myposts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.oure.myposts.databinding.RetrofitPostsListBinding

class RetrofitRvAdapter (var postlist: List<Post>):
    RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView = RetrofitPostsListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
//        val context = holder.itemView.context
        var currentPost = postlist.get(position)

        var context = holder.itemView.context
        holder.bindingView.cvPosts.setOnClickListener {
            val  intent = Intent(context, CommentAvtivity::class.java)
            intent.putExtra("POST_ID", currentPost.id)
            context.startActivity(intent)
        }

        with(holder.bindingView){

            tvUserId.text = currentPost.userId.toString()
            tvId.text = currentPost.id.toString()
            tvTitle.text = currentPost.title
            tvBody.text = currentPost.body
        }

    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitPostsListBinding):
    RecyclerView.ViewHolder(bindingView.root){

}