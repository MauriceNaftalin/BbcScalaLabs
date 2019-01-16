package labanswers.lab2b

trait Comparer[A] {
  def myCompare(v1: A, v2: A): Boolean
}

case class Fraction(num:Int, den:Int)

object Main extends App {
  implicit val fractionOrdering: Comparer[Fraction] =
    (f1:Fraction, f2:Fraction) => f1.num.toDouble/f1.den < f2.num.toDouble/f2.den
  def <[A: Comparer](v1: A,v2: A) = implicitly[Comparer[A]].myCompare(v1, v2)
  println(<(Fraction(1,2),Fraction(3,4)))
}