package divinerpg.objects.blocks.vethea;

import javax.annotation.Nullable;

import divinerpg.api.java.divinerpg.api.Reference;
import divinerpg.config.Config;
import divinerpg.dimensions.vethea.TeleporterVethea;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.DivineTeleporter;
import divinerpg.utils.Utils;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBed;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class BlockNightmareBed extends BlockBed{
		

    private NBTTagCompound persistantData;
	public BlockNightmareBed() {
        super();
        String name = "nightmare_bed_block";
        this.setUnlocalizedName(name);
        this.setRegistryName(Reference.MODID, name);
        setHardness(9);
        this.setDefaultState(this.blockState.getBaseState().withProperty(PART, BlockNightmareBed.EnumPartType.FOOT).withProperty(OCCUPIED, Boolean.valueOf(false)));
        this.hasTileEntity = false;

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		
		if (world.isRemote)
        {
            return true;
        }
        else
        {
            if (state.getValue(PART) != BlockNightmareBed.EnumPartType.HEAD)
            {
                pos = pos.offset((EnumFacing)state.getValue(FACING));
                state = world.getBlockState(pos);

                if (state.getBlock() != this)
                {
                    return true;
                }
            }

            net.minecraft.world.WorldProvider.WorldSleepResult sleepResult = world.provider.canSleepAt(player, pos);
            if (sleepResult != net.minecraft.world.WorldProvider.WorldSleepResult.BED_EXPLODES)
            {
                
                if (((Boolean)state.getValue(OCCUPIED)).booleanValue())
                {
                    EntityPlayer entityplayer = this.getPlayerInBed(world, pos);

                    if (entityplayer != null)
                    {
                        player.sendStatusMessage(new TextComponentTranslation("tile.bed.occupied", new Object[0]), true);
                        return true;
                    }

                    state = state.withProperty(OCCUPIED, Boolean.valueOf(false));
                    world.setBlockState(pos, state, 4);
                }else
                {
                	if (player.world.provider.getDimension() != Config.vetheaDimensionId) {
                        if (world.getBlockLightOpacity(pos.up()) > 7) {
                            player.sendMessage(Utils.getChatComponent("You can only use the Nightmare Bed in a dark place."));
                            return true;
                        }
                    return true;
                }
                        else
            {
                world.setBlockToAir(pos);
                BlockPos blockpos = pos.offset(((EnumFacing)state.getValue(FACING)).getOpposite());

                if (world.getBlockState(blockpos).getBlock() == this)
                {
                    world.setBlockToAir(blockpos);
                }

                EntityPlayerMP MPPlayer = (EntityPlayerMP) player;
//                EntityPlayer.EnumStatus enumstatus = player.trySleep(pos);
                MPPlayer.timeUntilPortal = 10;
                MPPlayer.mcServer.getPlayerList().transferPlayerToDimension(MPPlayer, Config.vetheaDimensionId,
                        new DivineTeleporter(MPPlayer.mcServer.getWorld(Config.vetheaDimensionId), this));
                this.persistantData.setTag("OverworldInv", player.inventory.writeToNBT(new NBTTagList()));
                player.getEntityData().setTag("PlayerPersisted", this.persistantData);
                player.inventory.clear();
                NBTTagList inv = this.persistantData.getTagList("VetheaInv", 10);
                player.inventory.readFromNBT(inv);
                player.inventoryContainer.detectAndSendChanges();
//                ChunkCoordinates c = new ChunkCoordinates();
//                c.posX = (int) player.posX + 2;
//                c.posY = 18;
//                c.posZ = (int) player.posZ - 2;
//                player.setSpawnChunk(c, true, Config.vetheaDimensionId);
                return true;
            }}}}
		return true;     
    }
	@Nullable
    private EntityPlayer getPlayerInBed(World worldIn, BlockPos pos)
    {
        for (EntityPlayer entityplayer : worldIn.playerEntities)
        {
            if (entityplayer.isPlayerSleeping() && entityplayer.bedLocation.equals(pos))
            {
                return entityplayer;
            }
        }

        return null;
    }
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        BlockPos blockpos = pos;

        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.FOOT)
        {
            blockpos = pos.offset((EnumFacing)state.getValue(FACING));
        }

        TileEntity tileentity = worldIn.getTileEntity(blockpos);
        return new ItemStack(ModItems.nightmareBed);
    }

}
