package com.jt17.bottomnavtest.models

data class Result(
    val title: String,
    val members: List<Member>
) {

    data class Member(
        val image: Int,
        val title: String,
        val description: String,
    )
}
