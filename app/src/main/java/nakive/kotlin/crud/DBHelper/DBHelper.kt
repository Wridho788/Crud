package nakive.kotlin.crud.DBHelper

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import nakive.kotlin.crud.model.Person

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "sqlitekotlin.db"

        //        table
        private val TABLE_NAME = "Person"
        private val COL_ID = "Id"
        private val COL_NAME = "Name"
        private val COL_EMAIL = "Email"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY: String =
            ("CREATE TABLE $TABLE_NAME($COL_ID INTEGER PRIMARY KEY,$COL_NAME TEXT,$COL_EMAIL TEXT")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    //    crud
    val allPerson: List<Person>
        get() {
            val lstPerson = ArrayList<Person>()
            val selectQuery = "SELECT * FROM $TABLE_NAME"
            val db: SQLiteDatabase = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
        }
}