/** Задание 18: Авиакомпания 2. Конструктор
 * Усовершенствуйте программу для авиакомпании.
 * Пусть свойства: максимальная дальность полета и вместимость бака определяются через конструктор.
 * Для этих свойств значения определять не надо.
 */
fun main(args: Array<String>) {
    // создаем объект класса через первичный конструктор
    val a380 = Aircraft(15200, 315292)
    println("Fuel Consumption of Airbus A380 is ${a380.fuelConsumption} L/km\n")
    println(a380.info)

    // создаем еще один объект класса через вторичный конструктор
    val a330 = Aircraft()
    println("Fuel Consumption of Airbus A330 is ${a330.fuelConsumption} L/km\n")
    println(a330.info)
}

class Aircraft(private val maxFlightLength: Int, private val fuelTankCapacity: Int) {
    // вторичный конструктор для создания объектов класса с параметрами по умолчанию
    constructor(): this(9245, 280976)

    val fuelConsumption: Double
        get() = fuelTankCapacity.toDouble() / maxFlightLength
    val info: String = "Aircraft info:\n" +
            "Maximum Flight Length = $maxFlightLength km\n" +
            "Fuel Tank Capacity = $fuelTankCapacity liters\n" +
            "Fuel Consumption = $fuelConsumption L/km"
}