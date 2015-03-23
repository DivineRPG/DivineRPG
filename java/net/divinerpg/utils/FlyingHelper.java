package net.divinerpg.utils;

import net.divinerpg.DivineRPG;
import net.divinerpg.network.MessageArcanaBar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class FlyingHelper implements IExtendedEntityProperties {

    private final EntityPlayer player;
    public static final String NAME = "FlyingProps";
    public boolean couldFly;
    
    public FlyingHelper(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public void saveNBTData(NBTTagCompound n) {
    }

    @Override
    public void loadNBTData(NBTTagCompound n) {
    }
    
    public static void addProperties(EntityPlayer player) {
        player.registerExtendedProperties(NAME, new FlyingHelper(player));
    }
    
    public static FlyingHelper getProperties(EntityPlayer player) {
        return (FlyingHelper) player.getExtendedProperties(NAME);
    }

    @Override
    public void init(Entity entity, World world) {}
}