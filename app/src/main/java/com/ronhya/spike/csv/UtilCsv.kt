package com.ronhya.spike.csv

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import java.io.File
import java.io.FileOutputStream

class UtilCsv {

    inline fun <reified T> createCsv(data: List<T>, file: File) {
        val csvMapper = CsvMapper()
        val schema = csvMapper.schemaFor(T::class.java)
            .withColumnSeparator(SEPARATOR_SEMICOLON)
            .withHeader()
            .withColumnReordering(true)
        val sequenceWriter = csvMapper.writer(schema).writeValues(file)
        sequenceWriter.writeAll(data)
    }

    fun addBom(file: File): FileOutputStream {
        val bom = byteArrayOf(0xEF.toByte(), 0xBB.toByte(), 0xBF.toByte())
        val fos = FileOutputStream(file)
        fos.write(bom)

        return fos
    }

    companion object {
        const val SEPARATOR_SEMICOLON = ';'
    }
}
