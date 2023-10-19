package first_task_4

import first_task_4.AnimalStore.AnimalStore
import first_task_4.BankService.BankService

object Main extends App {
  try {
    if (BankService(1000.0).deductFunds(new AnimalStore(List(Animal("Кот", 50.0),Animal("Собака", 100.0))).buyAnimal("Кот")._2).balance < 0)
      throw new RuntimeException("Недостаточно средств на счете")

    if (new AnimalStore(List(Animal("Кот", 50.0),Animal("Собака", 100.0))).buyAnimal("Кот")._1 != null) {
      println(s"Куплено животное: ${new AnimalStore(List(Animal("Кот", 50.0),Animal("Собака", 100.0))).buyAnimal("Кот")._1.name}")
      println(s"Остаток на счете: ${BankService(1000.0).deductFunds(new AnimalStore(List(Animal("Кот", 50.0),Animal("Собака", 100.0))).buyAnimal("Кот")._2).balance}")
    }
    else println(s"Животное с именем ${new AnimalStore(List(Animal("Кот", 50.0),Animal("Собака", 100.0))).buyAnimal("Кот")._1} не найдено на складе")
  }
  catch {
    case e: RuntimeException =>
      println(s"Ошибка при покупке животного: ${e.getMessage}")
  }
}
