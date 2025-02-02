package kuro

import scala.annotation.tailrec
import scala.io.StdIn.readLine

object Letters {

  case class BinarySearch(array: Array[Long]) {

    @tailrec
    private def findIndex(value: Long, acc_left: Int, acc_right: Int): Int = {
      if (acc_left >= acc_right) {
        acc_left
      } else {
        val tmp: Int = (acc_right + acc_left) / 2

        if (array(tmp) < value) {
          findIndex(value, tmp + 1, acc_right)
        } else {
          findIndex(value, acc_left, tmp)
        }
      }
    }

    def findIndex(value: Long): Int = {
      findIndex(value, 0, array.length)
    }
  }

  def main(args: Array[String]): Unit = {
    val Array(n, m) = readLine().split(" ").map(_.toInt)

    val array_home: Array[Long] = 0L +: readLine().split(" ").map(_.toLong)

    val array_sum: Array[Long] = array_home.scanLeft(0L)(_ + _).tail

    val array_flat: Array[Long] = readLine().split(" ").map(_.toLong)

    val bin: BinarySearch = new BinarySearch(array_sum)

    array_flat.foreach { tmp =>
      val ind: Int = bin.findIndex(tmp)

      printf(s"%d %d\n", ind, tmp - array_sum(ind - 1))
    }
  }
}