package org.zigi.game.jgamecore.player;

import java.util.ArrayList;
import java.util.List;

public class PlayerCollection {

	private List<Player> players = new ArrayList<Player>();
	private Player active = null;

	private PlayerCollection() {

	}

	private String getRandomName() {
		return "Player" + players.size() + 1;
	}

	public static PlayerCollection getInstance() {
		return new PlayerCollection();
	}

	public void addPlayer() {
		players.add(new Player());
	}

	public void removePlayer(Player p) {
		if (p == null || !players.contains(p))
			return;
		// TODO doplnit chování
	}

	public Player nextPlayer() {
		Player p = getActive();
		if (p == null)
			return null;

		int idx = players.indexOf(p);
		idx = (idx + 1) % players.size();
		return players.get(idx);
	}

	public Player getActive() {
		if (active == null && !players.isEmpty())
			active = players.get(0);
		return active;

	}

	public class Player {
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

		public void setName(String name) {
			this.name = name;
		}

		public Integer getOrder() {
			if (players.contains(this))
				return players.indexOf(this);
			return null;
		}
	}
}
