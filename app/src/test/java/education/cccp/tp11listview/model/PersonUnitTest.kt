package education.cccp.tp11listview.model

import education.cccp.tp11listview.model.Person.Companion.PERSON_ID_DEFAULT_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class PersonUnitTest {
    private val person = Person(
        firstName = "john",
        lastName = "Doe"
    )

    @Test
    fun `test comportement du constructeur`() =
        assertEquals(person.id, PERSON_ID_DEFAULT_VALUE)
}