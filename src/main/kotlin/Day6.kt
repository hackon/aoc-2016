import java.io.File
import java.nio.charset.Charset

/**
 * Created by haakon on 16.12.16.
 */

class Day6 {
  val lines = readIn("Day6")
  fun part1() {
    getMap().forEach{ print(it.entries.sortedByDescending { it.value }[0].key) }
  }
  fun part2(){
    getMap().forEach { print(it.entries.sortedBy { it.value }[0].key) }
  }

  private fun getMap(): MutableList<MutableMap<Char, Int>> {
    val charMap: MutableList<MutableMap<Char, Int>> = mutableListOf()
    var firstList = true
    for (line in lines) {
      line.toCharArray().forEachIndexed { i, c ->
        if (firstList) {
          charMap.add(i, mutableMapOf())
        }
        var i1 = charMap[i].getOrPut(c, { 1 })
        i1 = i1.inc()
        charMap[i][c] = i1
      }
      firstList = false
    }
    return charMap
  }

}

fun main(args: Array<String>) {
  val day6 = Day6()
  day6.part1()
  println()
  day6.part2()
}