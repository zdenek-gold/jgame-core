package org.zigi.game.jgamecore.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PlayerCollection<T extends Player> implements Collection<T> {

	private List<T> players = new ArrayList<T>();
	private int activeIndex = 0;

	public PlayerCollection() {

	}

	public Integer getOrder(Player player) {
		if (players.contains(player))
			return players.indexOf(player);
		return null;
	}

	private int getActiveIndex() {
		return activeIndex;
	}

	public T nextActive() {
		if (players.isEmpty())
			return null;

		activeIndex = (getActiveIndex() + 1) % players.size();
		return getActive();
	}

	public T getActive() {
		if (players.isEmpty())
			return null;
		return players.get(activeIndex);
	}

	public boolean add(T player) {
		if (players.contains(player))
			return false;
		players.add(player);
		return true;
	}

	public boolean addAll(Collection<? extends T> player) {
		if (player == null)
			return false;

		boolean isValid = true;
		for (T p : player) {
			isValid &= add(p);
		}
		return isValid;
	}

	public void clear() {
		players.clear();
		activeIndex = 0;
	}

	public boolean contains(Object player) {
		return players.contains(player);
	}

	public boolean containsAll(Collection<?> player) {
		for (Object o : player)
			if (!players.contains(o))
				return false;
		return true;
	}

	public boolean isEmpty() {
		return players.isEmpty();
	}

	public Iterator<T> iterator() {
		return players.iterator();
	}

	public boolean removeAll(Collection<?> players) {
		if (players == null)
			return false;

		boolean isValid = true;
		for (Object player : players) {
			isValid &= remove(player);
		}
		return isValid;
	}

	public boolean retainAll(Collection<?> player) {
		return players.retainAll(player);
	}

	public int size() {
		return players.size();
	}

	public Object[] toArray() {
		return players.toArray();
	}

	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] player) {
		return players.toArray(player);
	}

	public boolean remove(Object player) {
		if (player == null || !players.contains(player))
			return false;

		int index = players.indexOf(player);
		if (players.size() == 1) {
			clear();
		} else if (index < activeIndex) {
			activeIndex -= 1;
			players.remove(player);
		} else if (index > activeIndex) {
			players.remove(player);
		} else {
			T next = players.get((activeIndex + 1) % players.size());
			players.remove(player);
			activeIndex = players.indexOf(next);
		}
		return true;
	}
}
