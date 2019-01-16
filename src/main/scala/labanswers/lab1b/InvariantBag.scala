package labanswers.lab1b

class InvariantBag[T] {
  import scala.collection.mutable.{Map => MutableMap}
  private val map = MutableMap[T,Int]()
  def add(elem:T) {map += elem -> (map.getOrElse(elem,0) + 1)}
  override def toString: String = map.toString()
}

