package fr.istic.si2.tp4.exosCalcul

import fr.istic.si2.scribble._
import scala.annotation.tailrec

object ExosCalculs extends App {

  /**
   * @param n un entier positif ou nul
   * @param s une chaîne
   * @return la chaîne composée de n fois la chaîne s, séparée à chaque fois par un tiret
   */
  def copie(n: Int, s: String): String = {
    n match {
      case 0 => ""
      case 1 => s
      case _ => s + "-" + copie(n - 1, s)
    }
  }

  /** Affiche n fois le caractère c, en allant à la ligne entre chaque caractère
   *
   * @param n un entier positif ou nul
   * @param c un caractère
   */
  def repeat(n: Int, c: Char): Unit = {
    n match {
      case 0 =>
      case _ => println(c); repeat(n - 1, c)
    }
  }

//  repeat(2, 'c')

  /**
   * Affiche le décompte en partant de n, en finissant par "Time OUT !", avec un retour à la ligne entre chaque nombre
   *
   * @param n un entier positif ou nul
   */
  // TODO 
  def countDown(n: Int): Unit = {
    n match {
      case 0 => println("Time OUT !")
      case value => println(value); countDown(n - 1)
    }
  }
  countDown(10)

  /**
   * @param n un entier strictement positif
   * @return le n-ème nombre carré
   */
  // TODO 
  def nombreCarre(n: Int): Int = ???

}