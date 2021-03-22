package baekjoon.kotlin

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val arr = Array(n+1) { BooleanArray(n+1) { false } }
    val reverseArr = Array(n+1) { BooleanArray(n+1) { false } }

    for(i in 0 until m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        arr[x][y] = true
        reverseArr[y][x] = true
    }

    for(k in 1..n) {
        for(i in 1..n) {
            for(j in 1..n) {
                if(arr[i][k] && arr[k][j]) arr[i][j] = true
                if(reverseArr[i][k] && reverseArr[k][j]) reverseArr[i][j] = true
            }
        }
    }

    for(i in 1..n) {
        for(j in 1..n) {
            arr[i][j] = arr[i][j] or reverseArr[i][j]
        }
    }

    var answer = ""
    for(i in 1..n) {
        var cnt = 0
        for(j in 1..n) {
            if(i == j) continue
            if(!arr[i][j]) cnt++
        }
        answer += "$cnt\n"
    }

    bw.write(answer)
    bw.flush()
    bw.close()
}