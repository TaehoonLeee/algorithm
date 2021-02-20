package programmers.kotlin

import java.util.stream.Collectors

class BiggestNumber {
    fun solution(numbers: IntArray): String {
        val tmp = mutableListOf<String>()

        numbers.forEach {
            tmp.add(it.toString())
        }
        tmp.sortWith(Comparator { o1, o2 -> (o2 + o1).compareTo(o1 + o2) })

        if(tmp[0] == "0") return "0"

        return tmp.stream().collect(Collectors.joining())
    }
}