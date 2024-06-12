package utils

import map.WorldMap
import moving.Vector2d
import things.WorldElement


class MapVisualizer {
  private val EMPTY_CELL = " "
  private val FRAME_FRAGMENT = "-"
  private val CELL_SEGMENT = "|"

  def draw(map: WorldMap, lowerLeft: Vector2d, upperRight: Vector2d): String = synchronized {
      println(map.getId())
      val bd = new StringBuilder()
      for (i <- upperRight.y + 1 until lowerLeft.y - 1 by -1) {
        if i == upperRight.y + 1 then bd.append(drawHeader(lowerLeft, upperRight))
        bd.append(String.format("%3d: ", i))
        for (j <- lowerLeft.x to upperRight.x + 1) {
          if i < lowerLeft.y || i > upperRight.y then bd.append(drawFrame(j <= upperRight.x))
          else {
            bd.append(CELL_SEGMENT)
            if j <= upperRight.x then bd.append(drawObject(map, Vector2d(j, i)))
          }
        }
        bd.append("\n")
      }
      bd.toString()
  }

  private def drawObject(map: WorldMap, currentPosition: Vector2d): String = {
    if (map.isOccupied(currentPosition)) {
        val worldElement = map.objectAt(currentPosition)
        worldElement.toString
    } else EMPTY_CELL
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
