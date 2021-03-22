package baekjoon.kotlin

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n+1) { BooleanArray(n+1) }
    repeat(readLine()!!.toInt()) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        arr[x][y] = true
    }

    for(i in 1..n) {
        for(j in 1..n) {
            for(k in 1..n) {
                if(arr[j][i] && arr[i][k]) arr[j][k] = true
            }
        }
    }

    for(i in 1..n) {
        var cnt = 0
        for(j in 1..n) {
            if(!arr[i][j] && !arr[j][i]) cnt++
        }
        println(cnt-1)
    }
}