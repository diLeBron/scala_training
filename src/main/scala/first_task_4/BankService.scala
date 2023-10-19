package first_task_4

object BankService {
  // Класс представляет банковский сервис
  case class BankService(balance: Double) {
    // Метод для списания средств с банковского счета
    def deductFunds(other: BankService): BankService = BankService(balance - other.balance)
  }
}
