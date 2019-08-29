/** Задание 17: Авиакомпания 1
 *
 * Поможем авиакомпании в создании программы для учета авиапарка.
 *
 * Создайте класс Aircraft и реализуйте в нем свойства, содержащие следующее:
 * - максимальная дальность полета
 * - вместимость бака
 * - расход топлива на 100 км.
 *
 * Установите значения по своему усмотрению.
 *
 * Переопределите геттер свойства содержащего расход топлива,
 * чтобы он самостоятельно рассчитывался из свойств дальности полета и вместимости бака.
 */
fun main(args: Array<String>) {
    val a380 = Aircraft()
    println("Fuel Consumption of Airbus A380 is ${a380.fuelConsumption} L/km\n")
    println(a380.info)
}

class Aircraft {
    private var maxFlightLength: Int = 15200
    private var fuelTankCapacity: Int = 315292
    val fuelConsumption: Double
        get() = fuelTankCapacity.toDouble() / maxFlightLength
    val info: String = "Aircraft info:\n" +
            "Maximum Flight Length = $maxFlightLength km\n" +
            "Fuel Tank Capacity = $fuelTankCapacity liters\n" +
            "Fuel Consumption = $fuelConsumption L/km"
}