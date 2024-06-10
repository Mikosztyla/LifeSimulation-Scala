package utils

import moving.Vector2d
import scala.util.Random

class RandomPositionGenerator(maxWidth: Int, maxHeight: Int, grassCount: Int) extends Iterable[Vector2d] {
  private val list: Seq[Vector2d] = {
    val allPositions = for {
      i <- 0 to maxWidth
      j <- 0 to maxHeight
    } yield Vector2d(i, j)

    Random.shuffle(allPositions).take(grassCount)
  }

  override def iterator: Iterator[Vector2d] = list.iterator
}
