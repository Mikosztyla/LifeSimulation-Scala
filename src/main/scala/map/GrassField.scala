package map

import things.*
import moving.*
import utils.{Boundary, MapVisualizer, RandomPositionGenerator}

import java.util.UUID
import scala.collection.mutable

class GrassField(numberOfGrass: Int) extends AbstractWorldMap {
  private val grassMap = new mutable.HashMap[Vector2d, Grass]()
  private val maxWidth = Math.sqrt(10 * numberOfGrass).toInt
  private val maxHeight = Math.sqrt(10 * numberOfGrass).toInt
  private val id = UUID.randomUUID()
  RandomPositionGenerator(maxWidth, maxHeight, numberOfGrass).foreach { pos => grassMap(pos) = Grass(pos)}
  override def canMoveTo(position: Vector2d): Boolean = !(objectAt(position).isInstanceOf[Animal])

  override def move(animal: Animal, moveDirection: MoveDirection): Unit = super.move(animal, moveDirection, this)
  override def objectAt(position: Vector2d): WorldElement = {
    val animal = super.objectAt(position)
    if (animal != null) animal
    else grassMap.getOrElse(position, null)
  }
  override def place(animal: Animal): Boolean = super.place(animal)

  override def getCurrentBounds: Boundary = {
    val allPositions = grassMap.keySet ++ animalMap.keySet
    if (allPositions.isEmpty) Boundary(Vector2d(0, 0), Vector2d(1, 1))
    else {
      val (min, max) = allPositions.foldLeft((allPositions.head, allPositions.head)) {
        case ((min, max), pos) => (min.lowerLeft(pos), max.upperRight(pos))
      }
      Boundary(min, max)
    }
  }

  override def getElements: Iterable[WorldElement] = super.getElements ++ grassMap.values
  override def getWorldMap: WorldMap = this
  override def getId(): UUID = id
}
