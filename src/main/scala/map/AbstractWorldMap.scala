package map

import things.*
import utils.*
import moving.*

import scala.collection.mutable
import scala.compiletime.uninitialized

abstract class AbstractWorldMap {
  protected val animalMap: mutable.Map[Vector2d, Animal] = mutable.HashMap()
  protected var mapBounds: Boundary = uninitialized
  protected val mapVisualizer: MapVisualizer = new MapVisualizer(getWorldMap)

  def place(animal: Animal): Boolean = {
    if (!getWorldMap.canMoveTo(animal.animalPosition)) {
      //throw new PositionAlreadyOccupiedException(animal.getPosition)
      false
    } else {
      animalMap.put(animal.animalPosition, animal)
      true
    }
  }

  def objectAt(position: Vector2d): WorldElement = animalMap.getOrElse(position, null)

  protected def move(animal: Animal, direction: MoveDirection, moveValidator: MoveValidator): Unit = {
    animalMap.remove(animal.animalPosition)
    animal.move(direction, moveValidator)
    animalMap.put(animal.animalPosition, animal)
  }

  def isOccupied(position: Vector2d): Boolean = objectAt(position) != null

  def getElements: Iterable[WorldElement] = animalMap.values

  protected def getCurrentBounds: Boundary
  protected def getWorldMap: WorldMap

  override def toString: String = {
    mapBounds = getCurrentBounds
    mapVisualizer.draw(mapBounds.lowerLeft, mapBounds.upperRight)
  }
}
