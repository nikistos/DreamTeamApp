package com.example.dreamteamapp

import android.provider.ContactsContract
import java.time.LocalDate
import java.util.*

class Person {
    var photoId: Int = 0
    var email: String = ""
    var name: String = ""
    var surname: String = ""
    var universityName: String = ""
    var specialityName: String = ""
    var educationYear: String = ""
    var educationGrade: String = ""
    var interests: MutableList<String> = mutableListOf()
    var language: Language = Language()
    var experience: MutableList<JobItem> = mutableListOf()
    var vkNick: String = ""
    var phoneNumber: String = ""
    var hhUrl: String = ""

    fun getInterestText(): String {
        return interests.joinToString(separator = "\n")
    }

    fun getFullName(): String {
        return "$name $surname"
    }

    fun getVkUrl(): String {
        return "http://www.vk.com/$vkNick"
    }

    fun getMailUrl(): String {
        return "mailto:$email"
    }

    fun getPhoneUri(): String {
        return "tel:$phoneNumber"
    }

    fun getHHUrl(): String {
        return hhUrl
    }
}

class JobItem() {

    constructor(name: String, pos: String, start: String, end: String, logo: Int) : this() {
        companyName = name
        position = pos
        startTime = start
        endTime = end
        logoId = logo
    }

    var companyName: String = ""
    var position: String = ""
    var startTime: String = ""
    var endTime: String = ""
    var logoId: Int = 0

    fun getPeriodString(): String {
        return if (startTime.isNotEmpty()) "$startTime - $endTime"
        else ""
    }

}

class Language() {
    var name: String = ""
    var levelCode: LanguageLevel = LanguageLevel.A1

    constructor(nameOfLang: String, level: LanguageLevel) : this() {
        name = nameOfLang
        levelCode = level
    }

    fun getDecoding(): String {
        return when (levelCode) {
            LanguageLevel.A1 -> "Elementary"
            LanguageLevel.A2 -> "Pre-Intermediate"
            LanguageLevel.B1 -> "Intermediate"
            LanguageLevel.B2 -> "Upper-Intermediate"
            LanguageLevel.C1 -> "Advanced"
            LanguageLevel.C2 -> "Proficiency"
        }
    }
}

enum class LanguageLevel(i: Int) {
    A1(0), A2(1), B1(2), B2(3), C1(4), C2(5)
}