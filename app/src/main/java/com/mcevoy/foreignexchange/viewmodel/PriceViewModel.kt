package com.mcevoy.foreignexchange.viewmodel

import android.app.Application
import android.widget.Toast
import com.mcevoy.foreignexchange.model.ForexAPIService
import com.mcevoy.foreignexchange.model.ForexResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class PriceViewModel(application: Application): BaseViewModel(application) {

    private var forexService = ForexAPIService()
    private val disposable = CompositeDisposable()

    private fun fetchFromRemote() {
        disposable.add(
            forexService.getForexRate()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<List<ForexResponse>>() {
                    override fun onSuccess(t: List<ForexResponse>) {
                        Toast.makeText(getApplication(), "Forex retrieved from endpoint", Toast.LENGTH_SHORT).show()
                    }
                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }
}