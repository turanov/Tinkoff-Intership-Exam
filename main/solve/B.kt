fun main() {
    val n = readLine()!!.toInt()
    val (w, h) = readLine()!!.split(" ").map { it.toInt() }
    var p = Int.MAX_VALUE
    for (i in 0 until n){
        val (a,b,c) = readLine()!!.split(" ").map { it.toInt() }
        if ((w <= a && h <= b && p >= c) || (h <= a && w <= b && p >= c))
            p = c
    }
    print(p)
}