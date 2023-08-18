package com.github.joelarmah.customerkeeper.ui.di

import com.github.joelarmah.customerkeeper.ui.core.theme.ThemeUtils
import com.github.joelarmah.customerkeeper.ui.core.theme.ThemeUtilsImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Singleton
//    @Provides
//    fun provideGlideInstance(
//        @ApplicationContext context: Context
//    ) = Glide.with(context).setDefaultRequestOptions(
//        RequestOptions()
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
//            .diskCacheStrategy(DiskCacheStrategy.DATA)
//    )

    @Singleton
    @Provides
    fun bindThemeUtils(themeUtilsImp: ThemeUtilsImpl): ThemeUtils = themeUtilsImp

}