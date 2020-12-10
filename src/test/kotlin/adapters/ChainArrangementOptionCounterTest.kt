package adapters

import org.testng.annotations.Test
import kotlin.test.assertEquals

class ChainArrangementOptionCounterTest {

    //1,4,6,7
    //1,4,7
    //1 true optional
    private val simpleInput = """
            1
            4
            6
            7
        """.trimIndent().split("\n").map { it.toInt() }

    //1,2,4,6,7
    //1,4,6,7   //2
    //1,4,7     //2,6
    //1,2,4,7   //6
    //2,4,6,7   //1
    //2,4,7     //1,6
    //1 true optional, 2 partial optionals
    //or 2 true optional, 1 partial
    private val threeOptionalInputOverlap = """
            1
            2
            4
            6
            7
        """.trimIndent().split("\n").map { it.toInt() }


    //4,6,7,10,11,12,15,16,18
    //4,6,7,10,11,12,15,18      //16
    //4,6,7,10,12,15,16,18      //11
    //4,6,7,10,12,15,18         //16, 11
    //4,7,10,11,12,15,18        //16, 6
    //4,7,10,11,12,15,16,18     //6
    //4,7,10,12,15,16,18        //6,11
    //4,7,10,12,15,18           //6,11,16
    //3 optional
    private val threeOptionalInputNoOverlap = """
            4
            6
            7
            10
            11
            12
            15
            16
            18
        """.trimIndent().split("\n").map { it.toInt() }

    // 1,4,5,6,7,10,11,12,15,16,19
    // 1,4,5,6,7,10,12,15,16,19     //11
    // 1,4,5,7,10,11,12,15,16,19    //6
    // 1,4,5,7,10,12,15,16,19       //6,11
    // 1,4,6,7,10,11,12,15,16,19    //5
    // 1,4,6,7,10,12,15,16,19       //5,11
    // 1,4,7,10,11,12,15,16,19      //5,6
    // 1,4,7,10,12,15,16,19         //5,6,11
    //3 optional
    private val example1Input = """
            16
            10
            15
            5
            1
            11
            7
            19
            6
            12
            4
        """.trimIndent().split("\n").map { it.toInt() }


    @Test
    fun optionsToArrangementCount() {
        assertEquals(8.toDouble(), optionsToArrangementCount(3, 0))
        assertEquals(2.toDouble(), optionsToArrangementCount(1, 0))
        assertEquals(6.toDouble(), optionsToArrangementCount(2, 1))
//        assertEquals(6.toDouble(), optionsToArrangementCount(1, 2))
    }

    @Test
    fun countOptionalNumbers() {
//        assertEquals(Pair(1, 0), countOptionalNumbers(simpleInput))
//        assertEquals(Pair(3, 0), countOptionalNumbers(threeOptionalInputNoOverlap))
        assertEquals(Pair(2, 1), countOptionalNumbers(threeOptionalInputOverlap))
        assertEquals(Pair(3, 0), countOptionalNumbers(example1Input))
    }

    @Test
    fun countOptionalNumbersUnOrdered() {
        assertEquals(Pair(1, 0), countOptionalNumbers(simpleInput.reversed()))
    }

    @Test
    fun countChainArrangementOptions() {
        assertEquals(2.toDouble(), countChainArrangementOptions(simpleInput))
        assertEquals(6.toDouble(), countChainArrangementOptions(threeOptionalInputOverlap))
        assertEquals(8.toDouble(), countChainArrangementOptions(threeOptionalInputNoOverlap))
        assertEquals(8.toDouble(), countChainArrangementOptions(example1Input))
    }

    @Test
    fun part2Example2() {
        val input = """
            28
            33
            18
            42
            31
            14
            46
            20
            48
            47
            24
            23
            49
            45
            19
            38
            39
            11
            1
            32
            25
            35
            8
            17
            7
            9
            4
            2
            34
            10
            3
        """.trimIndent().split("\n").map { it.toInt() }
        val voltageMath = countChainArrangementOptions(input)

        assertEquals(19208.toDouble(), voltageMath)
    }

}