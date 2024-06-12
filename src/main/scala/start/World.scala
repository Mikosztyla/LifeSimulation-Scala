package start

import things.*
import map.*
import utils.*
import moving.*

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@main
def main(args: String*): Unit = {
  val numOfMaps = 5
  val animalMoves = OptionParser.convertData(args.toList)
//  for (grass <- new RandomPositionGenerator(5, 5, 5).iterator) {
//    println(grass)
//  }
  val mapVisualizer = MapVisualizer()
  for (i <- 0 until numOfMaps) {
    val worldMap = GrassField(5)
    //  val worldMap = RectangularMap(5, 5)
    val animals = List(Animal(Vector2d(3, 1)), Animal())
    for (animal <- animals.iterator) {
      worldMap.place(animal)
    }
    worldMap.setMapVisualizer(mapVisualizer)
    val sim: Simulation = Simulation(animals, animalMoves, worldMap)
    sim.start()
  }
}
