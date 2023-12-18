package com.example.snakeGame;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class MusicPlayer extends Thread
{

	private String filename;
	public static Player player;
	static boolean playing = true;

	public MusicPlayer(String filename)
	{
		this.filename = filename;
	}

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



	public static void getMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}

	public static void stopPlaying() {
		playing = false;
		player.close();
	}



}


