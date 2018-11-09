package org.zigi.game.jgamecore.game;

public abstract class Game implements IGame {

	protected long startTime = 0;
	protected int moves = 0;
	protected boolean isRunning = false;

	public void start() throws Exception {
		if (isValid() == false)
			throw new Exception("Invalid game state");
		else {
			startTime = System.nanoTime();
			isRunning = true;
		}
	}

	public void stop() {
		isRunning = false;
	}

	public void reset() {
		moves = 0;
		startTime = 0;
		isRunning = false;
	}

	public long getDuration() {
		if (startTime == 0)
			return 0;
		return System.nanoTime() - startTime;
	}

	public int getMoves() {
		return moves;
	}

	public void move() {
		moves++;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public abstract void save();

	public abstract void load();
}
