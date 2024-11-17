package net.divinerpg.blocks.arcana;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.dimensions.arcana.TeleporterArcana;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockArcanaPortal extends BlockMod {
    private int firetick;
    private int firemax = 200;

    public BlockArcanaPortal(String name) {
        super(EnumBlockType.PORTAL, name, 5.0F);
        setLightLevel(1.0F);
        setBlockUnbreakable();
        setResistance(6000000F);
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isReplaceable(IBlockAccess w, int x, int y, int z) {
        return false;
    }

    @Override
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB mask, List list, Entity collidingEntity) {}

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public void dropBlockAsItemWithChance(World worldIn, int x, int y, int z, int meta, float chance, int fortune) {

    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
            if (thePlayer.timeUntilPortal > 0)
                thePlayer.timeUntilPortal = 10;
            else if (thePlayer.dimension != ConfigurationHelper.arcana) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, ConfigurationHelper.arcana, new TeleporterArcana(thePlayer.mcServer.worldServerForDimension(ConfigurationHelper.arcana)));
                thePlayer.triggerAchievement(DivineRPGAchievements.whatLiesWithin);
            } else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterArcana(thePlayer.mcServer.worldServerForDimension(0)));
            }
        }
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        int startX = x;
        int startZ = z;

        if (block == ArcanaBlocks.arcanaPortalFrame) {
            /* Find upper left hand corner of portal */
            while (world.getBlock(startX - 1, y, startZ) == this)
                startX--;
            while (world.getBlock(startX, y, startZ - 1) == this)
                startZ--;

            /* Replace portal blocks with air */
            for (int scanZ = startZ; scanZ < startZ + 3; scanZ++) {
                for (int scanX = startX; scanX < startX + 3; scanX++) {
                    if (world.getBlock(scanX, y, scanZ) == this) {
                        world.setBlockToAir(scanX, y, scanZ);
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
        double distanceX = x + rand.nextFloat();
        double distanceY = y + 0.8F;
        double distanceZ = z + rand.nextFloat();
        world.spawnParticle("smoke", distanceX, distanceY, distanceZ, 0, 0, 0);
    }
}
