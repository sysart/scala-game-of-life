package org.agilefinland.gameoflife

import org.specs2.mutable.Specification

class MainSpecs2Test extends Specification {

  "Main class" should {
    "'foo' should return 0"  in {
      val m = new Main
      m.foo === 0
    }
  }

}
