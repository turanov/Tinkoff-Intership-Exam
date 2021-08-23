fun main() {
    var a = readLine()!!.toInt()
    var b = readLine()!!.toInt()
    var n = readLine()!!.toInt()
    if (n <= a + b)
        print(n);
    else
        print(a + b)
}