package co.tiagoaguiar.fitnesstracker.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Calc::class], version = 1) // se p banco de dados muda a versao tambem
abstract class AppDatabase : RoomDatabase() {
    abstract fun calcDao(): CalcDao
}