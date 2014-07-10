package net.divinerpg.blocks.arcana;

import java.util.List;
import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.dimensions.arcana.TeleporterArcana;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockArcanaPortal extends BlockMod {
    private int firetick;
    private int firemax = 200;

    public BlockArcanaPortal(String name) {
        super(EnumBlockType.PORTAL, name, 5.0F);
        setLightLevel(1.0F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity collidingEntity) {}

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
            EntityPlayerMP thePlayer = (EntityPlayerMP)entity;
            if (thePlayer.timeUntilPortal > 0)
                thePlayer.timeUntilPortal = 10;
            else if (thePlayer.dimension != ConfigurationHelper.arcana) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ConfigurationHelper.arcana, new TeleporterArcana(thePlayer.mcServer.worldServerForDimension(ConfigurationHelper.arcana)));
                thePlayer.triggerAchievement(DivineRPGAchievements.liesWithin);
            } else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterArcana(thePlayer.mcServer.worldServerForDimension(0)));
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand){
        double distanceX = x + rand.nextFloat();
        double distanceY = y + 0.8F;
        double distanceZ = z + rand.nextFloat();
        world.spawnParticle("smoke", distanceX, distanceY, distanceZ, 0, 0, 0);
    }
}