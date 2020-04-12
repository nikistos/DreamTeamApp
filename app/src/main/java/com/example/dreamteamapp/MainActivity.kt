package com.example.dreamteamapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.time.LocalDate


class MainActivity : AppCompatActivity() {

    companion object {
        var dreamTeamList =  mutableListOf<Person>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTeamData()
    }

    private fun getTeamData() {
        val nikita = Person()
        nikita.photoId = R.drawable.userpic_nikita
        nikita.specialityName = "Информатика и вычислительная техника"
        nikita.universityName = "ИРИТ РТФ УрФУ"
        nikita.educationGrade = "Бакалавр"
        nikita.educationYear = "2020"
        nikita.language = Language("Английский", LanguageLevel.B1)
        nikita.name = "Никита"
        nikita.surname = "Чернобрисов"
        nikita.vkNick = "croshindigo"
        nikita.hhUrl = "https://ekaterinburg.hh.ru/resume/1d6c9f14ff067ea7360039ed1f4348734d574a"
        nikita.email = "chernobrisov@gmail.com"
        nikita.phoneNumber = "+7(901)9495377"
        nikita.interests = mutableListOf("Android Development", "RPA", "Путешествия", "Кулинария")
        nikita.experience = mutableListOf(
            JobItem("Сбербанк", "Стажер отдела аналитики", "10/2018", "02/2019", R.drawable.sber_logo),
            JobItem("Deloitte", "RPA developer", "04/2019", "02/2020", R.drawable.deloitte_logo)
        )

        val nastya = Person()
        nastya.photoId = R.drawable.userpic_nastya
        nastya.specialityName = "Информатика и вычислительная техника"
        nastya.universityName = "ИРИТ РТФ УрФУ"
        nastya.educationGrade = "Бакалавр"
        nastya.educationYear = "2020"
        nastya.language = Language("Английский", LanguageLevel.B2)
        nastya.name = "Анастасия"
        nastya.surname = "Осипова"
        nastya.vkNick = "id80691056"
        nastya.phoneNumber = "+7(904)5498981"
        nastya.email = "midnight_yeah01@list.ru"
        nastya.interests = mutableListOf("QlikView", "Matlab", "Simulink", "Изучение языков", "Путешествия")

        val pavel = Person()
        pavel.photoId = R.drawable.userpic_pavel
        pavel.specialityName = "Информатика и вычислительная техника"
        pavel.universityName = "ИРИТ РТФ УрФУ"
        pavel.educationGrade = "Бакалавр"
        pavel.educationYear = "2020"
        pavel.language = Language("Английский", LanguageLevel.B2)
        pavel.name = "Павел"
        pavel.surname = "Кисеоларь"
        pavel.vkNick = "mr.goebbels"
        pavel.email = "lisplord@gmail.com"
        pavel.hhUrl = "https://ekaterinburg.hh.ru/resume/bce489ebff05b736b10039ed1f4d4a78487152"
        pavel.phoneNumber = "+7(982)6496621"
        pavel.interests = mutableListOf("Работа с большим объемом информации", "Информационная безопасность", "Организация инфраструктуры")
        pavel.experience = mutableListOf(
            JobItem("SkyDNS", "Big Data Engineer", "07/2017", "08/2017", R.drawable.dns_logo),
            JobItem("Сбербанк", "Ведущий инженер отдела платформы Infrastructure as Code", "09/2019", "настоящее время", R.drawable.sber_logo)
        )

        val sonya = Person()
        sonya.photoId = R.drawable.userpic_sonya
        sonya.specialityName = "Информатика и вычислительная техника"
        sonya.universityName = "ИРИТ РТФ УрФУ"
        sonya.educationGrade = "Бакалавр"
        sonya.educationYear = "2020"
        sonya.language = Language("Английский", LanguageLevel.C1)
        sonya.name = "Софья"
        sonya.surname = "Копалова"
        sonya.vkNick = "offendedfork"
        sonya.phoneNumber = "+7(950)6578450"
        sonya.email = "midnight_yeah01@list.ru"
        sonya.interests = mutableListOf("C#", "Python", "Android")

        dreamTeamList = mutableListOf(nikita, nastya, pavel, sonya)
    }
}
