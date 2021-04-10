package de.labymod.lennart.modules;

import de.labymod.lennart.addon;
import de.labymod.lennart.pvp.MessageEnemyReceiveListener;
import net.labymod.ingamegui.ModuleCategory;
import net.labymod.ingamegui.moduletypes.SimpleModule;
import net.labymod.settings.elements.ControlElement;
import net.minecraft.util.ResourceLocation;

public class Enemy extends SimpleModule {

    @Override
    public ModuleCategory getCategory() {
        return addon.INSTANCE.timolia;
    }

    @Override
    public String getDisplayName() {
        return "Enemy";
    }

    @Override
    public String getDisplayValue() {
        return MessageEnemyReceiveListener.enemy;
    }

    @Override
    public String getDefaultValue() {
        return "???";
    }

    @Override
    public ControlElement.IconData getIconData() {
        return new ControlElement.IconData(new ResourceLocation("icons/timolia/enemy128.png"));
    }

    @Override
    public void loadSettings() {
    }

    @Override
    public String getSettingName() {
        return "Enemy Name/s";
    }

    @Override
    public String getControlName() {
        return getSettingName();
    }

    @Override
    public String getDescription() {
        return "Displays the name of the enemy/s";
    }

    @Override
    public int getSortingId() {
        return 0;
    }
}