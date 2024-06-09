package things

import moving.Vector2d

case class Grass(position: Vector2d) extends WorldElement {
    override def toString: String = "*"

    override def isAt(position: Vector2d): Boolean = this.position == position

}
 