package fr.istic.si2.tp4.exoImages

import fr.istic.si2.scribble._
import scala.annotation.tailrec

object ExosImages extends App {

  /**
   * Couleurs utilisées pour faire l'immeuble
   */
  val orange: Color = Color(255, 165, 0, 255)
  val limegreen: Color = Color(50, 205, 50, 255)

  /**
   * @param c une couleur
   * @param i une image dont les couleurs de ligne et de remplissage ne sont pas définies
   * @return l'image i coloriée entièrement (bord et intérieur) de la couleur c
   */
  def solid(c: Color, i: Image): Image = {
    lineColor(fillColor(i, c), c)
  }

  /**
   * Image du toit
   */
  val toit: Image = solid(orange, besideAlign(Bottom, Triangle(31), Triangle(20)))

  /**
   * Image de l'étage
   */
  val etage: Image = {
    val r1: Image = solid(TRANSPARENT, Rectangle(5, 10))
    val fenetre: Image = Rectangle(10, 12)
    val r3: Image = solid(TRANSPARENT, Rectangle(20, 10))
    val facade: Image = fillColor(Rectangle(50, 20), limegreen)

    on(beside(r1, fenetre, r3, fenetre, r1), facade)
  }

  /**
   * @param n un entier positif ou nul
   * @return image d'un immeuble à n étages, surmonté d'un toit
   */

  def immeuble(n: Int): Image = {
    n match {
      case 0 => below(toit)
      case _ => below(immeuble(n - 1), etage)
    }
  }

  //  draw(immeuble(0))
  //  draw(immeuble(1))
  //  draw(immeuble(2))
  //  draw(immeuble(3))

  /**
   * Image de perle pour le motif de base du collier
   */
  val perle = FromFile("img/perle.png")

  /**
   * @param n un entier positif ou nul
   * @return image de collier horizontal de n perles
   */
  def collierPerles(n: Int): Image = {
    n match {
      case 0 => beside(perle)
      case _ => beside(collierPerles(n - 1), perle)
    }
  }

  //  draw(collierPerles(0))
  //  draw(collierPerles(1))
  //  draw(collierPerles(2))
  //  draw(collierPerles(3))

  /**
   * @param n un entier strictement positif
   * @return image d'un anneau rouge de rayon n
   */
  def anneau(n: Int): Image = {
    lineColor(Circle(10 * n), RED)
  }

  /**
   * @param n un entier positif ou nul
   * @return image de n cercles concentriques de plus en plus grands
   */
  def anneaux(n: Int): Image = {
    n match {
      case 0 => on(anneau(0))
      case _ => on(anneaux(n - 1), anneau(n))
    }
  }

  //  draw(anneaux(5))

  /**
   * Boules utilisées pour la guirlande
   */
  val boule_rouge: Image = solid(RED, Circle(20))
  val boule_noire: Image = solid(BLACK, Circle(20))

  /**
   * @param n un entier positif ou nul
   * @return image d'une guirlande horizontale de 2 * n boules de couleurs, en alternant boules rouges et boules noires
   */
  def guirlande(n: Int): Image = {
    n match {
      case 0 => beside(boule_rouge, boule_noire)
      case _ => beside(guirlande(n - 1), beside(boule_rouge, boule_noire))
    }
  }
  draw(guirlande(0))
  draw(guirlande(1))
  draw(guirlande(2))
  draw(guirlande(3))

  /**
   * @param n un entier positif ou nul
   * @return image d'une guirlande horizontale de n boules de couleurs, en alternant boules rouges et noires, en commençant par une boule rouge
   */
  // TODO  
  def guirlandeBis(n: Int): Image = ???

}