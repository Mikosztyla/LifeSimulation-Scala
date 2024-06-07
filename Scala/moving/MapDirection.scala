package moving

import moving.Vector2d

enum MapDirection {
  case NORTH, SOUTH, WEST, EAST

  override def toString: String = this match {
    case NORTH => "N"
    case SOUTH => "S"
    case EAST  => "E"
    case WEST  => "W"
  }

  def next: MapDirection = this match {
    case NORTH => EAST
    case EAST  => SOUTH
    case SOUTH => WEST
    case WEST  => NORTH
  }

  def previous: MapDirection = this match {
    case NORTH => WEST
    case WEST  => SOUTH
    case SOUTH => EAST
    case EAST  => NORTH
  }

  def toUnitVector: Vector2d = this match {
    case NORTH => new Vector2d(0, 1)
    case EAST  => new Vector2d(1, 0)
    case SOUTH => new Vector2d(0, -1)
    case WEST  => new Vector2d(-1, 0)
  }
}