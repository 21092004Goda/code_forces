package kuro

import scala.io.StdIn.readLine

object Watermelon {
  def main(args: Array[String]): Unit = {
    val weight: Byte = readLine().toByte

    weight match {
      case 2 => println("NO")
      case tmp if tmp % 2 == 0 => println("YES")
      case _ => println("NO")
    }
  }
}
