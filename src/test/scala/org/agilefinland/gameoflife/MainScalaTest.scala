package org.agilefinland.gameoflife

import org.specs2.matcher.ShouldMatchers
import org.scalatest.matchers.MustMatchers
import org.scalatest.GivenWhenThen
import org.scalatest.{FeatureSpec, FunSpec, FunSuite}

class MainScalaTest extends FunSuite {

  test("foo returns 0") {
    val m = new Main
    assert(m.foo == 0)
  }

}

class MainScalaTestShould extends FunSuite with ShouldMatchers {

  test("foo returns 0") {
    val m = new Main
    m.foo should equalTo(0)
  }
}

class MainScalaTestMust extends FunSuite with MustMatchers {

  test("foo returns 0") {
    val m = new Main
    m.foo must equal(0)
  }
}

class MainScalaTesBdd extends FunSpec with MustMatchers {

  describe("A main class") {
    it("should return 0 when 'foo' is called") {
      val m = new Main
      m.foo must equal(0)
    }

    it("should make coffee when 'bar' is called") ( pending )

  }
}

class MainScalaTesSpec extends FeatureSpec with GivenWhenThen with MustMatchers {

  info("as a programmer")
  info("I want to get zero")
  info("when I call 'foo'")
  feature("Main::foo returns 0") {
    scenario("should return 0 when 'foo' is called") {
      given("A Main class")
      val m = new Main
      when("foo is called")
      val foo: Int = m.foo
      then("value must be 0")
      foo must equal(0)
    }


  }
}