class Sender(header: String) {
  def send(msg: String): String = header + "\n" + msg
}
