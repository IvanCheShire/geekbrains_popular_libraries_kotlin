package ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import ru.geekbrains.geekbrains_popular_libraries_kotlin.R
import ru.geekbrains.geekbrains_popular_libraries_kotlin.databinding.FragmentUserBinding
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.api.ApiHolder
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.room.db.Database
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.RetrofitGithubUserReposRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.RetrofitGithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.UserPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.App
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.BackButtonListener
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.adapter.UserReposRVAdapter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.cache.RoomGithubUserReposCache
import ru.geekbrains.geekbrains_popular_libraries_kotlin.ui.network.AndroidNetworkStatus

class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {

    companion object {
        private const val USER_ARG = "user"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(USER_ARG, user)
            }
        }
    }

    val presenter by moxyPresenter {
        UserPresenter(
            App.instance.router,
            this.arguments?.getParcelable<GithubUser>("user") as GithubUser,
            RetrofitGithubUserReposRepo(ApiHolder.api, AndroidNetworkStatus(requireContext()), RoomGithubUserReposCache(
                Database.getInstance()) ),
            AndroidSchedulers.mainThread()
        )
    }
    val adapter by lazy {
        UserReposRVAdapter(presenter.userReposListPresenter)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(context, R.layout.fragment_user, null)
        return view
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun setLoginToToolbar(userLogin: String?) {
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.title = userLogin
    }

    override fun removeLoginFromToolbar() {
        activity?.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)?.title = getResources().getString(R.string.app_name);
    }

    override fun init() {
        rv_repos.layoutManager = LinearLayoutManager(requireContext())
        rv_repos.adapter = adapter
    }

    override fun updateUsersList() {
        adapter.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()

}