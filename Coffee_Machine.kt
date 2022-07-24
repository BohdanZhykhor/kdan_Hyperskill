package machine
class coffeeMachine {
    val choosing = "Write action (buy, fill, take, remaining, exit):"
    fun option(): String = readln()
    var awater = "400".toInt()
    var amilk = "540".toInt()
    var abeans = "120".toInt()
    var acups = "9".toInt()
    var amoney = "550".toInt()
    val notEn = "Sorry, not enough "
    val en = "I have enough resources, making you a coffee!"
    fun makingCoffee() {
        val coffee = option()
        when {
                coffee == "1" -> {
                    var count = 0
                    awater -= "250".toInt()
                    if (awater < 0) {
                        awater += "250".toInt()
                        println(notEn + "water!")
                        ++count
                    }
                    if (count == 0) {
                        abeans -= "16".toInt()
                        if (abeans < 0) {
                            abeans += "16".toInt()
                            println(notEn + "beans!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        --acups
                        if (acups < 0) {
                            ++acups
                            println(notEn + "cups!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        println(en)
                        amoney += "4".toInt()
                    }
                }
                    coffee == "2" -> {
                    var count = 0
                    awater -= "350".toInt()
                    if (awater < 0) {
                        awater += "350".toInt()
                        println(notEn + "water!")
                        ++count
                    }
                    if (count == 0) {
                        amilk -= "75".toInt()
                        if (amilk < 0) {
                            amilk += "75".toInt()
                            println(notEn + "milk!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        abeans -= "20".toInt()
                        if (abeans < 0) {
                            abeans += "20".toInt()
                            println(notEn + "beans!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        --acups
                        if (acups < 0) {
                            ++acups
                            println(notEn + "cups!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        println(en)
                        amoney += "7".toInt()
                    }
                }
                coffee == "3" -> {
                    var count = 0
                    awater -= "200".toInt()
                    if (awater < 0) {
                        awater += "200".toInt()
                        println(notEn + "water!")
                        ++count
                    }
                    if (count == 0) {
                        amilk -= "100".toInt()
                        if (amilk < 0) {
                            amilk += "100".toInt()
                            println(notEn + "milk!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        abeans -= "12".toInt()
                        if (abeans < 0) {
                            abeans += "12".toInt()
                            println(notEn + "beans!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        --acups
                        if (acups < 0) {
                            ++acups
                            println(notEn + "cups!")
                            ++count
                        }
                    }
                    if (count == 0) {
                        amoney += "6".toInt()
                        println(en)
                    }
                }
        }
    }
    fun take() {
        println("I gave you $$amoney")
        amoney = 0
    }
    fun fill() {
        println("Write how many ml of water do you want to add: ")
                val fillW = option().toInt()
                awater += fillW
                println("Write how many ml of milk do you want to add: ")
                val fillM = option().toInt()
                amilk += fillM
                println("Write how many grams of coffee beans do you want to add: ")
                val fillB = option().toInt()
                abeans += fillB
                println("Write how many disposable cups of coffee do you want to add: ")
                val fillC = option().toInt()
                acups += fillC
    }
    fun remaining() {
        println("""
                    The coffee machine has:
                    $awater ml of water
                    $amilk ml of milk
                    $abeans g of coffee beans
                    $acups disposable cups
                    $amoney of money
                    """.trimIndent())
    }
}

fun main() {
    val machine = coffeeMachine()
    while (true) {
        println(machine.choosing)
        val option = machine.option()
        when {
            option == "buy" -> machine.makingCoffee()
            option == "fill" -> machine.fill()
            option == "take" -> machine.take()
            option == "remaining" -> machine.remaining()
            option == "exit" -> return
        }
    }
}
