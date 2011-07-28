import org.scalatest.{BeforeAndAfterEach, FunSuite}
import scalavaadin.{TPPRegistry, PeerProxy}

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


class TPPRegistryTest extends FunSuite with BeforeAndAfterEach {


  override def beforeEach() {
      val r = Runtime.getRuntime
      r.gc()

  }

  test("Basic wrapper test") {
    val vaadinTable = new com.vaadin.ui.Table()
    val scalaTable: scalavaadin.Table = TPPRegistry.wrap[scalavaadin.Table](vaadinTable)
    assert(vaadinTable === scalaTable.peer)
    assert(vaadinTable.eq(scalaTable.peer))
  }

  test("Advanced wrapper test") {
    val vaadinTable = new com.vaadin.ui.Table()

    val awrapedTable = {
      () => TPPRegistry.wrap[scalavaadin.Table](vaadinTable)
    }

    val scalaTables = (awrapedTable, awrapedTable)
    assert(scalaTables._1 === scalaTables._2)
    assert(scalaTables._1.eq(scalaTables._2))
  }

  test("Wrapper test with inheritance") {
    val vaadinTable = new com.vaadin.ui.Table()
    val scalaTable = TPPRegistry.wrap[scalavaadin.Table](vaadinTable)
    val scalaComponent = TPPRegistry.wrap[ scalavaadin.Component](vaadinTable)

    assert(scalaTable.eq(scalaComponent))
  }

}
