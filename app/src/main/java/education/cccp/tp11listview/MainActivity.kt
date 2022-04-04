package education.cccp.tp11listview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast.*
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import education.cccp.tp11listview.R.id.editTextPersonFirstNameId
import education.cccp.tp11listview.R.id.editTextPersonLastNameId
import education.cccp.tp11listview.R.layout.activity_main
import education.cccp.tp11listview.SecondActivity.Companion.CURRENT_PERSON_INDEX_KEY
import education.cccp.tp11listview.SecondActivity.Companion.CURRENT_PERSON_KEY
import education.cccp.tp11listview.SecondActivity.Companion.OUT_OF_BOUND_INDEX
import education.cccp.tp11listview.SecondActivity.Companion.PERSONS_KEY
import education.cccp.tp11listview.dao.PersonDao.delete
import education.cccp.tp11listview.dao.PersonDao.findAll
import education.cccp.tp11listview.dao.PersonDao.save
import education.cccp.tp11listview.model.Person
import java.io.Serializable
import java.util.Objects.requireNonNull

class MainActivity : AppCompatActivity() {

    companion object {
        const val EMPTY_FIELD = ""
    }

    private lateinit var intentActivityResultLauncher: ActivityResultLauncher<Intent>
    private var currentIndex = OUT_OF_BOUND_INDEX

    private val personFirstNameEditText: EditText by lazy {
        findViewById(editTextPersonFirstNameId)
    }
    private val personLastNameEditText: EditText by lazy {
        findViewById(editTextPersonLastNameId)
    }

    private fun setEditTextPersonFields(
        firstName: String,
        lastName: String
    ) {
        personFirstNameEditText.setText(firstName)
        personLastNameEditText.setText(lastName)
    }

    private fun gotoSecondActivity() {
        intentActivityResultLauncher.launch(
            Intent(
                this,
                SecondActivity::class.java
            ).putExtra(
                PERSONS_KEY,
                findAll() as Serializable
            )
        )
    }

    private fun makeTextPersonsIsEmpty(): Unit = makeText(
        this,
        "person list is empty",
        LENGTH_SHORT
    ).show()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        intentActivityResultLauncher = registerForActivityResult(
            StartActivityForResult(),
        ) { activityResult: ActivityResult ->
            activityResult.data?.apply {
                if (activityResult.resultCode == RESULT_OK) {
                    (requireNonNull(this)
                        .getSerializableExtra(CURRENT_PERSON_KEY) as Person)
                        .apply {
                            setEditTextPersonFields(
                                firstName,
                                lastName
                            )
                        }
                    currentIndex = getIntExtra(
                        CURRENT_PERSON_INDEX_KEY,
                        OUT_OF_BOUND_INDEX
                    )
                }
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickCreateButtonEvent(view: View) =
        save(
            Person(
                firstName = personFirstNameEditText.text.toString(),
                lastName = personLastNameEditText.text.toString()
            )
        ).also {
            currentIndex = findAll().size - 1
            makeText(
                this,
                "person successfully added",
                LENGTH_LONG
            ).show()
            setEditTextPersonFields(
                EMPTY_FIELD,
                EMPTY_FIELD
            )
        }

    @Suppress("UNUSED_PARAMETER")
    fun onClickEditButtonEvent(view: View) =
        if (currentIndex != OUT_OF_BOUND_INDEX) {
            save(
                currentIndex,
                findAll()[currentIndex].copy(
                    firstName = personFirstNameEditText.text.toString(),
                    lastName = personLastNameEditText.text.toString()
                )
            )
            makeText(
                this,
                "person successfully modified",
                LENGTH_SHORT
            ).show()
            gotoSecondActivity()
        } else makeTextPersonsIsEmpty()

    @Suppress("UNUSED_PARAMETER")
    fun onClickDeleteButtonEvent(view: View) =
        if (currentIndex != OUT_OF_BOUND_INDEX) {
            delete(currentIndex)
            setEditTextPersonFields(EMPTY_FIELD, EMPTY_FIELD)
            makeText(
                this,
                "person successfully deleted",
                LENGTH_SHORT
            ).show()
            gotoSecondActivity()
        } else makeTextPersonsIsEmpty()

    @Suppress("UNUSED_PARAMETER")
    fun onClickShowAllButtonEvent(view: View) =
        if (currentIndex != OUT_OF_BOUND_INDEX)
            gotoSecondActivity()
        else makeTextPersonsIsEmpty()
}