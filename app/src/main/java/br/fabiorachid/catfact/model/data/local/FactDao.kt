package br.fabiorachid.catfact.model.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import io.reactivex.Single

@Dao
interface FactDao {

    @Query("select * from factsTable")
    fun getFavoriteFacts(): Single<List<FactLocalModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addFactToFavorites(addFact: FactLocalModel)

    @Delete
    fun deleteFactFromFavorites(deleteFact: FactLocalModel)
}