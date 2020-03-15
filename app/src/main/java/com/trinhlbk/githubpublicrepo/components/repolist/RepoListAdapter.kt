package com.trinhlbk.githubpublicrepo.components.repolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trinhlbk.core.entities.Repo
import com.trinhlbk.githubpublicrepo.R

class RepoListAdapter(
    private val repoList: List<Repo>
) : RecyclerView.Adapter<RepoListAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repo, parent, false)
        return RepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.bind(repoList[position])
    }

    class RepoViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        private val tvName by lazy { itemView.findViewById<TextView>(R.id.tv_name) }
        private val tvDescription by lazy { itemView.findViewById<TextView>(R.id.tv_description) }
        private val tvOwner by lazy { itemView.findViewById<TextView>(R.id.tv_owner) }
        private val tvLanguage by lazy { itemView.findViewById<TextView>(R.id.tv_language) }

        fun bind(repo: Repo) {
            tvName.text = repo.name
            tvDescription.text = repo.description
            tvOwner.text = repo.author
            tvLanguage.text = repo.language
        }

    }

}