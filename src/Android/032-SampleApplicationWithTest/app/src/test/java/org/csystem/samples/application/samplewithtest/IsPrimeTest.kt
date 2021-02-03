package org.csystem.samples.application.samplewithtest

import org.csystem.util.NumberUtil
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.BufferedReader
import java.nio.file.Files
import java.nio.file.Paths

@RunWith(Parameterized::class)
class IsPrimeTest(private val mDataInfo: DataInfo) {
    class DataInfo(val a: Int, val result: Boolean)

    companion object {
        @JvmStatic
        private fun fillDataInfo(br: BufferedReader, data: MutableCollection<DataInfo>)
        {
            while (true) {
                val line = br.readLine() ?: break
                val dataInfoStr = line.split(' ')
                data.add(DataInfo(dataInfoStr[0].toInt(), dataInfoStr[1].toBoolean()))
            }
        }

        @Parameterized.Parameters
        @JvmStatic
        fun provideData(): MutableCollection<DataInfo> {
            val data = ArrayList<DataInfo>()

            Files.newBufferedReader(Paths.get("setup-prime.txt")).use {
                fillDataInfo(it, data)
            }

            return data
        }
    }

    @Test
    fun testIsPrime()
    {
        assertEquals(mDataInfo.result, NumberUtil.isPrime(mDataInfo.a))
    }
}