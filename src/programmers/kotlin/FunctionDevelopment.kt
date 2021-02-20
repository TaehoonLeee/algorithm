package programmers.kotlin

import java.util.*;
import kotlin.math.*;

class FunctionDevelopment {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue : Queue<Int> = LinkedList<Int>()

        progresses.forEachIndexed { index, it ->
            val spendTime = ceil((100 - it) / speeds[index].toDouble()).toInt()
            queue.offer(spendTime)
        }

        val answer : MutableList<Int> = mutableListOf()
        var cnt = 0
        while( !queue.isEmpty() ) {
            val time = queue.element()
            while( !queue.isEmpty() && time >= queue.peek() ) {
                cnt++
                queue.remove()
            }
            answer.add(cnt)
            cnt = 0
        }

        return answer.toIntArray()
    }
}