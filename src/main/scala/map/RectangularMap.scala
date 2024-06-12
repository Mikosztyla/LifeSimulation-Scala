package map

import moving.*
import things.*
import utils.*

import java.util.UUID
import scala.collection.mutable

class RectangularMap(width: Int, height: Int) extends AbstractWorldMap {
  mapBounds = Boundary(Vector2d(0, 0), Vector2d(width - 1, height - 1))
  private val lowerLeft = Vector2d(0, 0)
  private val upperRight = Vector2d(width, height)
  private val id = UUID.randomUUID()

  override def place(animal: Animal): Boolean = {
    if (!animalMap.contains(animal.animalPosition)) {
      animalMap.put(animal.animalPosition, animal)
      return true
    }
    false
  }

  override def move(animal: Animal, direction: MoveDirection): Unit = super.move(animal, direction, this)

  override def canMoveTo(position: Vector2d): Boolean = {
    !isOccupied(position) && position.follows(Vector2d(0,0)) && position.precedes(Vector2d(width, height))
  }

  override def getCurrentBounds: Boundary = mapBounds

  override def getWorldMap: WorldMap = this

  override def getId(): UUID = id
}
