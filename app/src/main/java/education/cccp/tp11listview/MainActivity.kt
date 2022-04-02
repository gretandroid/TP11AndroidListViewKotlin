package education.cccp.tp11listview

import android.R.layout.simple_list_item_1
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import education.cccp.tp11listview.R.id.*
import education.cccp.tp11listview.R.layout.activity_main
import education.cccp.tp11listview.SecondActivity.Companion.OUT_OF_BOUND_INDEX
import education.cccp.tp11listview.SecondActivity.Companion.PERSON_LIST_KEY

class MainActivity(val intentActivityResultLauncher: ActivityResultLauncher<Intent>) : AppCompatActivity() {
    companion object {
        const val EMPTY_FIELD = ""
    }

    val currentIndex: Int by lazy {
        OUT_OF_BOUND_INDEX
    }

    val personFirstNameEditText: EditText by lazy {
        findViewById(editTextPersonFirstNameId)
    }
    val personLastNameEditText: EditText by lazy {
        findViewById(editTextPersonLastNameId)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

    }

    fun onClickCreateButtonEvent(view: View) {}
    fun onClickEditButtonEvent(view: View) {}
    fun onClickDeleteButtonEvent(view: View) {}
    fun onClickShowAllButtonEvent(view: View) {}
}


