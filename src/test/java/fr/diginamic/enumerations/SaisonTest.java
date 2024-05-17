package fr.diginamic.enumerations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SaisonTest {

  @Test
  public void testValueOfLibelleCasNominaux() {
    assertEquals(Saison.PRINTEMPS, Saison.valueOfLibelle("Printemps"));
    assertEquals(Saison.ETE, Saison.valueOfLibelle("Eté"));
    assertEquals(Saison.AUTOMNE, Saison.valueOfLibelle("Automne"));
    assertEquals(Saison.HIVER, Saison.valueOfLibelle("Hiver"));
  }

  @Test
  public void testValueOfLibelleAvecLibelleVide() {
    assertNull(Saison.valueOfLibelle(""));
  }

  @Test
  public void testValueOfLibelleAvecLibelleNull() {
    assertNull(Saison.valueOfLibelle(null));
  }

}
