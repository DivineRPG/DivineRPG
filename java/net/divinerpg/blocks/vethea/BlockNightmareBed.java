package net.divinerpg.blocks.vethea;

import java.util.Iterator;
import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.dimensions.vethea.TeleporterVethea;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.TwilightBlocks;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockNightmareBed extends BlockBed {
	
	@SideOnly(Side.CLIENT)
    private IIcon[] top;
	@SideOnly(Side.CLIENT)
    private IIcon[] end;
    @SideOnly(Side.CLIENT)
    private IIcon[] side;
    
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
                    
                    EntityPlayer.EnumStatus enumstatus = player.sleepInBedAt(x, y, z);
                    func_149979_a(world, x, y, z, false);
                    MPPlayer.setSpawnChunk(new ChunkCoordinates(x, y + 1, z), true);
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
            	MPPlayer.mcServer.getConfigurationManager().transferPlayerToDimension(MPPlayer, 0, new TeleporterVethea(MPPlayer.mcServer.worldServerForDimension(ConfigurationHelper.vethea)));
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
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        if (side == 0) {
            return TwilightBlocks.mortumBlock.getBlockTextureFromSide(side);
        }
        else {
            int k = getDirection(meta);
            int l = Direction.bedDirection[k][side];
            int i1 = isBlockHeadOfBed(meta) ? 1 : 0;
            return (i1 != 1 || l != 2) && (i1 != 0 || l != 3) ? (l != 5 && l != 4 ? top[i1] : this.side[i1]) : end[i1];
        }
    }

	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        top = new IIcon[] {register.registerIcon(Reference.PREFIX + "bedFeetTop"), register.registerIcon(Reference.PREFIX + "bedHeadTop")};
        end = new IIcon[] {register.registerIcon(Reference.PREFIX + "bedFeetEnd"), register.registerIcon(Reference.PREFIX + "bedHeadEnd")};
        side = new IIcon[] {register.registerIcon(Reference.PREFIX + "bedFeetSide"), register.registerIcon(Reference.PREFIX + "bedHeadSide")};
    }
}
