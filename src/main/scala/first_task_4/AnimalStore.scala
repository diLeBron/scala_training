package first_task_4

object AnimalStore extends App {
  // Класс представляет склад с животными
  class AnimalStore {
    var animals: List[Animal] = List()

    private def add(currentAnimals: List[Animal], newAnimal: Animal): List[Animal] = currentAnimals :+ newAnimal

    def this(animal: Animal) = {
      this()
      this.animals :+ animal
    }

    def this(animals: List[Animal]) = {
      this()
      this.animals = animals
    }

    def showAnimals(): Unit = {
      animals.map(x => x.name).foreach(println)
    }

    // Метод для покупки животного
    def buyAnimal(animalName: String): (Animal, Double, List[Animal]) = {
      this.animals.find(_.name == animalName) match {
        case Some(a) => (a, a.price, this.animals.filterNot(_ == a))
        case None => (null, 0.0, this.animals)
      }
    }
  }

  object AnimalStore {
    // Метод для добавления животного на склад
    def addAnimal(currentAnimals: List[Animal], newAnimal: Animal): List[Animal] = {
      new AnimalStore().add(currentAnimals, newAnimal)
    }
  }
}