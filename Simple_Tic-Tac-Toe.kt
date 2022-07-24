fun main() {
    var str = "         ".toCharArray()
    var s1 = str  
    var grid = """
    ---------
    | ${s1[0]} ${s1[1]} ${s1[2]} |
    | ${s1[3]} ${s1[4]} ${s1[5]} |
    | ${s1[6]} ${s1[7]} ${s1[8]} |
    ---------
    """.trimIndent()
    println(grid)
    var winX = 0
    var winO = 0
    var countX = 0
    var countO = 0
    var countF = 9
    val occ = "This cell is occupied! Choose another one!"
    while (countF != 0) {
        println("Enter the coordinates: ")
        val (s2: String, s3: String) = readln().split(" ")
        if (s2.toInt() in 1..3 && s3.toInt() in 1..3) {
            val list = mutableListOf<Int>()
            list.clear()
            list.add(0, s3.toInt())
            list.add(0, s2.toInt())
            
                when {
                    list[0] == 1 && list[1] == 1 -> {if (s1[0] == 'O' || s1[0] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[0] = 'X' else s1[0] = 'O'
                        }}
                    list[0] == 1 && list[1] == 2 -> {if (s1[1] == 'O' || s1[1] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[1] = 'X' else s1[1] = 'O'
                        }}
                    list[0] == 1 && list[1] == 3 -> {if (s1[2] == 'O' || s1[2] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[2] = 'X' else s1[2] = 'O'
                        }}
                    list[0] == 2 && list[1] == 1 -> {if (s1[3] == 'O' || s1[3] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[3] = 'X' else s1[3] = 'O'
                        }}
                    list[0] == 2 && list[1] == 2 -> {if (s1[4] == 'O' || s1[4] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[4] = 'X' else s1[4] = 'O'
                        }}
                    list[0] == 2 && list[1] == 3 -> {if (s1[5] == 'O' || s1[5] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[5] = 'X' else s1[5] = 'O'
                        }}
                    list[0] == 3 && list[1] == 1 -> {if (s1[6] == 'O' || s1[6] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[6] = 'X' else s1[6] = 'O'
                        }}
                    list[0] == 3 && list[1] == 2 -> {if (s1[7] == 'O' || s1[7] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[7] = 'X' else s1[7] = 'O'
                        }}
                    list[0] == 3 && list[1] == 3 -> {if (s1[8] == 'O' || s1[8] == 'X') {
                    println(occ)
                    } else {
                        if (countX == countO) s1[8] = 'X' else s1[8] = 'O'
                        }}
                }
                var grid2 = """
                ---------
                | ${s1[0]} ${s1[1]} ${s1[2]} |
                | ${s1[3]} ${s1[4]} ${s1[5]} |
                | ${s1[6]} ${s1[7]} ${s1[8]} |
                ---------
                """.trimIndent()
                println(grid2)
                for (i in s1) {
                    if (i == 'X') ++countX
                    if (i == 'O') ++countO
                    if (i == '_' || i == ' ') ++countF
                }
                
            when {
            s1[0].toString() + s1[1] + s1[2] == "XXX" -> winX = 1
            s1[3].toString() + s1[4] + s1[5] == "XXX" -> winX = 1
            s1[6].toString() + s1[7] + s1[8] == "XXX" -> winX = 1
            s1[0].toString() + s1[3] + s1[6] == "XXX" -> winX = 1
            s1[1].toString() + s1[4] + s1[7] == "XXX" -> winX = 1
            s1[2].toString() + s1[5] + s1[8] == "XXX" -> winX = 1
            s1[0].toString() + s1[4] + s1[8] == "XXX" -> winX = 1
            s1[2].toString() + s1[4] + s1[6] == "XXX" -> winX = 1
            }
            when {
            s1[0].toString() + s1[1] + s1[2] == "OOO" -> winO = 1
            s1[3].toString() + s1[4] + s1[5] == "OOO" -> winO = 1
            s1[6].toString() + s1[7] + s1[8] == "OOO" -> winO = 1
            s1[0].toString() + s1[3] + s1[6] == "OOO" -> winO = 1
            s1[1].toString() + s1[4] + s1[7] == "OOO" -> winO = 1
            s1[2].toString() + s1[5] + s1[8] == "OOO" -> winO = 1
            s1[0].toString() + s1[4] + s1[8] == "OOO" -> winO = 1
            s1[2].toString() + s1[4] + s1[6] == "OOO" -> winO = 1
            }
            when {
                winX == 1 && winO == 0 -> {
                println("X wins")
                return
                }
                winO == 1 && winX == 0 -> {
                println("O wins")
                return
                }
                else -> {
                    if (countF == 0) {
                    println("Draw")
                    return
                    }
                }
            }
            } else {
                when {
                    s2.toInt() < 1 || s2.toInt() > 3 || s3.toInt() > 3 || s3.toInt() < 1 -> {
                    println("Coordinates should be from 1 to 3!")
                    continue
                    }
                    else -> {
                    println("You should enter numbers!")
                    continue
                    }
                }
            }
    }
}
