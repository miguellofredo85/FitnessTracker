package co.tiagoaguiar.fitnesstracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity // informo ao room que e uma classe de banco de dados para crear a tabela
data class Calc(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // autogera o id a a partir do zero
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "res") val res: Double,
    @ColumnInfo(name = "create_date") val createDate: Date = Date(),
)
