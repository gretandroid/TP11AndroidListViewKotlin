package education.cccp.tp11listview

import android.R.layout.simple_list_item_1
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import education.cccp.tp11listview.R.id.personListViewId
import education.cccp.tp11listview.R.layout.activity_second
import education.cccp.tp11listview.repositories.PersonDao.findAll

class SecondActivity : AppCompatActivity() {
    companion object {
        const val CURRENT_PERSON_KEY = "current_person_key"
        const val CURRENT_PERSON_INDEX_KEY = "current_person_index_key"
        const val PERSONS_KEY = "person_list_key"
        const val OUT_OF_BOUND_INDEX: Int = -1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_second)
        findViewById<ListView>(personListViewId).apply {
            adapter = ArrayAdapter(
                this@SecondActivity,
                simple_list_item_1,
                intent.getSerializableExtra(PERSONS_KEY) as MutableList<*>
            )
            onItemClickListener = OnItemClickListener { _: AdapterView<*>?,
                                                        _: View?,
                                                        index: Int,
                                                        _: Long ->
                //retrieve person's clicked
                setResult(
                    RESULT_OK, Intent()
                        .putExtra(CURRENT_PERSON_INDEX_KEY, index)
                        .putExtra(CURRENT_PERSON_KEY, findAll()[index])
                )
                finish()
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickBackButtonEvent(view: View) = finish()
}