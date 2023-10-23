package co.tiagoaguiar.fitnesstracker.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface CalcDao {
    @Insert
    fun insert(calc: Calc)
    @Delete
    fun delete(calc: Calc)
    @Update
    fun update(calc: Calc)

}