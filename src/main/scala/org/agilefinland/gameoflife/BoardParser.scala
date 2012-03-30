package org.agilefinland.gameoflife
import scala.collection.mutable.ListBuffer

case class Cell(val isAlive: Boolean)

class Board(val width: Int, val height: Int, val cellList: Seq[Seq[Cell]]) {
  def cellAt(x: Int, y: Int): Cell = {
    cellList(y)(x)
  }

  def aliveCellAt(x: Int, y: Int): Int = {
    if (x < 0 || y < 0 || x >= width || y >= height)
      0
    else if (cellList(y)(x).isAlive)
      1
    else
      0
  }

  override def equals(other: Any): Boolean = {
    cellList.equals(other.asInstanceOf[Board].cellList)
  }

  def deduce(x: Int, y: Int): Boolean = {
    if (shouldDie(x, y))
      false
    else if (shouldBeBorn(x, y))
      true
    else
      cellAt(x, y).isAlive
  }

  def nextGeneration(): Board = {
    var newCellLines = ListBuffer[List[Cell]]()
    for (x <- 0 until width) {
      var newCellLine = ListBuffer[Cell]()
      for (y <- 0 until height) {
        val alive = deduce(x, y)
        newCellLine += Cell(alive)
      }
      newCellLines += newCellLine.toList
    }
    new Board(width, height, newCellLines.toList)
  }

  def countNeighboursAt(x: Int, y: Int): Int = {
    //cellList(y-1).foldLeft(0)( cell.x > x-1 && cell.y < x+1 && cell.isAlive)
    // Your code is bad and you should feel bad.
    aliveCellAt(x - 1, y - 1) + aliveCellAt(x, y - 1) + aliveCellAt(x + 1, y - 1) +
      aliveCellAt(x - 1, y) + aliveCellAt(x + 1, y) +
      aliveCellAt(x - 1, y + 1) + aliveCellAt(x, y + 1) + aliveCellAt(x + 1, y + 1)
  }

  def shouldDie(x: Int, y: Int): Boolean = {
    if (cellAt(x, y).isAlive) {
      if (countNeighboursAt(x, y) < 2) {
        return true;
      } else if (countNeighboursAt(x, y) > 3) {
        return true;
      }
    }

    false
  }
  def shouldBeBorn(x: Int, y: Int): Boolean = {
    aliveCellAt(x, y) == 0 && countNeighboursAt(x, y) == 3
  }

}

object BoardParser {

  def parseLine(line: String): Seq[Cell] = {
    line.map(c => new Cell(c equals '*'))
  }

  def parse(lines: List[String]): Board = {
    val numberRegex = "(\\d+) (\\d+)".r
    val numberRegex(xSize, ySize) = lines(0)

    val list = lines.tail.map(parseLine);

    new Board(xSize.toInt, ySize.toInt, list)
  }

}