package parking
class Parking {
    var slots = mutableListOf<String>()
    fun create(number: Int): MutableList<String> = MutableList(number) { "free" }
}

fun main() {
    val parking = Parking()
    var notCreated = true
    while (true) {
        val input = readln()
        when {
            "create" in input -> {
                val number = input.substringAfter(" ").toInt()
                parking.slots = parking.create(number)
                println("Created a parking lot with $number spots.")
                notCreated = false
            }
            "park" in input -> {
                if (notCreated == true) println("Sorry, a parking lot has not been created.") else {
                    var place = 0
                    for (slot in parking.slots) if (slot == "free") {
                        place = parking.slots.indexOf(slot) + 1
                        break
                    }
                    if (place == 0) {
                        println("Sorry, the parking lot is full.")
                        continue
                    }
                    val reg = input.substringAfter(" ")
                    val color = reg.substringAfter(" ")
                    println("$color car parked in spot $place.")
                    parking.slots[place - 1] = reg
                }
            }
            "leave" in input -> {
                if (notCreated == true) println("Sorry, a parking lot has not been created.") else {
                    val place = input.substringAfter(" ")
                    parking.slots[place.toInt() - 1] = "free"
                    println("Spot $place is free.")
                }
            }
            "status" in input -> {
                if (notCreated == true) println("Sorry, a parking lot has not been created.") else {
                    var count = 0
                    for (slot in parking.slots) if (slot != "free") ++count
                    if (count == 0) {
                        println("Parking lot is empty.")
                        continue
                    }
                    for (slot in parking.slots) if (slot != "free") {
                        println("${parking.slots.indexOf(slot) + 1} $slot")
                    }
                }
            }
            "reg_by_color" in input -> {
                if (notCreated == true) println("Sorry, a parking lot has not been created.") else {
                    val color = input.substringAfter(" ")
                    var list = mutableListOf<String>()
                    for (slot in parking.slots) if (slot.substringAfter(" ").uppercase() == color.uppercase()) {
                        list.add(slot.substringBefore(" "))
                    }
                    val message = "No cars with color $color were found."
                    println(if (list.size == 0) message else list.joinToString())
                }
            }
            "spot_by_color" in input -> {
                if (notCreated == true) println("Sorry, a parking lot has not been created.") else {
                    val color = input.substringAfter(" ")
                    var list = mutableListOf<Int>()
                    for (slot in parking.slots) if (slot.substringAfter(" ").uppercase() == color.uppercase()) {
                        list.add(parking.slots.indexOf(slot) + 1)
                    }
                    val message = "No cars with color $color were found."
                    println(if (list.size == 0) message else list.joinToString())
                }
            }
            "spot_by_reg" in input -> {
                if (notCreated == true) println("Sorry, a parking lot has not been created.") else {
                    val reg = input.substringAfter(" ")
                    var place = 0
                    for (slot in parking.slots) if (slot.substringBefore(" ") == reg) {
                        place = parking.slots.indexOf(slot) + 1
                        break
                    }
                    val message = "No cars with registration number $reg were found."
                    println(if (place == 0) message else place)
                }
            }
            "exit" in input -> return
        }
    }
}
