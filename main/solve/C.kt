fun main() {
    var arr = Array(10) { 0 }
    var str = readLine()!!

    if (str.length > 3)
        str = str.substring(str.length - 3, str.length);
    arr[0] = 1
    if (str.length == 2) {
        if (str[0] == '*' || str[1] != '*') {
            arr[1] = if ((str[1] - 48).toInt() % 2 == 0) 1 else 0
            arr[4] = if (str[1] == '0' || str[1] == '5') 1 else 0
            arr[9] = if (str[1] == '0') 1 else 0
            if (str[0] != '*' && str[1] != '*')
                arr[3] = getFour(str)
        }
    } else {
        if (str[2] != '*') {
            arr[1] = if ((str[2] - 48).toInt() % 2 == 0) 1 else 0
            arr[4] = if (str[2] == '0' || str[2] == '5') 1 else 0
            arr[9] = if (str[2] == '0') 1 else 0
            if (str[0] == '*')
                arr[3] = getFour(str);
            else if (str[0] != '*' && str[1] != '*')
                arr[7] = getEight(str);
        }
    }
    for(i in arr.indices)
        if (arr[i] == 1)
            print("${i + 1} ")

}

fun getEight(str: String): Int {
    var n = (str[str.length - 3] - 48).toInt()
    n *= 10;
    n += (str[str.length - 2] - 48).toInt()
    n *= 10;
    n += (str[str.length - 1] - 48).toInt()
    return if (n % 8 == 0) 1 else 0
}

fun getFour(str: String): Int {
    var n = (str[str.length - 2] - 48).toInt()
    n *= 10;
    n += (str[str.length - 1] - 48).toInt()
    return if (n % 4 == 0) 1 else 0
}
