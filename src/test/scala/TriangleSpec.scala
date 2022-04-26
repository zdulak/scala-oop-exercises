import figures.Triangle
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class TriangleSpec extends AnyFlatSpec with should.Matchers {
  behavior of "Triangle"

  it should "throw exception when arguments do not satisfy the triangle inequality" in {
    an [IllegalArgumentException] shouldBe thrownBy(new Triangle(10, 1, 1))
  }

  it should "return perimeter when perimeter method is invoked" in {
    //    Arrange
    val a = 5
    val b = 4
    val c = 3
    val triangle = new Triangle(a, b, c)
    //    Act & Assert
    triangle.perimeter shouldBe (a + b + c)
  }

  it should "return area when area method is invoked" in {
    //    Arrange
    val a = 5
    val b = 4
    val c = 3
    val triangle = new Triangle(a, b, c)
    //    Act & Assert
    triangle.area shouldBe c * b / 2
  }
}
