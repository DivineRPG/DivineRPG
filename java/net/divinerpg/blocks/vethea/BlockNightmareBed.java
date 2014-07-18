package net.divinerpg.blocks.vethea;

import java.util.Iterator;
import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.dimensions.vethea.TeleporterVethea;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockNightmareBed extends BlockBed {
	
	public BlockNightmareBed() {
		super();
        String name = "nightmareBedBlock";
        setStepSound(Block.soundTypeStone);
        setCreativeTab(null);
        setBlockName(name);
        setHardness(9);
        GameRegistry.registerBlock(this, name);
        LangRegistry.addBlock(this);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
        if (world.isRemote)
            return true;
        else {
        	EntityPlayerMP MPPlayer = (EntityPlayerMP) player;
            int i1 = world.getBlockMetadata(x, y, z);

            if (!isBlockHeadOfBed(i1)) {
                int j1 = getDirection(i1);
                x += field_149981_a[j1][0];
                z += field_149981_a[j1][1];

                if (world.getBlock(x, y, z) != this)
                    return true;

                i1 = world.getBlockMetadata(x, y, z);
            }

            if (world.provider.canRespawnHere() && world.getBiomeGenForCoords(x, z) != BiomeGenBase.hell) {
                if (func_149976_c(i1)) {
                    EntityPlayer entityplayer1 = null;
                    Iterator iterator = world.playerEntities.iterator();

                    while (iterator.hasNext()) {
                        EntityPlayer entityplayer2 = (EntityPlayer)iterator.next();

                        if (entityplayer2.isPlayerSleeping()) {
                            ChunkCoordinates chunkcoordinates = entityplayer2.playerLocation;

                            if (chunkcoordinates.posX == x && chunkcoordinates.posY == y && chunkcoordinates.posZ == z)
                                entityplayer1 = entityplayer2;
                        }
                    }

                    if (entityplayer1 != null) {
                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.occupied", new Object[0]));
                        return true;
                    }

                    func_149979_a(world, x, y, z, false);
                    EntityPlayer.EnumStatus enumstatus = player.sleepInBedAt(x, y, z);
                    MPPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(MPPlayer, ConfigurationHelper.vethea, new TeleporterVethea(MPPlayer.mcServer.worldServerForDimension(ConfigurationHelper.vethea)));
                }

                EntityPlayer.EnumStatus enumstatus = player.sleepInBedAt(x, y, z);

                if (enumstatus == EntityPlayer.EnumStatus.OK) {
                    func_149979_a(world, x, y, z, true);
                    player.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_RED, "WARNING! Are you sure you want to enter Vethea; every Minecraft player's worst nightmare?"));
                    player.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "There may be no coming back..."));
                    return true;
                }
                else {
                    if (enumstatus == EntityPlayer.EnumStatus.NOT_POSSIBLE_NOW) {
                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.noSleep", new Object[0]));
                    }
                    else if (enumstatus == EntityPlayer.EnumStatus.NOT_SAFE) {
                        player.addChatComponentMessage(new ChatComponentTranslation("tile.bed.notSafe", new Object[0]));
                    }

                    return true;
                }
            }
            else if (player.worldObj.provider.dimensionId == ConfigurationHelper.vethea) {
            	MPPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(MPPlayer, ConfigurationHelper.vethea, new TeleporterVethea(MPPlayer.mcServer.worldServerForDimension(0)));
            	return true;
            }
            else {
                double d2 = (double)x + 0.5D;
                double d0 = (double)y + 0.5D;
                double d1 = (double)z + 0.5D;
                world.setBlockToAir(x, y, z);
                int k1 = getDirection(i1);
                x += field_149981_a[k1][0];
                z += field_149981_a[k1][1];

                if (world.getBlock(x, y, z) == this) {
                    world.setBlockToAir(x, y, z);
                    d2 = (d2 + (double)x + 0.5D) / 2.0D;
                    d0 = (d0 + (double)y + 0.5D) / 2.0D;
                    d1 = (d1 + (double)z + 0.5D) / 2.0D;
                }

                WorldGenAPI.addRectangle(2, 2, 1, world, x, y - 1, z, TwilightBlocks.mortumBlock);
                //world.newExplosion((Entity)null, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), 5.0F, true, true);
                return true;
            }
        }
    }
	
	@Override
	public Item getItemDropped(int par1, Random rand, int par3) {
		return VetheaItems.nightmareBed;
	}
}
