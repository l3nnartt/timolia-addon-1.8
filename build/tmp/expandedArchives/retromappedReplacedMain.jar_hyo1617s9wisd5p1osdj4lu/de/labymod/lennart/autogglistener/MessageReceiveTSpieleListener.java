package de.labymod.lennart.autogglistener;

import de.labymod.lennart.addon;
import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;

public class MessageReceiveTSpieleListener implements MessageReceiveEvent {
    @Override
    public boolean onReceive(String s, String s1) {

        if (!addon.INSTANCE.enabledAutoGGTSpiele) return false;

        if (addon.INSTANCE.tspiele) {
            if (s1.contains("Noch") && s1.contains("bis zum nächsten Rang!")) {
                Minecraft.func_71410_x().field_71439_g.func_71165_d(addon.INSTANCE.gameTSpiele);
            }
        } return false;

    }
}