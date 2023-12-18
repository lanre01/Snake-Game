package com.example.snakeGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MusicPlayerTest {
    @Test
    void testIfFileNameIsSet() {
        MusicPlayer musicPlayer = new
                MusicPlayer("src/main/resources/com/example/snakeGame/Music/frogger.mp3");

        assertEquals("src/main/resources/com/example/snakeGame/Music/frogger.mp3", musicPlayer.filename);
    }
}