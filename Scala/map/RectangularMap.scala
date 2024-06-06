package map
import moving.Vector2d
import things.Animal

import scala.collection.mutable

class RectangularMap(width: Int, height: Int) extends WorldMap {
  private val animalMap: mutable.HashMap[Vector2d, Animal] = mutable.HashMap.empty

  override def place(animal: Animal): Boolean = ???

  override def move(animal: Animal, moveDirection: Any): Unit = ???

  override def isOccupied(position: Vector2d): Boolean = ???

  override def canMoveTo(position: Vector2d): Boolean = ???
}
