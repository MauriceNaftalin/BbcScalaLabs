package labanswers.lab2a

case class Date(day: Int, month: Int, year: Int)

object lab2a1 extends App {

  implicit def stringToDate(dateString: String): Date = {
    val regex = raw"(\d\d\d\d)-(\d\d)-(\d\d)".r
    dateString match {
      case regex (year,month,day) => Date(day.toInt, month.toInt, year.toInt)
    }
  }
  println("2019-01-16".day)
}

