package com.ronhya.spike.csv

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import kotlin.experimental.and

class RemoveBomFromUtf8File {

    @Throws(IOException::class)
    fun isContainBOM(file: File): Boolean {
        if (!file.exists()) {
            throw IllegalArgumentException("File does not exists!")
        }

        var result = false
        val bom = ByteArray(3)
        FileInputStream(file).use { `is` ->

            // read 3 bytes of a file.
            `is`.read(bom)

            // BOM encoded as ef bb bf
            val content = bytesToStringLowercase(bom)
            println(content)
            if ("efbbbf".equals(content, ignoreCase = true)) {
                result = true
            }
        }
        return result
    }

    private val zzgz =
        charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f')

    fun bytesToStringLowercase(var0: ByteArray): String {
        val var1 = CharArray(var0.size shl 1)
        var var2 = 0
        for (var3 in var0.indices) {
            val var4: Int = (var0[var3] and 255.toByte()).toInt()
            var1[var2++] = zzgz[var4 ushr 4]
            var1[var2++] = zzgz[var4 and 15]
        }
        return String(var1)
    }
}

fun ByteArray.toHex(): String = joinToString(separator = "") { eachByte -> "%02x".format(eachByte) }
