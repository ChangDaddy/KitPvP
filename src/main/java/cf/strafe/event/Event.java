package cf.strafe.event;

import cf.strafe.data.PlayerData;
import cf.strafe.utils.ColorUtil;
import lombok.Getter;
import org.apache.commons.lang.StringUtils;
import org.bukkit.event.Listener;

import java.util.ArrayList;

@Getter
public abstract class Event {

    public PlayerData host;
    public ArrayList<PlayerData> players = new ArrayList<>();
    public ArrayList<PlayerData> spectators = new ArrayList<>();

    public State state;
    public int gameTime, maxPlayers;

    public Event() { }

    public abstract void update();

    public void addPlayer(PlayerData player) {
        if (state == State.WAITING) {
            if (!players.contains(player)) {
                players.add(player);
                player.getPlayer().sendMessage(ColorUtil.translate("&aYou have joined the event!"));
            }
        } else {
            if (!spectators.contains(player)) {
                spectators.add(player);
                player.getPlayer().sendMessage(ColorUtil.translate("&eYou are now spectating the event!"));
            }
        }
    }

    public void removePlayer(PlayerData player) {
        if (players.contains(player)) {
            players.remove(player);
            player.getPlayer().sendMessage(ColorUtil.translate("&cYou have left the event!"));
        }
        if (spectators.contains(player)) {
            spectators.remove(player);
            player.getPlayer().sendMessage(ColorUtil.translate("&cYou have left the event!"));
        }
    }

    public enum State {
        WAITING, INGAME, END;

        public String toString() {
            return StringUtils.capitalize(this.name().toLowerCase());
        }

        public State next() {
            if (values()[ordinal() + 1] == null) { return values()[0]; }
            return values()[ordinal() + 1];
        }

    }

    public enum Type {
        SUMO;

        public String toString() {
            return StringUtils.capitalize(this.name().toLowerCase());
        }
    }

}