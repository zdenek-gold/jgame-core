package org.zigi.game.jgamecore.player;

public class Player {
	private static int playerIndex = 1;
	private String name;

	public Player() {
		this.name = getRandomName();
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	private static String getRandomName() {
		return "Player" + playerIndex++;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValid() {
		return false;
	}
}
