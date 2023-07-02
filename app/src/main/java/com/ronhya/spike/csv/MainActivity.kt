package com.ronhya.spike.csv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ronhya.spike.csv.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val utilCsv by lazy { UtilCsv() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGenerateCsv.setOnClickListener { generateCsv() }
    }

    private fun generateCsv() {
        utilCsv.createCsv(generateCountryDummy(), generateFile())
    }

    private fun generateFile(): File {
        val pathFolder = "${filesDir.absolutePath}${File.separator}$FOLDER_NAME"
        val folder = File(pathFolder)
        if (!folder.exists()) {
            folder.mkdirs()
        }
        val document = File(folder, FILE_NAME)
        if (document.exists()) {
            document.delete()
        }

        return document
    }

    private fun generateCountryDummy(): List<CountryModel> {
        return listOf(
            CountryModel(country = "Perú", capital = "Lima", currency = "PEN"),
            CountryModel(country = "Colombia", capital = "Bogotá", currency = "COP"),
            CountryModel(country = "Ecuador", capital = "Quito", currency = "ECS"),
            CountryModel(country = "China", capital = "道", currency = "CNY")
        )
    }

    companion object {
        const val FOLDER_NAME = "csv"
        const val FILE_NAME = "country.csv"
    }
}
