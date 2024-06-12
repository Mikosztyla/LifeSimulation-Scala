package map

import things.*
import moving.*
import utils.MapVisualizer

import java.util.UUID

trait WorldMap extends MoveValidator: 
  def place(animal: Animal): Boolean
  def move(animal: Animal, moveDirection: MoveDirection): Unit
  def isOccupied(position: Vector2d): Boolean
  def objectAt(position: Vector2d): WorldElement
  def getId(): UUID
  override def canMoveTo(position: Vector2d): Boolean
