package labanswers.lab1b

import scala.collection.immutable.HashMap

class CovariantBag[+T](val map: Map[AnyRef, Int]) {
  private val map1 = Map[AnyRef,Int]()
  def add[U >: T](elem:U) : CovariantBag[U] = {
    val elem1 = elem.asInstanceOf[AnyRef]
    new CovariantBag[U](map1 + (elem1 -> (map.getOrElse(elem1,0) + 1)))
  }
  def cardinality[U >: T](elem: U):Int = { map1.getOrElse(elem.asInstanceOf[AnyRef], 0) }
  override def toString: String = map.toString()
}

object CovariantBag {
  def main(args: Array[String]): Unit = {
    val bagInt: CovariantBag[Int] = null
    val bagAny: CovariantBag[Any] = bagInt // covariance
  }
}