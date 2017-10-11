package flyn.mist.ui.presenter

import flyn.mist.model.Music
import flyn.mist.service.MusicService
import flyn.mist.ui.view.ICurrentMusicView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.IllegalStateException

class CurrentMusicPresenter(iView: ICurrentMusicView) : IPresenter<ICurrentMusicView>(iView) {


    fun getCurrentMusic() {
        disposable.add(
                Observable.create<Music> { source ->
                    val music = MusicService.getInstance().getCurrentMusic()
                    if (music == null) {
                        source.onError(IllegalStateException("No current music "))
                    } else {
                        source.onNext(music)
                        source.onComplete()
                    }
                }.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ music ->
                            iView.onGetCurrentMusicSuccess(music)
                        }, {
                            iView.onGetCurrentMusicFailed()
                        })
        )
    }
}