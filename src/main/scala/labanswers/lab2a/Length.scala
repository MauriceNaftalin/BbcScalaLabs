package labanswers.lab2a

abstract class Length(value: Double) extends Ordered[Length] {
  val conversion: Double
  private[lab2a] def metre = Metre(value / conversion)
  def compare(that: Length): Int = metre.compare(that.metre)
  def toCentimetres: Centimetre = Centimetre(value / conversion)
  def toMetres: Metre = Metre(value / conversion)
  def toKilometres: Kilometre = Kilometre(value / conversion)
}

case class Metre(value: Double) extends Length(value: Double) {
  override val conversion = 1
  def +(other: Length): Metre = Metre(value + other.metre.value)
  def compare(that: Metre): Int = value.compare(that.value)
}

case class Centimetre(value: Double) extends Length(value: Double) {
  override val conversion: Double = 100
  def this(m: Metre) {this(m.value * 100)}
  def +(other: Length): Centimetre = new Centimetre(metre + other.metre)
}

case class Kilometre(value: Double) extends Length(value: Double) {
  override val conversion = 0.001
  def this(m: Metre) {this(m.value * 0.001)}
  def +(other: Length): Kilometre = new Kilometre(metre + other.metre)
}

object lab2a2 {
  implicit class IntOps ( i: Int ) {
    def cm: Centimetre = Centimetre(i)
  }
  def main(args: Array[String]): Unit = {
    val cm1 = 3 cm
    val cm2 = 2 cm;
    println(cm1 + cm2)
    println(cm1.compare(Kilometre(2)))
    println(Metre(1).compare(cm1))
    println(cm2 + Kilometre(3))
    println(cm1.toKilometres)
  }
}


