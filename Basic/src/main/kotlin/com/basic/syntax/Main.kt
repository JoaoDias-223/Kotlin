package com.basic.syntax

class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val intArray = args.map { it.toInt() }.toIntArray()
            val sum = sumOfArgs(*intArray)

            println("out print $sum")

        }

        private fun sumOfArgs(vararg arr: Int, initial: Int = 0, limit: Int = 0, f: ((it: Int, limit: Int) -> Boolean)? = null): Int {
            var sum = arr.fold(initial) { sum, element -> sum + element }

            if (f != null) {
                sum /= if (f(sum, limit) || limit == 0) 1 else limit
            }

            return sum
        }

        infix fun Int.`should not be higher than`(x: Int): Boolean {
            return this <= x
        }
    }
}