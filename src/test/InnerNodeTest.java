/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import representation.InnerNode;
import representation.Event;

/**
 * 
 */
class InnerNodeTest {

	@Test
    void testDisplay() {
        // Création d'un objet InnerNode pour le test
        InnerNode in = new InnerNode(1, "Test description");

        // Capture la sortie standard
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Appelle la méthode display
        in.display();

        // Restaure la sortie standard
        System.setOut(System.out);

        // Vérifie que la sortie affichée correspond à la description du nœud
        assertEquals("Test description\n", outputStream.toString());
    }

     @Test
     void testGetDescription() {
         // Création d'un objet InnerNode pour le test
         InnerNode in = new InnerNode(1, "Test description");

         // Vérifie que la méthode getDescription renvoie la description correcte
         assertEquals("Test description", in.getDescription());
     }

     @Test
     void testSetDescription() {
         // Création d'un objet InnerNode pour le test
         InnerNode in = new InnerNode(1, "Test description");

         // Modifie la description
         in.setDescription("New description");

         // Vérifie que la méthode setDescription a correctement modifié la description
         assertEquals("New description", in.getDescription());
     }

     @Test
     void testEquals() {
         // Création de deux objets InnerNode identiques
         InnerNode in1 = new InnerNode(1, "Test description");
         InnerNode in2 = new InnerNode(1, "Test description");

         // Vérifie que les deux objets sont égaux
         assertTrue(in1.equals(in2));
     }

     @Test
     void testChooseNext() {
         // Création d'un objet InnerNode pour le test (utiliser une sous-classe concrète si nécessaire)
         InnerNode in = new InnerNode(1, "Test description");
         InnerNode in2 = new InnerNode(1, "Test description");
         in.setNextNodes(Arrays.asList(in2));

         // Appelle la méthode chooseNext
         Event nextEvent = in.chooseNext();

         // Vérifie que l'événement suivant n'est pas nul
         assertNotNull(nextEvent);
     }

}
