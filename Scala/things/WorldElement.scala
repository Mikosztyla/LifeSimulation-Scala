package things

trait WorldElement:
    def isAt(position: Vector2d): Boolean
    def getPosition(): Vector2d