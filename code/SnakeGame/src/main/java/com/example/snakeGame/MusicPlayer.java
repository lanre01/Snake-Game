package com.example.snakeGame;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * Controls the music played in the game
 */
public class MusicPlayer extends Thread
{
	public String filename;
	public static Player player;
	static boolean playing = true;

	/**
	 * Used to get the file path of the music file.
	 * @param filename is the path of the music file
	 */
	public MusicPlayer(String filename)
	{
		this.filename = filename;
	}

	/**
	 * Used to play the music.
	 * It plays the music continuously until it is stop or the game ends
	 */
	public void play()
	{
		new Thread()
		{
			@Override
			public void run() {
				super.run();
				while(playing) {
					try {
						player = new Player(new BufferedInputStream(new FileInputStream(filename)));
						player.play();

					} catch (Exception e)
					{
						System.out.println(e);
					}
				}

			}
		}.start();
	}


	/**
	 * Used to get the file path and use the play() method to play the music.
	 * @param filename is the filepath of the music
	 */
	public static void getMusicPlay(String filename) {
		playing = true;
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}

	/**
	 * Used to stop the game from playing.
	 * It sets the playing to false which causes the loop to end in the play() method.
	 */
	public static void stopPlaying() {
		playing = false;
		player.close();
	}



}


