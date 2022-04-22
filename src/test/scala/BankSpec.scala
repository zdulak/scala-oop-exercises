import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

class BankSpec extends AnyFlatSpec with should.Matchers {
  behavior of "The method transfer"

  it should "return Bank with money transferred between accounts" in {
//    Arrange
    val bank = Bank(Map(1 -> Account(1, 1000), 2 -> Account(2, 2000)))
    val amount  = 500
    val sourceId = 1
    val targetId = 2
//    Act
    val actualBank = bank.transfer(1, 2, amount)
//    Assert
    actualBank shouldBe a[Some[Bank]]
    actualBank.get.accountsById(sourceId).balance shouldBe  bank.accountsById(sourceId).balance - amount
    actualBank.get.accountsById(targetId).balance shouldBe  bank.accountsById(targetId).balance + amount
  }

}
