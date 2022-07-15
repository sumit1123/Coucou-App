package com.coucouapp.di

import android.content.*
import androidx.room.*
import com.coucouapp.data.remote.*
import com.coucouapp.database.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.android.qualifiers.*
import dagger.hilt.components.*
import javax.inject.*


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext app: Context) =
        Room.databaseBuilder(app, CoucouDb::class.java, "Coucou")
            .fallbackToDestructiveMigration()
            .build()
    
    @Singleton
    @Provides
    fun provideAuthApi(
        remoteDataSource: RetrofitClient, @ApplicationContext context: Context
    ): RestApis {
        return remoteDataSource.buildApi(RestApis::class.java, context)
    }
    
    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }

}


