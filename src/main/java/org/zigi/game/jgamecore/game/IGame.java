package org.zigi.game.jgamecore.game;

public interface IGame {

	public boolean isRunning();

	public void start() throws Exception;

	public void stop();

	public void reset();

	public boolean isValid();

	public void move();

	public void save();

	public void load();
}
