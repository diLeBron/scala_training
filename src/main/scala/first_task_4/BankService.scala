package first_task_4

object BankService extends App {
  // Класс представляет банковский сервис
  class BankService(var balance: Double) {
    // Метод для списания средств с банковского счета
    def deductFunds(amount: Double): Double = {
      balance -= amount
      balance
    }
  }
}
