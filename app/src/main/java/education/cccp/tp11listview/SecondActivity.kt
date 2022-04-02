package education.cccp.tp11listview

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import education.cccp.tp11listview.R.layout.activity_second

class SecondActivity : AppCompatActivity() {
    companion object {
        const val CURRENT_PERSON_KEY = "current_person_key"
        const val CURRENT_PERSON_INDEX_KEY = "current_person_index_key"
        const val PERSON_LIST_KEY = "person_list_key"
        const val OUT_OF_BOUND_INDEX: Int = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_second)
        findViewById<ListView>(R.id.personListViewId).apply {
            adapter = ArrayAdapter(
                this@SecondActivity,
                android.R.layout.simple_list_item_1,
                intent.getSerializableExtra(PERSON_LIST_KEY) as List<*>
            )
        }
    }

    fun onClickBackButtonEvent(view: View) = finish()
}