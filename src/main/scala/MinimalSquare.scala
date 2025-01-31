package kuro

import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object MinimalSquare {
  def main(args: Array[String]): Unit = {
    val n = readInt()

    def res(a: Int, b: Int): Unit = {
      if (a > b + b) {
        println(a * a)
      }
      else {
        println((b+b)*(b+b))
      }
    }

    (0 until n).foreach { _ =>
      val Array(a, b) = readLine().split(" ").map(_.toInt)

      if (a > b) {
        res(a, b)
      }
      else {
        res(b, a)
      }
    }
  }
}
