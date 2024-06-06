case class Animal(private var animalPosition: Vector2d) extends WorldElement {
    private var animalOrientation: MapDirection = MapDirection.NORTH

    def this() {
        this(Vector2d(2, 2))
    }
    
    override def toString(): String = animalOrientation.toString()
    override def isAt(position: Vector2d): Boolean = animalPosition == position
    def move(direction: MoveDirection, moveValidator: MoveValidator): Unit = match (direction){
        case MoveDirection.LEFT => animalOrientation = animalOrientation.previous()
        case MoveDirection.RIGHT => animalOrientation = animalOrientation.next()
        case MoveDirection.FORWARD => 
            val newPosition = animalPosition + animalOrientation.toUnitVector()
            if (moveValidator.canMoveTo(newPosition)) animalPosition = newPosition
        case MoveDirection.BACKWARD =>
            val newPosition = animalPosition - animalOrientation.toUnitVector()
            if (moveValidator.canMoveTo(newPosition)) animalPosition = newPosition
    }
}