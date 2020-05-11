package es.jfechevarria.paginationdemo.pagination

import androidx.recyclerview.widget.DiffUtil
import es.jfechevarria.domain.User

class UserDiffUtil : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.first_name == newItem.first_name
                && oldItem.id == newItem.id
                && oldItem.email == newItem.email
                && oldItem.last_name == newItem.last_name
    }

}