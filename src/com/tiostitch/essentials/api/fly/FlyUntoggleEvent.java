package com.tiostitch.essentials.api.fly;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class FlyUntoggleEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Player player;

    public FlyUntoggleEvent(Player player) {
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