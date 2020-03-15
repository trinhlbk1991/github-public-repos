package com.trinhlbk.githubpublicrepo.components.repolist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.trinhlbk.core.entities.Repo
import com.trinhlbk.githubpublicrepo.R
import com.trinhlbk.githubpublicrepo.utils.Status.*
import kotlinx.android.synthetic.main.activity_repo_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepoListActivity : AppCompatActivity() {

    val viewModel: RepoListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_list)

        viewModel.getRepoList()
            .observe(this, Observer { resource ->
                when (resource.status) {
                    SUCCESS -> bindRepoList(resource.data)
                    ERROR -> showError(resource.message)
                    LOADING -> showLoadingProgress()
                }
            })

        viewModel.loadRepoList()
    }

    private fun showLoadingProgress() {
        Toast.makeText(this, "Loading...", Toast.LENGTH_SHORT).show()
    }

    private fun showError(message: String?) {
        Toast.makeText(this, "Error: $message", Toast.LENGTH_SHORT).show()
    }

    private fun bindRepoList(data: List<Repo>?) {
        rv_repo.layoutManager = LinearLayoutManager(this)
        rv_repo.adapter = RepoListAdapter(data ?: emptyList())
    }


}
