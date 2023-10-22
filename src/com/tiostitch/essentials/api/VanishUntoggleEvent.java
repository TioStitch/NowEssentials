package com.tiostitch.essentials.api;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class VanishUntoggleEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Player player;

    public VanishUntoggleEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}