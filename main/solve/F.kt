fun bfs(
    arr: Array<Array<Int>>,
    n: Int,
    to: Int,
    visited: Array<Boolean>,
    buffer: MutableList<Int>,
    parents: Array<Int>
): Boolean {
    if (buffer.isEmpty())
        return false
    var from = buffer.first()
    buffer.removeAt(0)
    visited[from] = true
    if (from == to)
        return true
    for (i in 0 until n) {
        if (arr[from][i] == 0)
            continue
        if (visited[i])
            continue
        if (buffer.contains(i))
            continue
        parents[i] = from
        buffer.add(i);
    }
    return bfs(arr, n, to, visited, buffer, parents);
}

fun get(from: Int, to: Int, parents: Array<Int>, ans: Array<Int>) {
    if (to == from) {
        return
    }
    ans[0]++;
    get(from, parents[to], parents, ans);
}

fun main() {
    var n = readLine()!!.toInt()
    var arr: Array<Array<Int>> = Array(n) { Array(n) { 0 } }
    var visited = Array(n) { false }
    var parents = Array(n) { 0 }
    for (i in 0 until n - 1) {
        var (u, v) = readLine()!!.split(" ").map { it.toInt() }
        arr[u - 1][v - 1] = 1
        arr[v - 1][u - 1] = 1;
    }
    var min = Int.MAX_VALUE
    for (i in 0 until n) {
        var tempMax = Int.MIN_VALUE
        for (j in 0 until n) {
            for (k in 0 until n)
                visited[k] = false
            var buffer = mutableListOf<Int>()
            buffer.add(i)
            if (i != j && bfs(arr, n, j, visited, buffer, parents)) {
                var ans = Array(1) { 0 }
                get(i, j, parents, ans);
                if (ans[0] > tempMax && ans[0] > 0)
                    tempMax = ans[0]
            }
        }
        if (tempMax <= min)
            min = tempMax
    }
    var m = readLine()!!.toInt()
    var brr: Array<Array<Int>> = Array(m) { Array(m) { 0 } }
    var visited2 = Array(m) { false }
    var parents2 = Array(m) { 0 }
    for (i in 0 until m - 1) {
        var (u, v) = readLine()!!.split(" ").map { it.toInt() }
        brr[u - 1][v - 1] = 1
        brr[v - 1][u - 1] = 1;
    }
    var max = Int.MIN_VALUE
    for (i in 0 until m) {
        for (j in 0 until m) {
            for (k in 0 until m)
                visited2[k] = false
            var buffer = mutableListOf<Int>()
            buffer.add(i)
            if (i != j && bfs(brr, m, j, visited2, buffer, parents2)) {
                var ans = Array(1) { 0 }
                get(i, j, parents2, ans);
                if (ans[0] > max && ans[0] != 0)
                    max = ans[0];
            }
        }
    }
    if (min > max)
        println("L")
    else
        println("D")

}