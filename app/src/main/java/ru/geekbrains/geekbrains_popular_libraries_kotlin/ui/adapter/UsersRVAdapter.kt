package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import ru.geekbrains.geekbrains_popular_libraries_kotlin.R
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.ItemUserBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.image.IImageLoader
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list.IUserListPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list.IUsersListPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.UserItemView
import javax.inject.Inject

class UsersRVAdapter(val presenter: IUsersListPresenter) : RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    @Inject
    lateinit var imageLoader: IImageLoader<ImageView>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)).apply {
            containerView.setOnClickListener {
                presenter.itemClickListener?.invoke(this)
            }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener { presenter.itemClickListener?.invoke(holder) }
        presenter.bindView(holder)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), UserItemView,
        LayoutContainer {
        override var pos = -1

        override fun setLogin(text: String) = with(containerView){
            tv_login.text = text
        }

        override fun loadImage(url: String) {
            imageLoader.loadInto(url, iv_image)
        }
    }
    }
}