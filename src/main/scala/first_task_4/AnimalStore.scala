package first_task_4

// Класс представляет склад с животными
class AnimalStore(animalState: AnimalState) {
  private def add(other: AnimalState): AnimalState = AnimalState(animalState.animals ::: other.animals)

  def this(animal: Animal) = this(AnimalState(List(animal)))

  def this(animals: List[Animal]) = this(AnimalState(animals))

  def showAnimals(): Unit = animalState.animals.map(x => x.name).foreach(println)

  // Метод для покупки животного
  def buyAnimal(animalName: String): (Animal, BankService, AnimalState) = {
    animalState.animals.find(_.name == animalName) match {
      case Some(a) => (a, BankService(a.price), AnimalState(animalState.animals.filterNot(_ == a)))
      case None => (null, BankService(0.0), AnimalState(animalState.animals))
    }
  }
}

object AnimalStore {
  // Метод для добавления животного на склад
  def addAnimal(animalState: AnimalState, newAnimal: Animal): AnimalState = {
    new AnimalStore(animalState).add(AnimalState(List(newAnimal)))
  }

  def addAnimal(animalState: AnimalState, newAnimals: List[Animal]): AnimalState = {
    new AnimalStore(animalState).add(AnimalState(newAnimals))
  }
}
