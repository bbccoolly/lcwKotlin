package com.lcw.kt.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/24
 */
@Dao
interface PhotoImageDao {

    @Query("SELECT * FROM photos")
    fun getAll(): LiveData<List<PhotoImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: PhotoImageEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(plants: List<PhotoImageEntity>)

    @Delete
    suspend fun delete(entity: PhotoImageEntity)
}