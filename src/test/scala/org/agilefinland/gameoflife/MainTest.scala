package org.agilefinland.gameoflife

import org.scalatest.FunSuite

class MainTest extends FunSuite {
  test("Main class") {
    val m = new Main
    m.foo === 0
  }
}
