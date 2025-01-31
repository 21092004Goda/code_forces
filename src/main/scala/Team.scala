package kuro

import scala.io.StdIn.{readLine, readInt}

object Team {
  def main(args: Array[String]): Unit = {
    val n = scala.io.StdIn.readInt()

    val count: Int = (0 until n).foldLeft(0) { (acc, _) =>
      val line: String = scala.io.StdIn.readLine()
      if (line == "1 1 0" | line == "0 1 1" | line == "1 1 1" | line == "1 0 1") acc + 1 else acc
    }

    println(count)
  }
}
