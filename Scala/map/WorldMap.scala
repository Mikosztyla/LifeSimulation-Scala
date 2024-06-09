package map

import things.*
import moving.*

trait WorldMap extends MoveValidator{
  def place(animal: Animal): Boolean
  def move(animal: Animal, moveDirection: MoveDirection): Unit
  
  def isOccupied(position: Vector2d): Boolean
  
  def objectAt(position: Vector2d): WorldElement

  override def canMoveTo(position: Vector2d): Boolean

}
