case class Account(id: Int, balance: Double) {

  def deposit(amount: Double): Account = Account(id, balance + amount)

  def withdraw(amount: Double): Option[Account] = if ((balance - amount) > 0) Some(Account(id, balance - amount)) else None

  def close: Account = Account(id, 0)

  def statement: String = s"$id : $balance"

//  def :+(amount: Double): Account = deposit(amount)
//
//  def :-(amount: Double): Option[Account] = withdraw(amount)
}
