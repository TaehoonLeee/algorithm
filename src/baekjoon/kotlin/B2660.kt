package baekjoon.kotlin

import kotlin.math.max
import kotlin.math.min

const val INF = 123456789

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val arr = Array(n+1) { Array(n+1) { INF } }

    while(true) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        if( (x == -1) and (y == -1) ) break

        arr[x][y] = 1
        arr[y][x] = 1
    }

    for(k in 1..n) {
        for(i in 1..n) {
            for(j in 1..n) {
                if( arr[i][j] > arr[i][k] + arr[k][j]) arr[i][j] = arr[i][k] + arr[k][j]
            }
        }
    }

    var ans = INF
    val scoreArr = Array(n+1) { 0 }
    for(i in 1..n) {
        var score = 0
        for(j in 1..n) {
            if( arr[i][j] != INF) score = max(score, arr[i][j])
        }

        scoreArr[i] = score
        ans = min(ans, score)
    }

    var first = ans.toString()
    var second = ""
    var cnt = 0
    for(i in 1..n) {
        if( scoreArr[i] == ans ) {
            cnt++
            second += "$i "
        }
    }
    first += " $cnt"

    bw.write("$first\n")
    bw.write("$second\n")
    bw.flush()
    bw.close()
}