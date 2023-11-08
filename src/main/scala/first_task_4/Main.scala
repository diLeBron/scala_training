package first_task_4

object Main extends App {
  private def printAnimal(animal: String): Unit = println(s"Куплено животное: $animal")

  private def printNotFoundAnimal(animal: String): Unit = println(s"Животное с именем $animal не найдено на складе")

  private def printError(e: String): Unit = println(s"Ошибка при покупке животного: $e")

  try {
    if (
      BankService(1000.0)
        .deductFunds(
          new AnimalStore(
            List(
              Animal("Кот", 50.0),
              Animal("Собака", 100.0)
            )
          ).buyAnimal("Кот")._2
        ).balance < 0
    )
      throw new RuntimeException("Недостаточно средств на счете")

    if (
      new AnimalStore(
        List(
          Animal("Кот", 50.0),
          Animal("Собака", 100.0)
        )
      ).buyAnimal("Кот")._1 != null)
    {
      printAnimal(
        new AnimalStore(
          List(
            Animal("Кот", 50.0),
            Animal("Собака", 100.0)
          )
        ).buyAnimal("Кот")._1.name
      )
      BankService(1000.0)
        .deductFunds(
          new AnimalStore(
            List(
              Animal("Кот", 50.0),
              Animal("Собака", 100.0)
            )
          ).buyAnimal("Кот")._2
        ).showBalance
    }
    else printNotFoundAnimal(
      new AnimalStore(
        List(
          Animal("Кот", 50.0),
          Animal("Собака", 100.0)
        )
      ).buyAnimal("Кот")._1.name
    )
  }
  catch {
    case e: RuntimeException => printError(e.getMessage)
  }
}
