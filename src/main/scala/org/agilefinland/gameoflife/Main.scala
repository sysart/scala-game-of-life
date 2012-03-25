package org.agilefinland.gameoflife

import io.Source
import collection.mutable.ListBuffer

sealed abstract case class Cell(alive: Boolean)
case class Dead() extends Cell(true)
case class Alive() extends Cell(false)

case class Board(listOfCells: List[Cell], size : Coordinate)

class Coordinate(val x: Int, val y: Int) {

  override def toString = "x: " + x.toString + ", y: " + y.toString

}

object Coordinate {
  def apply(x : Int, y: Int) = new Coordinate(x,y)
  def apply(s: String): Coordinate = {
    val parts = s split " "
    if(parts.length == 2) Coordinate(parts(0).toInt, parts(1).toInt)
    throw new IllegalArgumentException
  }

  def unapply(string : String): Option[(Int,  Int)] =  {
    val parts = string split " "
    if(parts.length == 2) (Some(parts(0).toInt, parts(1).toInt)) else None
  }

  def unapply(x: Int, y: Int): Option[(Int,  Int)] =  {
    Some(x, y)
  }
}

class Main {
  val foo = 0
}

object Main extends App {
  val file = Source.fromFile("test.txt")
  val lines = file.getLines.toList
  file.close();
  val firstLine = lines(0)

  val size : Coordinate = firstLine match {
    case Coordinate(x,y) => Coordinate(x, y)
    case _ => throw new IllegalArgumentException("Size was not defined")
  }

  val list = for(val line <- lines drop 1; val c <- line.toCharArray ) yield c match {
    case '.' => new Dead()
    case '*' => new Alive()
  }

  val b = new Board(list, size)


}
