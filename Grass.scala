case class Grass(val position: Vector2d) impl WorldElement
    override def toString(): String = "*"
    override def isAt(position: Vector2d): Boolean = this.position == position
    override def getPosition(): Vector2d = position 