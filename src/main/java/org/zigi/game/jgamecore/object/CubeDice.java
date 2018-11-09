package org.zigi.game.jgamecore.object;

import java.util.ArrayList;

import org.zigi.game.jgamecore.Util;

public abstract class CubeDice<T> implements IDice<T> {
	protected ArrayList<T> values = new ArrayList<T>(MAX_VALUES);
	public static final int MAX_VALUES = 6;

	protected void addValue(T value) {
		if (values.size() < MAX_VALUES)
			values.add(value);
	}

	protected void clear() {
		values.clear();
	}

	public T randomValue() {
		return values.get(Util.RAND.nextInt());
	}
}
