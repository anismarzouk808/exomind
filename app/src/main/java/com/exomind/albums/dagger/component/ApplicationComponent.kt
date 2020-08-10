package com.exomind.albums.dagger.component

import android.app.Application
import com.amneils.bostagi.dagger.module.*
import com.exomind.albums.AlbumsApplication
import com.exomind.albums.dagger.module.DataBaseModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBindingModule::class,
        FragmentBindingModule::class,
        ViewModelModule::class,
        DataManagerModule::class,
        DataBaseModule::class,
        ApiModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: AlbumsApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}