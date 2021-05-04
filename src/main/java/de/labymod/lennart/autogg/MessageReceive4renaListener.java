package de.labymod.lennart.autogg;

import de.labymod.lennart.TimoliaAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;

public class MessageReceive4renaListener implements MessageReceiveEvent {
    @Override
    public boolean onReceive(String s, String s1) {

        if (!TimoliaAddon.getInstance().isArena()) return false;
        if (Minecraft.getMinecraft().thePlayer.inventory.hasItem(Item.getItemById(345)) || Minecraft.getMinecraft().thePlayer.inventory.hasItem(Item.getItemById(347))) return false;
        if (!TimoliaAddon.getInstance().isEnabledAutoGG4rena()) return false;

        if (s1.contains("4rena") && s1.contains("»")) {
            if (s1.contains("Team") && s1.contains("gewinnt diese Runde")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage("@" + TimoliaAddon.getInstance().getMatch4rena());
            }
            else if (s1.contains("gewinnt diese Runde")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(TimoliaAddon.getInstance().getMatch4rena());
            }
        }

        if (TimoliaAddon.getInstance().isArena()) {
            if (s1.contains("Noch") && s1.contains("bis zum nächsten Rang!")) {
                Minecraft.getMinecraft().thePlayer.sendChatMessage(TimoliaAddon.getInstance().getGame4rena());
            }
        }
        return false;
    }
}