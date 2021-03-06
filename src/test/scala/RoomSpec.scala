import rooms.{Person, Room}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class RoomSpec extends AnyFlatSpec with should.Matchers {
  behavior of "The Room constructor"

  it should "return exception when capacity parameter is lower than zero" in {
    an [IllegalArgumentException] shouldBe thrownBy(Room(-1))
  }

  it should "return exception when capacity parameter is lower than number of the given persons" in {
    an [IllegalArgumentException] shouldBe thrownBy(Room(0, List(Person("Jacek"))))
  }

  behavior of "The method enter"

  it should "return Room with added person when its capacity is greater or equal to the number of people in the room" in {
//    Arrange
    val room = Room(2)
    val person = Person("Jacek")
//    Act
    val actualRoomOption = room.enter(person)
//    Assert
    actualRoomOption shouldBe a [Some[Bank]]
    actualRoomOption.get shouldBe Room(2, List(person))
  }

  it should "return None when capacity of the room is lower than number of people in the room plus one" in {
    //    Arrange
    val room = Room(0)
    val person = Person("Jacek")
    //    Act
    val actualRoomOption = room.enter(person)
    //    Assert
    actualRoomOption shouldBe None
  }

  behavior of "The method leave"

  it should "return Room without the given person" in {
    //    Arrange
    val person = Person("Jacek")
    val room = Room(2, List(person))
    //    Act
    val actualRoom = room.leave(person)
    //    Assert
    actualRoom shouldBe Room(2)
  }
}
