package figures

class Circle(val r: Double) extends Figure {
  override def perimeter: Double = 2 * Math.PI * r

  override def area: Double = Math.PI * r * r
}
