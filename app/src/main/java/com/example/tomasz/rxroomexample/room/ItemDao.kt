package com.example.tomasz.rxroomexample.room

import android.arch.persistence.room.*
import com.example.tomasz.rxroomexample.ApplicationScope
import io.reactivex.Flowable

@ApplicationScope
@Dao
interface ItemDao
{
    @Query("SELECT * FROM items")
    fun getAllItems(): Flowable<List<Item>>

    @Query("SELECT * FROM items WHERE place = :arg0")
    fun getItemsAt(place: String): Flowable<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}
