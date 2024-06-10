package moving

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
    case NORTH => Vector2d(0, 1)
    case EAST  => Vector2d(1, 0)
    case SOUTH => Vector2d(0, -1)
    case WEST  => Vector2d(-1, 0)
  }
}