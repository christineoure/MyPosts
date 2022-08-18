package dev.oure.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.oure.myposts.databinding.RetrofitCommentListBinding



class CommentRvAdapter (var commentlist: List<Post>):
    RecyclerView.Adapter<CommentRvAdapter.CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder{
        var bindingView = RetrofitCommentListBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
//        val context = holder.itemView.context
        var currentPost = commentlist.get(position)

        var context = holder.itemView.context
        holder.bindingView.cvComments.setOnClickListener {
            val  intent = Intent(context, CommentAvtivity::class.java)
            intent.putExtra("COMMENT_ID", currentPost.id)
            context.startActivity(intent)
        }

        with(holder.bindingView){

            tvUserId1.text = currentPost.userId.toString()
            tvId1.text = currentPost.id.toString()
            tvTitle1.text = currentPost.title
            tvBody1.text = currentPost.body
        }

    }

    override fun getItemCount(): Int {
        return commentlist.size
    }


class CommentViewHolder(var bindingView: RetrofitCommentListBinding):
    RecyclerView.ViewHolder(bindingView.root){

}
}