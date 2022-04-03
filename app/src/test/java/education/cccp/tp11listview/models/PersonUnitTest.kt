package education.cccp.tp11listview.models

import org.junit.Assert
import org.junit.Test

class PersonUnitTest {
    private val person = Person(
        firstName = "john",
        lastName = "Doe"
    )
    @Test
    fun `test comportement du constructeur`() {
        Assert.assertEquals(person.id, Person.PERSON_ID_DEFAULT_VALUE)
    }
}