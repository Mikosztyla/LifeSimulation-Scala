package things
import moving.*

case class Animal(var animalPosition: Vector2d = Vector2d(2, 2), var animalOrientation: MapDirection = MapDirection.NORTH) extends WorldElement {

  override def toString: String = animalOrientation.toString()

  override def isAt(position: Vector2d): Boolean = animalPosition == position

  def move(direction: MoveDirection, moveValidator: MoveValidator): Unit = direction match {
    case MoveDirection.LEFT => animalOrientation = animalOrientation.previous
    case MoveDirection.RIGHT => animalOrientation = animalOrientation.next
    case MoveDirection.FORWARD =>
      val newPosition = animalPosition + animalOrientation.toUnitVector
      if (moveValidator.canMoveTo(newPosition)) animalPosition = newPosition
    case MoveDirection.BACKWARD =>
      val newPosition = animalPosition - animalOrientation.toUnitVector
      if (moveValidator.canMoveTo(newPosition)) animalPosition = newPosition
  }
  
  
  
}
