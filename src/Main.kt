/** Задание 19: Авиакомпания 3. Наследование
 * Создадим наследника класса Aircraft с названием Boeing747 и добавим ему свойство, обозначающее вместимость пассажиров.
 */
fun main(args: Array<String>) {
    val boeing747 = Boeing747(350)
    println("Fuel Consumption of Boeing 747 is ${boeing747.fuelConsumption} L/km\n")
    println(boeing747.info)
}

/**
 * Класс-родитель для самолётов различных моделей.
 * Имеет свойства:
 * - maxFlightLength (максимальная дальность полета)
 * - fuelTankCapacity (предельный обьем топлива)
 * - fuelConsumption (расход топлива)
 */
open class Aircraft(private val maxFlightLength: Int, private val fuelTankCapacity: Int) {
    // вторичный конструктор для создания объектов класса с параметрами по умолчанию
    constructor() : this(9245, 280976)

    val fuelConsumption: Double
        get() = fuelTankCapacity.toDouble() / maxFlightLength
    val info: String = "Aircraft info:\n" +
            "Maximum Flight Length = $maxFlightLength km\n" +
            "Fuel Tank Capacity = $fuelTankCapacity liters\n" +
            "Fuel Consumption = $fuelConsumption L/km"
}

/**
 * Класс-наследник от Aircraft для самолетов Boeing 747.
 * Определяет одно приватное поле passengerSeatsNumber - количество мест для пассажиров в салоне.
 * Первичный конструктор Boeing747 определен через вызов первичного конструктора Aircraft
 * с фиксированными значениями параметров maxFlightLength и fuelTankCapacity по умолчанию.
 */
class Boeing747(private val passengerSeatsNumber: Int) : Aircraft(10299, 300499)