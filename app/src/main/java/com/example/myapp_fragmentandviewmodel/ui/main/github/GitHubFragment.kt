package com.example.myapp_fragmentandviewmodel.ui.main.github

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp_fragmentandviewmodel.R
import com.example.myapp_fragmentandviewmodel.databinding.FragmentGitHubBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitHubFragment : Fragment() {

    companion object {
        fun newInstance() = GitHubFragment()
    }

    private lateinit var binding: FragmentGitHubBinding

    private lateinit var viewModel: GitHubViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_git_hub, container, false)

        viewModel = ViewModelProvider(this).get(GitHubViewModel::class.java)
        binding = DataBindingUtil.inflate(
       inflater,R.layout.fragment_git_hub,
       container,false
   )
        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.users_recycleView)
        val adapter =  UserListAdapter(binding.root.context,this,viewModel)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(binding.root.context)

        viewModel.users.observe(viewLifecycleOwner, Observer {
            adapter.users(it)
        })

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(GitHubViewModel::class.java)
        // TODO: Use the ViewModel
    }

}