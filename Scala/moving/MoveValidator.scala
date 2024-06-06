package moving

import moving.Vector2d

trait MoveValidator:
    def canMoveTo(position: Vector2d): Boolean