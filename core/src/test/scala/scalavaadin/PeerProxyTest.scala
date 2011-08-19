package scalavaadin

import org.scalatest.{BeforeAndAfterEach, FunSuite}

class PeerProxyTest extends FunSuite {
  private def m[T](implicit ma: Manifest[T]): Manifest[T] = ma;

  test("PeerProxy inheritance") {
    class A
    class AA extends A
    class AAA extends AA

    //Check on basic properties on A's manifest
    assert(m[AA] <:< m[A])
    assert(m[AAA] <:< m[AA])
    assert(m[AAA] <:< m[A])
    assert(!(m[A] <:< m[AA]))

    abstract class PA extends PeerProxy[A]
    abstract class PAA extends PA with PeerProxy[AA]
    abstract class PAAA extends PAA with PeerProxy[AAA]

    //Check on expected properties on PeerProxy[A]'s manifest
    assert(m[PAA] <:< m[PA])
    assert(m[PAAA] <:< m[PAA])
    assert(m[PAAA] <:< m[PA])
    assert(!(m[PA] <:< m[PAA]))
  }


}



