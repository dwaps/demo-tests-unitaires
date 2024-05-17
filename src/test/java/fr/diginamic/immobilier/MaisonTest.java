package fr.diginamic.immobilier;

import fr.diginamic.immobilier.entites.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;

public class MaisonTest {
  private Maison maison;

  @Before
  public void setUp() {
    maison = new Maison();
  }

  @Test
  public void testAjouterPiece() {
    assertEquals(0, maison.nbPieces());

    maison.ajouterPiece(new Chambre(1, 20.0));
    maison.ajouterPiece(new Cuisine(0, 15.0));
    maison.ajouterPiece(new SalleDeBain(1, 8.0));

    assertEquals(3, maison.nbPieces());
  }

  @Test
  public void testCalculerSurface() {
    assertEquals(0.0, maison.calculerSurface(), 0.001);

    maison.ajouterPiece(new Chambre(1, 20.0));
    maison.ajouterPiece(new Cuisine(0, 15.0));
    maison.ajouterPiece(new SalleDeBain(1, 8.0));

    assertEquals(43.0, maison.calculerSurface(), 0.001);
  }

  @Test
  public void testSuperficieEtage() {
    assertEquals(0.0, maison.superficieEtage(1), 0.001);

    maison.ajouterPiece(new Chambre(1, 20.0));
    maison.ajouterPiece(new Cuisine(0, 15.0));
    maison.ajouterPiece(new SalleDeBain(1, 8.0));

    assertEquals(28.0, maison.superficieEtage(1), 0.001);
  }

  @Test
  public void testSuperficieTypePiece() {
    assertEquals(0.0, maison.superficieTypePiece(Piece.TYPE_CHAMBRE), 0.001);

    maison.ajouterPiece(new Chambre(1, 20.0));
    maison.ajouterPiece(new Cuisine(0, 15.0));
    maison.ajouterPiece(new Chambre(1, 18.0));

    assertEquals(38.0, maison.superficieTypePiece(Piece.TYPE_CHAMBRE), 0.001);
  }

  @Test
  public void testAjouterPieceAvecPieceNull() {
    assertThrows(IllegalArgumentException.class, () -> maison.ajouterPiece(null));
    assertEquals(0, maison.nbPieces());
  }

  @Test
  public void testSuperficieTypePieceAvecTypePieceNull() {
    maison.ajouterPiece(new Chambre(1, 20.0));
    maison.ajouterPiece(new Cuisine(0, 15.0));
    assertEquals(0.0, maison.superficieTypePiece(null), 0.001);
  }
}
