package dev.oure.myposts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.oure.myposts.databinding.RetrofitPostsListBinding

class RetrofitRvAdapter (var context: Context, var postlist: List<Post>):
    RecyclerView.Adapter<RetrofitViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var bindingView = RetrofitPostsListBinding
            .inflate(LayoutInflater.from(context), parent, false)
        return RetrofitViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: RetrofitViewHolder, position: Int) {
//        val context = holder.itemView.context
        var currentItem = postlist.get(position)


        with(holder.bindingView){

            tvUserId.text = currentItem.userId.toString()
            tvId.text = currentItem.id.toString()
            tvTitle.text = currentItem.title
            tvBody.text = currentItem.body
        }

    }

    override fun getItemCount(): Int {
        return postlist.size
    }
}

class RetrofitViewHolder(var bindingView: RetrofitPostsListBinding):
    RecyclerView.ViewHolder(bindingView.root){

}