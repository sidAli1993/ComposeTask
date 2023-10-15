package com.sid_ali_tech.composetask

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import com.sid_ali_tech.composetask.data.models.MyData
import com.sid_ali_tech.composetask.data.models.Medication
import com.sid_ali_tech.composetask.data.models.DTOHealthRecord
import com.sid_ali_tech.composetask.data.models.Problem


class MyTests {
    @Test
    fun testEmptyMyData() {
        val myData = MyData(emptyList())

        assertEquals(0, myData.problems.size)
    }

    @Test
    fun testAddProblemToMyData() {
        val myData = MyData(emptyList())

        val problem = Problem(
            "Headache",
            listOf(
                Medication("Aspirin", "1 tablet", "500 mg"),
                Medication("Ibuprofen", "2 tablets", "200 mg")
            )
        )

        val updatedMyData = myData.copy(problems = listOf(problem))

        assertEquals(1, updatedMyData.problems.size)
        assertEquals("Headache", updatedMyData.problems[0].name)
    }

    @Test
    fun testGetMedicationsForProblem() {
        val myData = MyData(
            listOf(
                Problem(
                    "Diabetes",
                    listOf(
                        Medication("Metformin", "1 tablet", "1000 mg"),
                        Medication("Insulin", "Varies", "N/A")
                    )
                ),
                Problem(
                    "Asthma",
                    listOf(
                        Medication("Albuterol", "2 puffs", "100 mcg"),
                        Medication("Flovent", "2 puffs", "110 mcg")
                    )
                )
            )
        )

        val medicationsForAsthma = myData.problems.find { it.name == "Asthma" }?.medications

        assertNotNull(medicationsForAsthma)
        assertEquals(2, medicationsForAsthma?.size)
        assertEquals("Albuterol", medicationsForAsthma?.get(0)?.name)
        assertEquals("Flovent", medicationsForAsthma?.get(1)?.name)
    }
}