package net.divinerpg.api.blocks.portal;

import java.util.Random;

import net.divinerpg.DivineRPGAchievements;
import net.divinerpg.Reference;
import net.divinerpg.api.blocks.BlockModFire;
import net.divinerpg.api.worldgen.DivineTeleporter;
import net.divinerpg.entity.twilight.effects.EntityGreenPortalFX;
import net.divinerpg.helper.config.ConfigurationHelper;
import net.divinerpg.helper.tabs.DivineRPGTabs;
import net.divinerpg.helper.utils.LangRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockModPortal extends BlockBreakable {

    public static final int[][] sides = new int[][] { new int[0], { 3, 1 }, { 2, 0 } };
    protected String            name;
    protected int               dimensionID;
    protected Block             fireBlock, blockFrame;
    

    public BlockModPortal(String name, int dimensionID, Block fireBlock, Block blockField) {
        super(Reference.PREFIX + name, Material.portal, false);
        this.name = name;
        this.dimensionID = dimensionID;
        this.fireBlock = fireBlock;
        this.blockFrame = blockField;
        setBlockName(name);
        setBlockTextureName(Reference.PREFIX + name);
        setCreativeTab(DivineRPGTabs.blocks);
        setTickRandomly(true);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
        ((BlockModFire)fireBlock).addPortal(this);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int xPos, int yPos, int zPos, Entity entity) {
        if ((entity.ridingEntity == null) && (entity.riddenByEntity == null) && ((entity instanceof EntityPlayerMP))) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 10;
            }
            else if (thePlayer.dimension != dimensionID) {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, dimensionID, new DivineTeleporter(thePlayer.mcServer.worldServerForDimension(dimensionID), dimensionID, this, blockFrame));
                if(thePlayer.dimension == ConfigurationHelper.iceika)
                	thePlayer.triggerAchievement(DivineRPGAchievements.frozenLand);
               
                if(thePlayer.dimension == ConfigurationHelper.mortum)
                	thePlayer.triggerAchievement(DivineRPGAchievements.darkAnotherDay);
                
                if(thePlayer.dimension == ConfigurationHelper.eden)
                	thePlayer.triggerAchievement(DivineRPGAchievements.possibilities);
                
            } else {
                thePlayer.timeUntilPortal = 10;
                thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new DivineTeleporter(thePlayer.mcServer.worldServerForDimension(0), 0, this, blockFrame));
            }
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        super.updateTick(world, x, y, z, rand);

        if (world.provider.isSurfaceWorld() && world.getGameRules().getGameRuleBooleanValue("doMobSpawning") && rand.nextInt(2000) < world.difficultySetting.getDifficultyId()) {
            int l = y;
            while (!World.doesBlockHaveSolidTopSurface(world, x, y, z) && l > 0)
                l--;

            if (l > 0 && !world.getBlock(x, l + 1, z).isNormalCube()) {
                Entity entity = ItemMonsterPlacer.spawnCreature(world, 57, (double) x + 0.5D, (double) l + 1.1D, (double) z + 0.5D);

                if (entity != null)
                    entity.timeUntilPortal = entity.getPortalCooldown();
            }
        }
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int xPos, int yPos, int zPos) {
        int meta = getMeta(blockAccess.getBlockMetadata(xPos, yPos, zPos));

        if (meta == 0) {
            if (blockAccess.getBlock(xPos - 1, yPos, zPos) != this && blockAccess.getBlock(xPos + 1, yPos, zPos) != this) meta = 2;
            else meta = 1;

            if (blockAccess instanceof World && !((World) blockAccess).isRemote)
                ((World) blockAccess).setBlockMetadataWithNotify(xPos, yPos, zPos, meta, 2);
        }

        float f = 0.125F;
        float f1 = 0.125F;

        if (meta == 1)
            f = 0.5F;

        if (meta == 2)
            f1 = 0.5F;

        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f1, 0.5F + f, 1.0F, 0.5F + f1);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    public boolean hasPortalSizeChanged(World world, int xPos, int yPos, int zPos) {
        PortalSize size = new PortalSize(world, xPos, yPos, zPos, 1, this, fireBlock, blockFrame);
        PortalSize size1 = new PortalSize(world, xPos, yPos, zPos, 2, this, fireBlock, blockFrame);

        if (size.isInChunk() && (size.value == 0)) {
            size.setPortalSize();
            return true;
        }
        if (size1.isInChunk() && size1.value == 0) {
            size1.setPortalSize();
            return true;
        }
        return false;
    }

    @Override
    public void onNeighborBlockChange(World world, int xPos, int yPos, int zPos, Block block) {
        int w = getMeta(world.getBlockMetadata(xPos, yPos, zPos));
        PortalSize size = new PortalSize(world, xPos, yPos, zPos, 1, this, fireBlock, blockFrame);
        PortalSize size1 = new PortalSize(world, xPos, yPos, zPos, 2, this, fireBlock, blockFrame);

        if (w == 1 && (!size.isInChunk() || size.value < size.rotationOrMaybeNumSides * size.directionOrSideMaybe)) world.setBlock(xPos, yPos, zPos, Blocks.air);
        else if (w == 2 && (!size1.isInChunk() || size1.value < size1.rotationOrMaybeNumSides * size1.directionOrSideMaybe)) world.setBlock(xPos, yPos, zPos, Blocks.air);
        else if (w == 0 && !size.isInChunk() && !size1.isInChunk())
            world.setBlock(xPos, yPos, zPos, Blocks.air);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int xPos, int yPos, int zPos, int side) {
        int i1 = 0;

        if (blockAccess.getBlock(xPos, yPos, zPos) == this) {
            i1 = getMeta(blockAccess.getBlockMetadata(xPos, yPos, zPos));
            if (i1 == 0 || (i1 == 1 && side != 3 && side != 2) || (i1 == 2 && side != 5 && side != 4)) return false;
        }

        boolean flag = blockAccess.getBlock(xPos - 1, yPos, zPos) == this && blockAccess.getBlock(xPos - 2, yPos, zPos) != this;
        boolean flag1 = blockAccess.getBlock(xPos + 1, yPos, zPos) == this && blockAccess.getBlock(xPos + 2, yPos, zPos) != this;
        boolean flag2 = blockAccess.getBlock(xPos, yPos, zPos - 1) == this && blockAccess.getBlock(xPos, yPos, zPos - 2) != this;
        boolean flag3 = blockAccess.getBlock(xPos, yPos, zPos + 1) == this && blockAccess.getBlock(xPos, yPos, zPos + 2) != this;
        boolean flag4 = flag || flag1 || i1 == 1;
        boolean flag5 = flag2 || flag3 || i1 == 2;
        return flag4 && side == 4 ? true : (flag4 && side == 5 ? true : (flag5 && side == 2 ? true : flag5 && side == 3));
    }

    @Override
    public int quantityDropped(Random rand) {
        return 0;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public int getRenderBlockPass() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(World world, int xPos, int yPos, int zPos, Random rand) {
        for (int l = 0; l < 4; ++l) {
            double d0 = (double) ((float) xPos + rand.nextFloat());
            double d1 = (double) ((float) yPos + rand.nextFloat());
            double d2 = (double) ((float) zPos + rand.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = rand.nextInt(2) * 2 - 1;
            d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;

            if (world.getBlock(xPos - 1, yPos, zPos) != this && world.getBlock(xPos + 1, yPos, zPos) != this) {
                d0 = (double) xPos + 0.5D + 0.25D * (double) i1;
                d3 = (double) (rand.nextFloat() * 2.0F * (float) i1);
            } else {
                d2 = (double) zPos + 0.5D + 0.25D * (double) i1;
                d5 = (double) (rand.nextFloat() * 2.0F * (float) i1);
            }
            EntityGreenPortalFX var20 = new EntityGreenPortalFX(world, d0, d1, d2, d3, d4, d5);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(var20);
        }
    }

    public int getMeta(int meta) {
        return meta & 3;
    }

    public boolean isPortalCorrectSize(World world, int x, int y, int z) {
        return false;
    }


}
