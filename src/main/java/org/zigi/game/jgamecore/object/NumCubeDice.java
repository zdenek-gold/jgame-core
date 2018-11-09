package org.zigi.game.jgamecore.object;

/**
 * Třída reprezentující šestistrannou hrací kostku
 * 
 * @author zigi
 *
 */
public class NumCubeDice extends CubeDice<Integer> {

	private NumCubeDice() {
		initDefault();
	}

	/**
	 * Rozložení čísel na jednotlivých stranách kostky
	 */
	private void initDefault() {
		clear();
		addValue(6);
		addValue(4);
		addValue(5);
		addValue(3);
		addValue(1);
		addValue(2);
	}

	public static NumCubeDice getInstance() {
		return new NumCubeDice();
	}
}
