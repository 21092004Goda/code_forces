package kuro

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Bit {
  def main(args: Array[String]): Unit = {
    val n = readInt()

    val counter = (0 until n).foldLeft(0) { (acc, _) =>
      val line = readLine()

      line match {
        case "++X" | "X++" => acc + 1
        case "--X" | "X--" => acc - 1
      }
    }

    println(counter)
  }
}
