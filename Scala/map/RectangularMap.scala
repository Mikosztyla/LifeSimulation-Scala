package map
import moving.*
import things.*
import utils.MapVisualizer

import scala.collection.mutable

class RectangularMap(width: Int, height: Int) extends WorldMap {
  private val animalMap: mutable.HashMap[Vector2d, Animal] = mutable.HashMap.empty
  private val mapVisualizer: MapVisualizer = MapVisualizer(this)
  private val lowerLeft = Vector2d(0, 0)
  private val upperRight = Vector2d(width, height)

  override def place(animal: Animal): Boolean = {
    if (!animalMap.contains(animal.animalPosition)) {
      animalMap.put(animal.animalPosition, animal)
      return true
    }
    false
  }

  override def move(animal: Animal, moveDirection: MoveDirection): Unit = {
    animalMap.remove(animal.animalPosition)
    animal.move(moveDirection, this)
    animalMap.put(animal.animalPosition, animal)
  }

  override def isOccupied(position: Vector2d): Boolean = animalMap.contains(position)

  override def canMoveTo(position: Vector2d): Boolean = {
    isOccupied(position) && position.follows(Vector2d(0,0)) && position.precedes(Vector2d(width, height))
  }

  override def toString: String = mapVisualizer.draw(lowerLeft, upperRight)

  override def objectAt(position: Vector2d): WorldElement = {
    if (animalMap.contains(position)) {
      return animalMap(position)
    }
    null
  }
}
