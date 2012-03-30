package org.agilefinland.gameoflife
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite
import org.scalatest.matchers.MustMatchers

@RunWith(classOf[JUnitRunner])
class MainScalaTestMust extends FunSuite with MustMatchers {

  def parseBoard(lines: String*) = {
    BoardParser parse (List(lines: _*))
  }

  test("size 1x1") {
    val board = parseBoard("1 1", ".")
    board.width must equal(1)
    board.height must equal(1)
  }

  test("cell must die") {
    val board = parseBoard(
      "2 2",
      "..",
      "*.")
    board.shouldDie(0, 1) must equal(true)
  }

  test("cell must bring alive") {
    val board = parseBoard(
      "2 2",
      "**",
      ".*")
    board.shouldBeBorn(0, 1) must equal(true)
  }

  test("dead cell") {
    var board = parseBoard("1 1", ".")
    board.cellAt(0, 0).isAlive must equal(false)
  }

  test("alive cell") {
    var board = parseBoard("1 1", "*")
    board.cellAt(0, 0).isAlive must equal(true)
  }

  test("2x2 board") {
    var board = parseBoard("2 2", ".*", "*.")
    board.cellAt(0, 0).isAlive must equal(false)
    board.cellAt(1, 0).isAlive must equal(true)
  }

  test("Count neighbours") {
    var board = parseBoard("3 3",
      "*..",
      ".*.",
      ".*.")
    board.countNeighboursAt(1, 1) must equal(2);
    board.countNeighboursAt(0, 1) must equal(3);
  }

  test("equals") {
    var nextBoard = parseBoard("3 3",
      "*..",
      ".*.",
      ".*.")

    var expectedBoard = parseBoard("3 3",
      "*..",
      ".*.",
      ".*.")

    nextBoard must equal(expectedBoard)
  }

    test("must not equal") {
    var nextBoard = parseBoard("3 3",
      "*..",
      ".*.",
      ".*.")

    var expectedBoard = parseBoard("3 3",
      "*..",
      "...",
      ".*.")

    nextBoard must not equal(expectedBoard)
  }

  test("The next generation!") {
    var nextBoard = parseBoard("3 3",
      "*..",
      ".*.",
      ".*.").nextGeneration()

    var expectedBoard = parseBoard("3 3",
      "...",
      ".*.",
      "...")

    nextBoard must equal(expectedBoard)
  }
}