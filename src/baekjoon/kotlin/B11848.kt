package baekjoon.kotlin

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (n, m, s) = br.readLine().split(" ").map { it.toInt() }

    var ans = 0

    for(i in 1..n) {
        val (a,b) = br.readLine().split(" ").map { it.toInt() }

        ans = max(ans, a*m+b*s)
    }

    bw.write("$ans\n")
    bw.flush()
    bw.close()
}