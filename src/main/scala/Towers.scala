package kuro

import scala.annotation.tailrec
import scala.io.StdIn.readInt
import scala.io.StdIn.readLine

object Towers {
  def main(args: Array[String]): Unit = {

    case class Sorted() {
      def margeSorted(array: List[Int]): List[Int] = {
        if (array.length <= 1) {
          array
        }
        else {
          val (left, right) = array.splitAt(array.length / 2)

          val leftSort = margeSorted(left)
          val rightSort = margeSorted(right)

          marge(leftSort, rightSort)
        }

      }

      def marge(left: List[Int], right: List[Int]): List[Int] = {
        (left, right) match {
          case (List(), _) => right
          case (_, List()) => left
          case (lHead :: lTail, rHead :: rTail) => {
            if (lHead <= rHead) lHead :: marge(lTail, right)
            else rHead :: marge(left, rTail)
          }
        }
      }


      def sort(arr: List[Int]): List[Int] = {
        margeSorted(arr)
      }
    }


    val _ = readInt()

    val arr: List[Int] = readLine().split(" ").map(_.toInt).toList

    val sort_arr: List[Int] = Sorted().sort(arr)

    @tailrec
    def counter(sort_arr: List[Int], iter: Int, acc: Int, count: Int, max_count: Int, single: Int): (Int, Int) = {
      if (iter >= sort_arr.length) {
        (math.max(count, max_count), single + 1)
      }
      else if (sort_arr(iter) == acc) {
        counter(sort_arr, iter + 1, acc, count + 1, math.max(count + 1, max_count), single)
      }
      else {
        counter(sort_arr, iter + 1, sort_arr(iter), 1, math.max(count, max_count), single + 1)
      }
    }

    println(counter(sort_arr, 0, sort_arr.head, 0, 0, 0).productIterator.mkString(" "))
  }
}

