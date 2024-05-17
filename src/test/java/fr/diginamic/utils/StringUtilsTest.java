package fr.diginamic.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class StringUtilsTest {

  @Test
  public void testLevenshteinDistance() {
    assertEquals(0, StringUtils.levenshteinDistance("kitten", "kitten"));
    assertEquals(3, StringUtils.levenshteinDistance("kitten", "sitting"));

    assertEquals(1, StringUtils.levenshteinDistance("book", "books"));
    assertEquals(1, StringUtils.levenshteinDistance("book", "cook"));
    assertEquals(1, StringUtils.levenshteinDistance("book", "boo"));

    assertThrows(NullPointerException.class, () -> StringUtils.levenshteinDistance(null, "test"));
    assertThrows(NullPointerException.class, () -> StringUtils.levenshteinDistance("test", null));
    assertThrows(NullPointerException.class, () -> StringUtils.levenshteinDistance(null, null));
  }
}
