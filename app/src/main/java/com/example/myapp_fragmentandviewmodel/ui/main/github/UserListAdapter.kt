package com.example.myapp_fragmentandviewmodel.ui.main.github

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp_fragmentandviewmodel.R
import com.example.myapp_fragmentandviewmodel.databinding.GithubUserViewBinding

class UserListAdapter internal constructor(
    private val context: Context,
    private val lifecycleOwner: LifecycleOwner,
    private val viewModel:GitHubViewModel
): RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    inner class UserViewHolder(
        itemView: View,
        private val binding: GithubUserViewBinding,
//        private val viewModel: GithubViewModel,
        viewModel: GitHubViewModel,
        private val lifecycleOwner: LifecycleOwner
    ): RecyclerView.ViewHolder(itemView) {

        fun bind(githubUser: GithubUser) {
            //binding
            binding.githubUser = githubUser//            binding.viewModel = viewModel
            binding.executePendingBindings()
            binding.lifecycleOwner = lifecycleOwner
        }
    }

    private var githubUsers = emptyList<GithubUser>()
    private val inflater: LayoutInflater = LayoutInflater.from(context)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: GithubUserViewBinding = DataBindingUtil.inflate( inflater, R.layout.github_user_view, parent, false)
            return UserViewHolder(binding.root, binding, viewModel, lifecycleOwner)
    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
//        val binding = GithubUserViewBinding.inflate(inflater, parent, false)
//        return UserViewHolder(binding.root,binding,lifecycleOwner) //viewModel-. has to come inside the () but we ignore Viewmodel and we can run same app with and without vm
//    }

    override fun onBindViewHolder(@NonNull holder: UserViewHolder, position: Int, payloads: MutableList<Any>) {
        holder.bind(githubUsers[position])
    }

    override fun getItemCount(): Int {
        return githubUsers.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = githubUsers[position]
        holder.bind(current)
    }

    fun users(it: List<GithubUser>) {
        this.githubUsers = it
        notifyDataSetChanged()
    }


}
