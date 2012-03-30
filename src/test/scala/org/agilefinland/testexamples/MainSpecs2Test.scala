package org.agilefinland.testexamples

import org.specs2.mutable.Specification
import org.agilefinland.examples.Customer;
import org.junit.runner.RunWith
import org.specs2.runner.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MainSpecs2Test extends Specification {

  "New customer" should {
    "'number of complaints' should return 0" in {
      val c = new Customer
      c.complaints === 0
    }
  }

}
