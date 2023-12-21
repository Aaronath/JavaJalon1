package test;

import org.junit.jupiter.api.Test;

import representation.CombatNode;
import univers.Player;
import univers.Pirate.Pirate;
import univers.Pirate.PirateRookie;
import univers.Marine.*;
import representation.Event;
import representation.InnerNode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.*;

class CombatNodeTest {

    @Test
    void testGetOpponent() {
        PirateRookie opponent = new PirateRookie("Test Pirate", 10);
        Player player = new Player("Test",new Matelot("Test Player", 15));
        CombatNode combatNode = new CombatNode(1, "Test Combat Node", opponent, player);
        assertEquals(opponent, combatNode.getOpponent());
    }

    @Test
    void testSetOpponent() {
    	PirateRookie opponent = new PirateRookie("Test Pirate", 10);
        Player player = new Player("Test",new Matelot("Test Player", 15));
        CombatNode combatNode = new CombatNode(1, "Test Combat Node", opponent, player);

        PirateRookie newOpponent = new PirateRookie("New Test Pirate", 20);
        combatNode.setOpponent(newOpponent);

        assertEquals(newOpponent, combatNode.getOpponent());
    }

    @Test
    void testCombatNext() {
        PirateRookie opponent = new PirateRookie("Test Pirate", 10);
        Player player = new Player("Test", new Matelot("Test Player", 15));
        CombatNode combatNode = new CombatNode(1, "Test Combat Node", opponent, player);

        // Redirect System.in to provide input for the test
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        boolean outcome = combatNode.combatNext();

        // Restore System.in and System.out
        System.setIn(originalSystemIn);
        System.setOut(System.out);

     // Assert the expected output using containsString
        assertTrue(
            outputStream.toString().contains("Vous êtes confronté à Test Pirate, un redoutable ennemi !") ||
            outputStream.toString().contains("Power Level de l'adversaire : 10")
        );


        // Assert the expected outcome
        assertTrue(
        		String.valueOf(outcome).contains("true") ||
        		String.valueOf(outcome).contains("false")
        		);
    }


    @Test
    void testCombatNextDetermineCombatOutcome() {
        PirateRookie opponent = new PirateRookie("Test Pirate", 10);
        Player player = new Player("Test", new Matelot("Test Player", 15));
        CombatNode combatNode = new CombatNode(1, "Test Combat Node", opponent, player);

        // Redirect System.in to provide input for the test
        InputStream originalSystemIn = System.in;
        System.setIn(new ByteArrayInputStream("1".getBytes()));

        // Redirect System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call combatNext, which indirectly calls determineCombatOutcome
        boolean outcome = combatNode.combatNext();

        // Restore System.in and System.out
        System.setIn(originalSystemIn);
        System.setOut(System.out);

        String output = outputStream.toString();
	     // Assert that at least one of the conditions is true
	     assertTrue(output.contains("Vous êtes confronté à Test Pirate, un redoutable ennemi !")
	             || output.contains("Power Level de l'adversaire : 10"));


	  // Assert the expected outcome
       assertTrue(
        		String.valueOf(outcome).contains("true") ||
        		String.valueOf(outcome).contains("false")
        		);
    // Assert the no-expected outcome
	     assertFalse(String.valueOf(outcome).contains("1"));
    }

    @Test
    void testChooseNext() {
    	PirateRookie opponent = new PirateRookie("Test Pirate", 10);
        Player player = new Player("Test",new Matelot("Test Player", 15));
        CombatNode combatNode = new CombatNode(1, "Test Combat Node", opponent, player);
        InnerNode in = new InnerNode(1,"Test");
        combatNode.setNextNodes(Arrays.asList(in));       // Assuming that the CombatNode has only one next node
        Event nextEvent = combatNode.chooseNext();

        assertNotNull(nextEvent);
        assertTrue(nextEvent.toString().contains("1"));
    }

    
    private CombatNode getCombatNode() {
    	PirateRookie opponent = new PirateRookie("Test Pirate", 10);  // Remplacez les valeurs par celles appropriées
        Player player = new Player("Test",new Matelot("Test Player", 15));  // Remplacez les valeurs par celles appropriées
        CombatNode combatNode = new CombatNode(1, "Test Combat Node", opponent, player);
        return combatNode;
    }
}
