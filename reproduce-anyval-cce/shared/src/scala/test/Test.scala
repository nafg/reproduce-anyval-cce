package test

class Inner

class Outer(val inner: Inner) extends AnyVal

trait Abstract[F] {
  protected def helper: F

  protected def method(): F = helper
}

trait Concrete extends Abstract[Outer] {
  override protected def helper: Outer =
    new Outer(new Inner())
}

trait Public extends Concrete {
  def method2(): Outer =
    super.method()
}

object Test extends App {
  private object instance extends Public

  instance.method2()
}
