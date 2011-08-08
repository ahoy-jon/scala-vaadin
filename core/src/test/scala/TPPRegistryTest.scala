package scalavaadin

import org.scalatest.{BeforeAndAfterEach, FunSuite}




class TPPRegistryTest extends FunSuite with BeforeAndAfterEach {


  override def beforeEach() {
     TPPRegistry._map.clear()

  }

  test("Basic wrapper test") {
    val vaadinTable = new com.vaadin.ui.Table()
    val scalaTable: Table = TPPRegistry.wrap[Table](vaadinTable)
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

  test("Wrapper test with inheritance 2") {
    val vaadinTable = new com.vaadin.ui.Table()
    val scalaComponent = TPPRegistry.wrap[scalavaadin.Component](vaadinTable)
    val scalaTable = TPPRegistry.wrap[scalavaadin.Table](vaadinTable)
    assert(scalaTable.eq(scalaComponent))
  }

  test("GC") {

    TPPRegistry.wrap(new com.vaadin.ui.Table())
    assert(TPPRegistry._map.size() === 1)

    // J'aime quand GC marche bien. Il ne faudrait pas attendre 30 ans, donc on va l'aider un peu.
    var i = 0
    while (TPPRegistry._map.size() != 0) {
       new Array[String](99999);
    }
    assert(TPPRegistry._map.size() === 0)
  }

}
