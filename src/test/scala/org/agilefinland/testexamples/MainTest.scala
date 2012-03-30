package org.agilefinland.testexamples

import org.scalatest.FunSuite
import org.agilefinland.examples.Customer;
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MainTest extends FunSuite {
  test("new customer has no compaints") {
    val c = new Customer
    c.complaints === 0
  }
}
