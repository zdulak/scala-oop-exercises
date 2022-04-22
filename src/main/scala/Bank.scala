case class Bank(accountsById: Map[Int, Account]) {
  def this(accounts: List[Account]) = this(accounts.groupMapReduce(_.id)(identity)((acc, _) => acc))

  def transfer(sourceId: Int, targetId: Int, amount: Double): Option[Bank] = {
    if(!accountsById.isDefinedAt(sourceId) || !accountsById.isDefinedAt(targetId)) return None
    val source = accountsById(sourceId)
    val target = accountsById(targetId)
    if((source.balance - amount) < 0) return None

    Some(Bank(accountsById + (sourceId -> source.withdraw(amount).get, targetId -> target.deposit(amount))))
  }
}
