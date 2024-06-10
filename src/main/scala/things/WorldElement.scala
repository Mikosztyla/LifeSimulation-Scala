package things

import moving.Vector2d

trait WorldElement:
    def isAt(position: Vector2d): Boolean

    override def toString: String
    