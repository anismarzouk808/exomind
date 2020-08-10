package com.exomind.albums

import com.transdev.mobime.dagger.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AlbumsApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<DaggerApplication> {
        val appComponent = DaggerApplicationComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

}