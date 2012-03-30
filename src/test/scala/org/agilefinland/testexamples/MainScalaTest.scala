package org.agilefinland.testexamples

import org.specs2.matcher.ShouldMatchers
import org.scalatest.matchers.MustMatchers
import org.scalatest.GivenWhenThen
import org.scalatest.{ FeatureSpec, FunSpec, FunSuite }
import org.scalatest.junit.JUnitRunner
import org.agilefinland.examples.Customer;
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class MainScalaTest extends FunSuite {

  test("no complaints") {
    val c = new Customer
    assert(c.complaints == 0)
  }

}

@RunWith(classOf[JUnitRunner])
class MainScalaTestShould extends FunSuite with ShouldMatchers {

  test("no complaints") {
    val c = new Customer
    c.complaints should equalTo(0)
  }
}

@RunWith(classOf[JUnitRunner])
class MainScalaTestMust extends FunSuite with MustMatchers {

  test("no complaints") {
    val c = new Customer
    c.complaints must equal(0)
  }
}

@RunWith(classOf[JUnitRunner])
class MainScalaTesBdd extends FunSpec with MustMatchers {

  describe("A new customer") {
    it("should have no complaints") {
      val c = new Customer
      c.complaints must equal(0)
    }

    it("should pay us loads of money")(pending)

  }
}

@RunWith(classOf[JUnitRunner])
class MainScalaTesSpec extends FeatureSpec with GivenWhenThen with MustMatchers {

  info("as an entrepreneur")
  info("I want to get zero complaints")
  info("from new customers")
  feature("Customer::complaints returns number of complaints") {
    scenario("should return 0 customer is new") {
      given("A new customer")
      val c = new Customer
      when("complaints is called")
      val complaints: Int = c.complaints
      then("value must be 0")
      complaints must equal(0)
    }

  }
}