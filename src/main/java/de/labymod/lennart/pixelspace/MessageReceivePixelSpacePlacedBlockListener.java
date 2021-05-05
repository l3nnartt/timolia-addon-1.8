package de.labymod.lennart.pixelspace;

import de.labymod.lennart.TimoliaAddon;
import net.labymod.api.events.MessageReceiveEvent;
import net.labymod.core.LabyModCore;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MovingObjectPosition;
import java.util.Map;

public class MessageReceivePixelSpacePlacedBlockListener implements MessageReceiveEvent {

    private String farbe = null;

    @Override
    public boolean onReceive(String s, String msg) {
        if (TimoliaAddon.getInstance().isEnabledPxlSpaceStats()) {
            if (msg.contains("Timolia» Du hast einen Block platziert! In 20 Sekunden kannst du den nächsten bauen!")) {
                getBlockColor();
                System.out.println(farbe);
            }
        } else {
            return false;
        } return false;

    }

    private void getBlockColor() {
        MovingObjectPosition movingObjectPosition = LabyModCore.getMinecraft().getPlayer().rayTrace(10, 1.0F);
        BlockPos blockPos = movingObjectPosition.getBlockPos();
        IBlockState iblockstate = Minecraft.getMinecraft().theWorld.getBlockState(blockPos);

        for (Map.Entry<IProperty, Comparable> entry : iblockstate.getProperties().entrySet()) {
            String s = entry.getValue().toString();

            if (entry.getValue() == Boolean.TRUE) {
                s = EnumChatFormatting.GREEN + s;
            } else if (entry.getValue() == Boolean.FALSE) {
                s = EnumChatFormatting.RED + s;
            }
            farbe = s;
        }
    }

}