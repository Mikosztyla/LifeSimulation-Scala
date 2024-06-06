package map

import things.{Animal, WorldElement}
import moving.{MoveValidator, Vector2d}

trait WorldMap extends MoveValidator{
  def place(animal: Animal): Boolean
  def move(animal: Animal, moveDirection: MoveDirection): Unit
  
  def isOccupied(position: Vector2d): Boolean
  
  def objectAt(position: Vector2d): WorldElement

  override def canMoveTo(position: Vector2d): Boolean

}
