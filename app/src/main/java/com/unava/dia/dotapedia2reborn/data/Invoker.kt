package com.unava.dia.dotapedia2reborn.data

class Invoker {
    var combination = ""

    private var skillBasePath = "img/invoker/"
    private var skillEndPath = ".png"
    private var skillMidpath = ""
    var skill4 = "img/invoker/4.png"
    var skill5 = "img/invoker/5.png"
    var flag = false

    fun pushEnd(qwe: String) {
        if (combination.length >= 3) combination = combination.substring(1)
        combination += qwe
    }

    fun generatePath(): String {
        generateMidPath()
        this.swapFlag()
        return when {
            flag -> {
                skill4 = skillBasePath + skillMidpath + skillEndPath
                skill4
            }
            else -> {
                skill5 = skillBasePath + skillMidpath + skillEndPath
                skill5
            }
        }
    }

    private fun generateMidPath() {
        if (combination.length != 3) return

        if (combination.contains("q") && combination.contains("w") && combination.contains("e")) {
            skillMidpath = "qwe"
        } else if (combination == "qqq") {
            skillMidpath = "qqq"
        } else if (combination == "www") {
            skillMidpath = "www"
        } else if (combination == "eee") {
            skillMidpath = "eee"
        } else if (count(combination, "q") == 2) {
            if (combination.contains("w"))
                skillMidpath = "qqw"
            else if (combination.contains("e")) skillMidpath = "qqe"
        } else if (count(combination, "w") == 2) {
            if (combination.contains("q"))
                skillMidpath = "wwq"
            else if (combination.contains("e")) skillMidpath = "wwe"
        } else if (count(combination, "e") == 2) {
            if (combination.contains("w"))
                skillMidpath = "eew"
            else if (combination.contains("q")) skillMidpath = "eeq"
        } else
            skillMidpath = "4"
    }

    private fun swapFlag() {
        flag = true != flag
    }

    private fun count(str: String, ch: String): Int {
        var temp: String
        var counted = 0

        for (i in 0 until str.length) {
            temp = Character.toString(str[i])

            if (temp == ch)
                counted++
        }
        return counted
    }
}