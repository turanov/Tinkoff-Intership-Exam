fun main() {
    var n = readLine()!!.toInt()
    var arr = readLine()!!.split(' ').map { it.toLong() }.sorted().toLongArray()
    var res = 0L
    while (n > 1) {
        var arr2 = Array(n / 2 + n % 2) { 0L }
        var i = 0
        var j = 0
        while (i < n) {
            arr2[j] = (arr[i] + arr[i + 1])
            res += arr2[j] * (500L / 100L)
            i += 2
            j++
        }
        if (n % 2 == 1)
            arr2[j] = arr[i]
        n = n / 2 + n % 2
        i = 0
        while (i < n) {
            arr[i] = arr2[i]
            i++;
        }
        arr.sorted()
    }
    print("%.2f".format(res / 100.0))
}