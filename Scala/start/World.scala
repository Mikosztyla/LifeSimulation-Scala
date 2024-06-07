import things.*
import map.*
import utils.*
import moving.*
import scala.util.CommandLineParser as CLP


@main
def main(): Unit = {
  val animals = List(Animal(Vector2d(3, 1)), Animal())
  val animalMoves = OptionParser.convertData(List("f", "f"))
  val worldMap = RectangularMap(5, 5)

  var i = 0
  var it = animals.iterator
  val it2 = animalMoves.iterator
  while (i < animalMoves.size) {
    if (!it.hasNext) {
      it = animals.iterator
    }
    val animal = it.next()

    worldMap.move(animal, it2.next())
    System.out.println(worldMap)
    i += 1
  }
}
