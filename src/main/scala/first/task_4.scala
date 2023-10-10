package first

object task_4 extends App {
  // Класс представляет животное
  class Animal(val name: String, val price: Double)

  // Класс представляет банковский сервис
  class BankService {
    // Метод для списания средств с банковского счета
    def deductFunds(balance: Double, amount: Double): Double = balance - amount
  }

  // Класс представляет склад с животными
  class AnimalStore {
    // Метод для добавления животного на склад
    def addAnimal(currentAnimals: List[Animal], newAnimal: Animal): List[Animal] = currentAnimals :+ newAnimal

    // Метод для покупки животного
    def buyAnimal(currentAnimals: List[Animal], animalName: String): (Animal, Double, List[Animal]) = {
      animals.find(_.name == animalName) match {
        case Some(a) => (a, a.price, currentAnimals.filterNot(_ == a))
        case None => (null, 0.0, currentAnimals)
      }
    }
  }

  // Использование классов
  val bankService = new BankService()
  val animalStore = new AnimalStore()

  val cat = new Animal("Кот", 50.0)
  val dog = new Animal("Собака", 100.0)

  var balance = 1000.0
  var animals: List[Animal] = List()
  animals = animalStore.addAnimal(animals, cat)
  animals = animalStore.addAnimal(animals, dog)

  try {
    val animalName = "Кот"
    val purchase = animalStore.buyAnimal(animals, animalName)
    val purchasedAnimal = purchase._1
    val price = purchase._2
    animals = purchase._3
    balance = bankService.deductFunds(balance, price)
    if (balance < 0) throw new RuntimeException("Недостаточно средств на счете")

    if (purchasedAnimal != null) {
      println(s"Куплено животное: ${purchasedAnimal.name}")
      println(s"Остаток на счете: $balance")
    }
    else println(s"Животное с именем $animalName не найдено на складе")
  }
  catch {
    case e: RuntimeException =>
      println(s"Ошибка при покупке животного: ${e.getMessage}")
  }
}
