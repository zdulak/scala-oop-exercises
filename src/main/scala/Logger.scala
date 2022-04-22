class Logger(prefix: String) {
  def print(msg: String): Unit = println(prefix + ": " + msg)
}
