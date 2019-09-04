/** Задание 23: Data class
 *
 * Создайте data класс для автомобилей. Он должен содержать марку автомобиля, цвет и номер.
 *
 * Выведите информацию об автомобилях в консоль.
 */
fun main(args: Array<String>) {
    // создание объекта дата-класса автомобилей
    val x5 = Car("BMW X5", "arctic white", "23WRE98")

    // создание объектов дата классов мотоциклов:
    // - две точные копии с одинаковыми значениями свойств из первичного конструктора, но с разными значениями свойств вне его
    // - одна копия, отличающаяся только значением одного свойства из первичного конструктора
    val r15 = Bike("Yamaha YZF R15 V3", "sea-foam green", "98QKJ75", 329)
    val r15Clone = Bike("Yamaha YZF R15 V3", "sea-foam green", "98QKJ75", 329)
    val r15Copy = r15.copy(color = "dirty asphalt")

    // консольный вывод переопределенного метода toString() у дата-класса автомобилей
    println(x5)
    // консольный вывод стандартной реализации метода toString() у дата-класса мотоциклов
    println(r15)

    println()

    // демонстрация вычисления функции hashCode() в зависимости от значений свойств
    r15.price = 8000
    r15Clone.price = 7999
    r15Copy.price = 8000

    println(r15.hashCode() == r15Clone.hashCode()) // true, т.к. совпадают все значения свойств из первичного конструктора
    println(r15.hashCode() == r15Copy.hashCode()) // false, т.к. одно значение свойства из первичного конструктора различается

    // по стандартному контракту эквивалентность объектов достигается равенством значений соответствующих свойств в первичном конструкторе
    // (это дает одинаковые значения hashCode(), что в свою очередь влияет и на equals()
    println(r15 == r15Clone) // ... поэтому здесь true
    println(r15 == r15Copy) // ... а здесь - false
}

/**
 * Дата-класс автомобилей.
 * Содержит перегрузку стандартной реализации метода toString() для дата-классов.
 */
data class Car(val model: String,
               val color: String,
               val idNumber: String
) {
    override fun toString(): String {
        return super.toString().substring(0, super.toString().indexOf('@', 0, false)) +
                "'s model \"$model\" with $color color and ID number = $idNumber"
    }
}

/**
 * Дата-класс мотоциклов.
 * Обладает свойством price за пределами первичного конструктора.
 */
data class Bike(val model: String,
                val color: String,
                val idNumber: String,
                val maxSpeed: Int
) {
    var price: Int = 5000
}