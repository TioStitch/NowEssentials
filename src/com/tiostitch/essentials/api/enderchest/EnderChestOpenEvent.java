package com.tiostitch.essentials.api.enderchest;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EnderChestOpenEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Player player;

    public EnderChestOpenEvent(Player player) {
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
