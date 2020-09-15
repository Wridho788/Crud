package nakive.kotlin.crud

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nakive.kotlin.crud.DBHelper.DBHelper
import nakive.kotlin.crud.adapter.ListPersonAdapter
import nakive.kotlin.crud.model.Person
import java.util.*

class MainActivity : AppCompatActivity() {
    internal lateinit var db: DBHelper
    internal var lstPersons: List<Person> = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = DBHelper(this)
        refreshData()

        btn_add.setOnClickListener {
            val person = Person(
                Integer.parseInt(edit_id.text.toString()),
                edit_name.text.toString(),
                edit_email.text.toString()
            )
            db.addPerson(person)
            refreshData()
        }
        btn_update.setOnClickListener {
            val person = Person(
                Integer.parseInt(edit_id.text.toString()),
                edit_name.text.toString(),
                edit_email.text.toString()
            )
            db.updatePerson(person)
            refreshData()
        }
        btn_delete.setOnClickListener {
            val person = Person(
                Integer.parseInt(edit_id.text.toString()),
                edit_name.text.toString(),
                edit_email.text.toString()
            )
            db.deletePerson(person)
            refreshData()
        }
    }

    private fun refreshData() {
        lstPersons = db.allPerson
        var adapter =
            ListPersonAdapter(this@MainActivity, lstPersons, edit_id, edit_name, edit_email)
        list_person.adapter = adapter
    }
}