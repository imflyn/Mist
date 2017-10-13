package flyn.mist.ui.presenter

import flyn.mist.model.SongList
import flyn.mist.service.SongListService
import flyn.mist.ui.view.ISongListView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SongListPresenter(iView: ISongListView) : IPresenter<ISongListView>(iView) {


    fun getSongList() {
        disposable.add(
                Observable.create<List<SongList>> { source ->
                    val songLists = SongListService().getSongLists()
                    source.onNext(songLists)
                    source.onComplete()
                }.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ songLists ->
                            iView.onGetSongLists(songLists)
                        })
        )
    }
}