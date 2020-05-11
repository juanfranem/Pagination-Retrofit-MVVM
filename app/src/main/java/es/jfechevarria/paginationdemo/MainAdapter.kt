package es.jfechevarria.paginationdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import es.jfechevarria.domain.User
import es.jfechevarria.paginationdemo.databinding.ItemUserBinding
import es.jfechevarria.paginationdemo.pagination.UserDiffUtil


class MainAdapter: PagedListAdapter<User, MainAdapter.Holder>(UserDiffUtil()) {

    inner class Holder(val view: ItemUserBinding): RecyclerView.ViewHolder(view.root) {

        fun bind(any: User?) {
            any?.let { user ->
                view.name.text = "${user.first_name} ${user.last_name}"
                view.email.text = user.email
                view.image.load(user.avatar)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return currentList?.size ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(holder.adapterPosition))
    }
}