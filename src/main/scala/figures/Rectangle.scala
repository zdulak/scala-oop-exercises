package figures

class Rectangle(val a: Double, val b: Double) extends Figure {
  override def perimeter: Double = 2 * a + 2 * b
  
  override def area: Double = a * b
}
