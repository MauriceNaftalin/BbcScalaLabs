package labanswers

package object lab1a {
  def convertCentimetersToKilometre(cms: Centimetre) : Kilometre = {
    Kilometre(cms.value / cms.conversion)
  }
}
