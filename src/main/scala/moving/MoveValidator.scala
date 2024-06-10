package moving

trait MoveValidator: 
  def canMoveTo(position: Vector2d): Boolean