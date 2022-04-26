package rooms

case class Room(capacity: Int, persons: List[Person] = List.empty[Person]) {
  if (capacity < 0) throw new IllegalArgumentException("The capacity must be positive, integer number")
  if (capacity < persons.length) throw new IllegalArgumentException("The capacity must be greater than the number of persons in the room")

  def enter(person: Person): Option[Room] =
    if (persons.length + 1 <= capacity) Some(Room(capacity, persons :+ person)) else None
  def leave(person: Person): Room = Room(capacity, persons.filter(_ != person))
  def getReport: String = s"There are ${persons.length} people in the room "
}
