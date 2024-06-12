package start
import map.WorldMap
import moving.*
import things.Animal

case class Simulation(animals: List[Animal], animalMoves: List[MoveDirection], worldMap: WorldMap) extends Thread {
  override def run(): Unit = {
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
}

