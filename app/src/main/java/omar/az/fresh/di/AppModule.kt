package omar.az.fresh.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import omar.az.fresh.db.ProductDatabase
import omar.az.fresh.utils.Utils.DATABASE_NAME
import javax.inject.Singleton

@Module
/**
 * ApplicationComponent is deprecated v2.30 and removed v2.31
 * Use SingletonComponent instead
 * check https://dagger.dev/hilt/components.html for more details
 * @author OmarAZ :)
 */
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext appContext: Context
    ) = Room.databaseBuilder(appContext, ProductDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDao(db : ProductDatabase) = db.getProductDao()
}