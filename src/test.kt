import java.util.stream.Collectors

fun main(args : Array<String>) {
    val numbers = intArrayOf(3, 30, 34, 5, 9)
    val tmp = mutableListOf<String>()

    numbers.forEach {
        tmp.add(it.toString())
    }

    tmp.sortWith(Comparator { o1, o2 -> (o2 + o1).compareTo(o1 + o2) })

    val ans : String = tmp.stream().collect(Collectors.joining())

    print(ans)
}