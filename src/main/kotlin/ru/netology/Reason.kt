package ru.netology

enum class Reason(val type: Int) : Comparable<Reason> {
    SPAM(0),
    CP(1),
    EXTREMISM(2),
    VIOLENCE(3),
    DRUGS(4),
    ADULTS(5),
    ABUSE(6),
    SUICIDE(8),
}