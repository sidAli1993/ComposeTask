package com.sid_ali_tech.composetask.common

object Constants {
    val jsonData = mapOf(
        "problems" to listOf(
            mapOf(
                "Diabetes" to listOf(
                    mapOf(
                        "medications" to listOf(
                            mapOf(
                                "medicationsClasses" to listOf(
                                    mapOf(
                                        "className" to listOf(
                                            mapOf(
                                                "associatedDrug" to listOf(
                                                    mapOf(
                                                        "name" to "aspirin",
                                                        "dose" to "",
                                                        "strength" to "500 mg"
                                                    )
                                                )
                                            )
                                        ),
                                        "className2" to listOf(
                                            mapOf(
                                                "associatedDrug" to listOf(
                                                    mapOf(
                                                        "name" to "aspirin",
                                                        "dose" to "",
                                                        "strength" to "500 mg"
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                            )
                        ),
                        "labs" to listOf(
                            mapOf(
                                "missing_field" to "missing_value"
                            )
                        )
                    )
                )
            ),
            mapOf(
                "Asthma" to listOf(mapOf())
            )
        )
    )
    val jsonString = """
{
    "problems": [
        {
            "name": "Diabetes",
            "medications": [
                {
                    "name": "aspirin",
                    "dose": "abc dose",
                    "strength": "500 mg"
                },
                {
                    "name": "somethingElse",
                    "dose": "def dose",
                    "strength": "500 mg"
                }
            ]
        },
        {
            "name": "Asthma",
            "medications": [
                {
                    "name": "aspirin",
                    "dose": "ghi dose",
                    "strength": "500 mg"
                },
                {
                    "name": "somethingElse",
                    "dose": "lmn dose",
                    "strength": "500 mg"
                }
            ]
        }
    ]
}
"""

    const val TAG="composeTask"
}