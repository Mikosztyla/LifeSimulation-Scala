package start

import things.*
import map.*
import utils.*
import moving.*

@main
def main(args: String*): Unit = {
  val animals = List(Animal(Vector2d(3, 1)), Animal())
  val animalMoves = OptionParser.convertData(args.toList)
  val worldMap = GrassField(5)
//  val worldMap = RectangularMap(5, 5)
  for (animal <- animals.iterator) {
    worldMap.place(animal)
  }

//  for (grass <- new RandomPositionGenerator(5, 5, 5).iterator) {
//    println(grass)
//  }
  println(worldMap)
  var it = animals.iterator
  val it2 = animalMoves.iterator
  for (i <- animalMoves.indices) {
    if (!it.hasNext) {
      it = animals.iterator
    }
    val animal = it.next()

    worldMap.move(animal, it2.next())
    println(worldMap)
  }
}
