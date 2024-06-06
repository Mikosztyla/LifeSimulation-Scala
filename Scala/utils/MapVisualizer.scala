package utils

import map.WorldMap
import moving.Vector2d
import things.WorldElement

class MapVisualizer(map: WorldMap) {
  private val EMPTY_CELL = " "
  private val FRAME_FRAGMENT = "-"
  private val CELL_SEGMENT = "|"

  def draw(lowerLeft: Vector2d, upperRight: Vector2d): String = {
    val bd = new StringBuilder()
    for (i <- upperRight.y + 1 until lowerLeft.y by -1) {
      if i == upperRight.y + 1 then bd.append(drawHeader(lowerLeft, upperRight))
      bd.append(String.format("%3d: ", i))
      for (j <- lowerLeft.x to upperRight.x + 1) {
        if (i < lowerLeft.y || i > upperRight.y) {
          bd.append(drawFrame(j <= upperRight.x))
        } else {
          bd.append(CELL_SEGMENT)
          if j <= upperRight.x then bd.append(drawObject(new Vector2d(j, i)))
        }
      }
    }
  }

  private def drawObject(currentPosition: Vector2d) = {
    if (map.isOccupied(currentPosition)) {
        val worldElement = map.objectAt(currentPosition)
        if worldElement != null then worldElement.toString
    }
    EMPTY_CELL
  }

  private def drawFrame(innerSegment: Boolean) = {
    if innerSegment then FRAME_FRAGMENT + FRAME_FRAGMENT
    else FRAME_FRAGMENT
  }

  private def drawHeader(lowerLeft: Vector2d, upperRight: Vector2d) = {
    val bd = new StringBuilder()
    bd.append(" y\\x ")
    for (j <- lowerLeft.x until upperRight.x + 1) {
      bd.append(String.format("%2d", j))
    }
    bd.append(System.lineSeparator())
    bd.toString()
  }

}
