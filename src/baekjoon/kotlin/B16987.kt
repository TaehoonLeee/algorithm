package baekjoon.kotlin

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

private var ans = 0

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val n = br.readLine().toInt()
    val durable = IntArray(n) { 0 }
    val weight = IntArray(n) { 0 }

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        durable[i] = st.nextToken().toInt()
        weight[i] = st.nextToken().toInt()
    }

    dfs(0, n, durable, weight)

    bw.write("$ans\n")
    bw.flush()
    bw.close()
}

fun dfs(pos: Int, n : Int, durable : IntArray, weight : IntArray) {
    if( pos == n ) {
        var cnt = 0
        for(i in 0 until n) {
            if(durable[i] <= 0) cnt++
        }
        if( ans < cnt ) ans = cnt

        return
    }

    if( durable[pos] <= 0) dfs(pos+1, n, durable, weight)
    else {
        var isCracked = false
        for(i in 0 until n) {
            if( (i == pos) or (durable[i] <= 0) ) continue
            isCracked = true
            durable[i] -= weight[pos]
            durable[pos] -= weight[i]
            dfs(pos+1, n, durable, weight)
            durable[i] += weight[pos]
            durable[pos] += weight[i]
        }
        if(!isCracked) dfs(pos+1, n, durable, weight)
    }
}

//private lateinit var durability: Array<Int>
//private lateinit var weight: Array<Int>
//private var answer = 0
//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//    val n = br.readLine().toInt()
//    durability = Array(n) { 0 }
//    weight = Array(n) { 0 }
//    for (i in 0 until n) {
//        val (s, w) = br.readLine().split(" ").map { it.toInt() }
//        durability[i] = s
//        weight[i] = w
//    }
//    dfs(0,n)
//    println(answer)
//}
//
//private fun dfs(hand: Int, n: Int) {
//    if (hand == n) {
//        var cnt = 0
//        for (i in 0 until n) {
//            if (durability[i] <=0) cnt +=1
//        }
//        if (answer < cnt) answer = cnt
//        return
//    }
//    if (durability[hand] <= 0) dfs(hand + 1, n)
//    else {
//        var check = false
//        for (i in 0 until n) {
//            if (i == hand || durability[i] <= 0) continue
//            check = true
//            durability[i] -= weight[hand]
//            durability[hand] -= weight[i]
//            dfs(hand + 1, n)
//            durability[i] += weight[hand]
//            durability[hand] += weight[i]
//        }
//        if (!check) dfs(hand + 1, n)
//    }
//}