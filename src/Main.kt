/** Задание 20: Авиакомпания 4. Интерфейс
 * Изменим реализацию пассажирских самолетов.
 * Создадим Интерфейс с названием Passenger со свойством, обозначающим вместимость пассажиров.
 * Уберем это свойство у класса Boeing747 и реализуем в нем новый интерфейс.
 */
fun main(args: Array<String>) {
    // объект класса в явном виде задающий количество мест в салоне
    val boeing747 = Boeing747(350)
    print(boeing747.info)

    println()

    // объект другого класса, использующий значение количества мест в самолете по умолчанию
    val superJet = SuperJet()
    print(superJet.info)
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

    private val fuelConsumption: Double
        get() = fuelTankCapacity.toDouble() / maxFlightLength
    open val info: String = "Aircraft info:\n" +
            "Maximum Flight Length = $maxFlightLength km\n" +
            "Fuel Tank Capacity = $fuelTankCapacity liters\n" +
            "Fuel Consumption = $fuelConsumption L/km\n"
}

/**
 * Интерфейс для классов, описывающих самолеты со свойствами:
 * - passengerSeatsNumber: количество мест в салоне самолета (имеет дефолтный геттер)
 * - businessClassSeatsNumber: количество мест в салоне для пассажиров бизнес-класса (абстрактное)
 */
interface Passenger {
    val passengerSeatsNumber: Int
        get() = 250
    val businessClassSeatsNumber: Int
}

/**
 * Класс-наследник от Aircraft для самолетов Boeing 747.
 * Первичный конструктор Boeing747 определен через вызов первичного конструктора Aircraft
 * с фиксированными значениями параметров maxFlightLength и fuelTankCapacity по умолчанию.

 * Реализует интерфейс Passenger, при этом переопределяет свойство passengerSeatsNumber, предоставляя
 * возможность вручную задать параметр при инициализации класса (игнорируя реализацию по умолчанию).
 * Также класс вынужденно переопределяет свойство businessClassSeatsNumber (т.к. оно абстрактное в интерфейсе Passenger)
 *
 * Ещё класс переопределяет свойство info, фактически дополняя свойство родителя своей дополнительной инфой.
 */
class Boeing747(seats: Int) : Aircraft(10299, 300499), Passenger {
    override val passengerSeatsNumber: Int = seats
    override val businessClassSeatsNumber: Int = seats / 10
    override val info: String = super.info + "Number of passengers seats = $passengerSeatsNumber\n" +
            "Number of business-class seats = $businessClassSeatsNumber\n"
}

/**
 * Еще один наследник Aircraft, также реализует интерфейс Passenger.
 * Но при этом не переопределяет его свойство passengerSeatsNumber.
 * При инициализации объекта данного класса значение свойства будет взято из геттера интерфейса Passenger.
 * Вынужденно переопределяет свойство businessClassSeatsNumber путем присваивания константного значения по умолчанию.
 *
 * Ещё класс переопределяет свойство info, фактически дополняя свойство родителя своей дополнительной инфой.
 */
class SuperJet : Aircraft(), Passenger {
    override val businessClassSeatsNumber: Int = 10
    override val info: String = super.info + "Number of passengers seats = $passengerSeatsNumber\n" +
            "Number of business-class seats = $businessClassSeatsNumber\n"
}