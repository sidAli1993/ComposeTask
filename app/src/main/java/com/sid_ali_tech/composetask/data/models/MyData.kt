package com.sid_ali_tech.composetask.data.models

data class Problem(
    val name: String,
    val medications: List<Medication>
)

data class Medication(
    val name: String,
    val dose: String,
    val strength: String
)

data class MyData(
    val problems: List<Problem>
)

