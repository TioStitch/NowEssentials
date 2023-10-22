package com.tiostitch.essentials.api.enderchest;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class EnderChestOtherOpenEvent extends Event {

    private static HandlerList handlerList = new HandlerList();

    private Player player;
    private Player target;

    public EnderChestOtherOpenEvent(Player player, Player target) {
        this.player = player;
        this.target = target;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getTarget() {
        return target;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}
