package ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubRepository
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.entity.GithubUser
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.IGithubUserReposRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.RetrofitGithubUserReposRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.model.repo.RetrofitGithubUsersRepo
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.navigation.Screens
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.presenter.list.IUserReposListPresenter
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.UserView
import ru.geekbrains.geekbrains_popular_libraries_kotlin.mvp.view.list.RepoItemView
import javax.inject.Inject

class UserPresenter(val user: GithubUser) : MvpPresenter<UserView>() {

    @Inject lateinit var router: Router
    @Inject lateinit var userReposRepo: IGithubUserReposRepo
    @Inject lateinit var uiScheduler: Scheduler

    class UserReposListPresenter : IUserReposListPresenter {
        override var itemClickListener: ((RepoItemView) -> Unit)? = null

        val repos = mutableListOf<GithubRepository>()

        override fun bindView(view: RepoItemView) {
            val repo = repos[view.pos]
            view.setName(repo.name)
            repo.description?.let {view.setDescription(it)}
        }
        override fun getCount() = repos.size
    }

    val userReposListPresenter = UserReposListPresenter()

    var disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        userReposListPresenter.itemClickListener = { view ->
            val repository = userReposListPresenter.repos[view.pos]
            router.navigateTo(Screens.RepositoryScreen(repository))
        }
    }

    fun onResume(){
        viewState.setLoginToToolbar(userLogin = user.login)
    }

    fun loadData() {
        userReposRepo.getUserRepos(user)
            .retry(3)
            .observeOn(uiScheduler)
            .subscribe(
                        {
                            userReposListPresenter.repos.clear()
                            userReposListPresenter.repos.addAll(it)
                            viewState.updateUsersList()
                        },
                        { println("onError: ${it.message}") })


    }

    fun backPressed(): Boolean {
        viewState.removeLoginFromToolbar()
        router.exit()
        return true
    }
    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }
}
