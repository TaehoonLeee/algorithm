package programmers.kotlin

import java.util.*;

class Printer {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue : Queue<Printer> = LinkedList<Printer>()

        repeat(priorities.size) {
            queue.offer(Printer(it, priorities[it]))
        }

        var answer = 0
        while( !queue.isEmpty()) {
            var isBiggest : Boolean = false
            val first = queue.peek().priority
            for(printer in queue) {
                if(first < printer.priority) {
                    isBiggest = true
                }
            }
            if(isBiggest) queue.offer(queue.poll())
            else {
                if(queue.poll().location == location) {
                    answer = priorities.size - queue.size
                }
            }
        }

        return answer
    }

    data class Printer(val location : Int,
                       val priority : Int)
}