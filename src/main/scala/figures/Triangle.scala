package figures

class Triangle(val a: Double, val b: Double, val c: Double) extends Figure {
  if (2 * Math.max(Math.max(a , b), c) >= perimeter)
    throw new IllegalArgumentException("The triangle inequality is not satisfied by the arguments")

  override def perimeter: Double = a + b + c

  override def area: Double = {
    val s = perimeter / 2
    Math.sqrt(s * (s - a) * (s - b) * (s - c))
  }
}
