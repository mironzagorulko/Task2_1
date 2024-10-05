fun main() {

    println("Введите количество строк:")
    val rows = readLine()?.toIntOrNull() ?: return println("Неверный ввод.")
    println("Введите количество столбцов:")
    val cols = readLine()?.toIntOrNull() ?: return println("Неверный ввод.")


    val array = Array(rows) { IntArray(cols) }


    println("Введите $rows строк(и) по $cols трехзначных чисел (разделяйте пробелами):")
    for (i in 0 until rows) {
        val input = readLine() ?: return println("Ошибка ввода.")
        val numbers = input.split(" ").mapNotNull { it.toIntOrNull() }

        if (numbers.size != cols || numbers.any { it !in 100..999 }) {
            println("Ошибка: Необходимо ввести ровно $cols трехзначных чисел.")
            return
        }

        for (j in 0 until cols) {
            array[i][j] = numbers[j]
        }
    }

    println("Двумерный массив:")
    for (row in array) {
        println(row.joinToString("\t"))
    }

    val uniqueDigits = mutableSetOf<Char>()
    for (row in array) {
        for (number in row) {
            number.toString().forEach { digit ->
                uniqueDigits.add(digit)
            }
        }
    }

    println("В массиве использовано ${uniqueDigits.size} различных цифр")
}
