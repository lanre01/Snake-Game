package com.example.snakeGame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {
    static Model model;
    @BeforeAll
    static void setUp() {
        model = new GameModel();
        model.initialise();
    }

    /**
     * Test 1.1
     */
    @Test
    void testIfPlayerNameIsSet() {
        model.setPlayerName("Lawal");
        assertEquals( "Lawal", model.getPlayerName() );
    }

    /**
     * Test 1.2
     */
    @Test
    void testIfModelSetGameFinished() {
        model.setHasFinished(true);
        assertTrue( model.hasFinished() );
        model.setHasFinished(false);
        assertFalse(model.hasFinished());
    }

    /**
     * Test 1.3
     */
    @Test
    void testIfModelSetHighScore() {
        int highScore = 1000;
        model.setHighScore(highScore);
        assertEquals(highScore, model.getHighScore());
    }

    /**
     * Test 1.4
     */
    @Test
    void testIfModelSetScore() {
        int score = 300;
        model.setScore(score, 1);
        assertEquals(score, model.getScore(1));
        model.setScore(score, 2);
        assertEquals(score, model.getScore(2));
        model.setScore(score, 3);
        assertEquals(score, model.getScore(3));
    }

    /**
     * Test 1.5
     */
    @Test
    void testIfModelSetStart() {
        boolean start = true;
        model.setStart(start);
        assertTrue( model.start());
        start = false;
        model.setStart(start);
        assertFalse(model.start());
    }

    /**
     * Test 1.6
     */
    @Test
    void testIfModelSetLevel() {
        int level = 1;
        model.setLevel(level);
        assertEquals(level, model.getLevel());
        level = 2;
        model.setLevel(level);
        assertEquals(level, model.getLevel());
    }

    /**
     * Test 1.7
     */
    @Test
    void testIfModelReturnsTheCorrectMinScore() {
        int level = 1;
        assertEquals(0,model.getMinimumScore(level));
    }

}