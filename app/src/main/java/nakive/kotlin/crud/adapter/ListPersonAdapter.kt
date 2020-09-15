package nakive.kotlin.crud.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.row_layout.view.*
import nakive.kotlin.crud.R
import nakive.kotlin.crud.model.Person

class ListPersonAdapter(
    internal var activity: Activity,
    internal var lstPerson: List<Person>,
    internal var edit_id: EditText,
    internal var edit_name: EditText,
    internal var edit_email: EditText,
) : BaseAdapter() {
    internal var inflater: LayoutInflater

    init {
        inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return lstPerson.size
    }

    override fun getItem(position: Int): Any {
        return lstPerson[position]
    }

    override fun getItemId(position: Int): Long {
        return lstPerson[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView: View

        rowView = inflater.inflate(R.layout.row_layout, null)
        rowView.txt_row_id.text = lstPerson[position].id.toString()
        rowView.txt_name.text = lstPerson[position].name.toString()
        rowView.txt_email.text = lstPerson[position].email.toString()

//        event
        rowView.setOnClickListener {
            edit_id.setText(rowView.txt_row_id.text.toString())
            edit_name.setText(rowView.txt_name.text.toString())
            edit_email.setText(rowView.txt_email.text.toString())
        }; return rowView
    }
}