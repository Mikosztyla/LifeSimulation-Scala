package moving

// case class provides implementation for "equals", "hashCode", and "toString" functions, however
// we still want to override "toString" function
case class Vector2d(x: Int, y: Int):
  def +(other: Vector2d) = Vector2d(x + other.x, y + other.y)

  def -(other: Vector2d) = Vector2d(x - other.x, y - other.y)

  def precedes(other: Vector2d): Boolean = x <= other.x && y <= other.y

  def follows(other: Vector2d): Boolean = x >= other.x && y >= other.y

  def lowerLeft(other: Vector2d): Vector2d = Vector2d(Math.min(x, other.x), Math.min(y, other.y))

  def upperRight(other: Vector2d): Vector2d = Vector2d(Math.max(x, other.x), Math.max(y, other.y))

  def opposite(): Vector2d = Vector2d(-x, -y)

  override def toString: String = s"($x, $y)"