package divinerpg.objects.blocks.vethea;

import divinerpg.dimensions.vethea.TeleporterVethea;
import divinerpg.dimensions.vethea.TeleporterVetheaToOverworld;
import divinerpg.objects.blocks.tile.entity.TileEntityNightmareBed;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModDimensions;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.NbtUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.DimensionType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.*;

// todo check replacement poses
public class BlockNightmareBed extends BlockHorizontal implements ITileEntityProvider {
    private NBTTagCompound persistentData;

    public static final PropertyEnum<BlockNightmareBed.EnumPartType> PART = PropertyEnum.create("part", BlockNightmareBed.EnumPartType.class);
    public static final PropertyBool OCCUPIED = PropertyBool.create("occupied");
    protected static final AxisAlignedBB BED_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D);

    public BlockNightmareBed() {
        super(Material.CLOTH);
        setDefaultState(this.blockState.getBaseState().withProperty(PART, BlockNightmareBed.EnumPartType.FOOT).withProperty(OCCUPIED, Boolean.valueOf(false)));
        hasTileEntity = true;
        setRegistryName("nightmare_bed_block");
        setUnlocalizedName("nightmare_bed_block");
        setCreativeTab(DivineRPGTabs.vethea);
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return MapColor.CLOTH;
    }

    /**
     * Returns a safe BlockPos to disembark the bed
     */
    @Nullable
    public static BlockPos getSafeExitLocation(World worldIn, BlockPos pos, int tries) {
        EnumFacing enumfacing = worldIn.getBlockState(pos).getValue(FACING);
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();

        for (int l = 0; l <= 1; ++l) {
            int i1 = i - enumfacing.getFrontOffsetX() * l - 1;
            int j1 = k - enumfacing.getFrontOffsetZ() * l - 1;
            int k1 = i1 + 2;
            int l1 = j1 + 2;

            for (int i2 = i1; i2 <= k1; ++i2) {
                for (int j2 = j1; j2 <= l1; ++j2) {
                    BlockPos blockpos = new BlockPos(i2, j, j2);

                    if (hasRoomForPlayer(worldIn, blockpos)) {
                        if (tries <= 0) {
                            return blockpos;
                        }

                        --tries;
                    }
                }
            }
        }

        return null;
    }


    @Nullable
    private EntityPlayer getPlayerInBed(World worldIn, BlockPos pos) {
        for (EntityPlayer entityplayer : worldIn.playerEntities) {
            if (entityplayer.isPlayerSleeping() && entityplayer.bedLocation.equals(pos)) {
                return entityplayer;
            }
        }

        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    /**
     * Block's chance to react to a living entity falling on it.
     */
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        super.onFallenUpon(worldIn, pos, entityIn, fallDistance * 0.5F);
    }

    /**
     * Called when an Entity lands on this Block. This method *must* update motionY because the entity will not do that
     * on its own
     */
    public void onLanded(World worldIn, Entity entityIn) {
        if (entityIn.isSneaking()) {
            super.onLanded(worldIn, entityIn);
        } else if (entityIn.motionY < 0.0D) {
            entityIn.motionY = -entityIn.motionY * 0.6600000262260437D;

            if (!(entityIn instanceof EntityLivingBase)) {
                entityIn.motionY *= 0.8D;
            }
        }
    }

    /**
     * Called when the block is right clicked by a player.
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) return true;
        else {
            EntityPlayerMP MPPlayer = (EntityPlayerMP) playerIn;

            this.persistentData = playerIn.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);

            if (playerIn.world.provider.getDimension() == 0) {
                if (worldIn.getBlockLightOpacity(pos) > 7) {
                    playerIn.sendMessage(LocalizeUtils.getClientSideTranslation(playerIn, "message.nightmare_bed.restrict"));
                    return true;
                }
                EntityPlayer entityplayer1 = null;
                Iterator iterator = worldIn.playerEntities.iterator();

                while (iterator.hasNext()) {
                    EntityPlayer entityplayer2 = (EntityPlayer) iterator.next();

                    if (entityplayer1 != null) {
                        playerIn.sendStatusMessage(new TextComponentTranslation("tile.bed.occupied"), true);
                        return true;
                    }

                    this.persistentData.setTag("OverworldInv", playerIn.inventory.writeToNBT(new NBTTagList()));
                    playerIn.getEntityData().setTag("PlayerPersisted", this.persistentData);
                    playerIn.inventory.clear();
                    NBTTagList inv = this.persistentData.getTagList("VetheaInv", 10);
                    playerIn.inventory.readFromNBT(inv);
                    playerIn.inventoryContainer.detectAndSendChanges();

                    MPPlayer.timeUntilPortal = 10;
                    int oldDimension = playerIn.getEntityWorld().provider.getDimension();
                    EntityPlayerMP entityPlayerMP = (EntityPlayerMP) playerIn;
                    MinecraftServer server = playerIn.getEntityWorld().getMinecraftServer();
                    WorldServer worldServer = server.getWorld(ModDimensions.vetheaDimension.getId());
                    playerIn.addExperienceLevel(0);
                    if (EntityPlayer.getBedSpawnLocation(worldServer, pos, true) == null) {
                        pos = worldServer.getTopSolidOrLiquidBlock(pos);
                    }
                    double x = pos.getX(), y = 17, z = pos.getZ();
                    worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, ModDimensions.vetheaDimension.getId(),
                            new TeleporterVethea(worldServer));

                    playerIn.setPositionAndUpdate(x, y, z);
                    return true;
                }
                return true;
            } else if (playerIn.world.provider.getDimension() == ModDimensions.vetheaDimension.getId()) {
                int oldDimension = playerIn.getEntityWorld().provider.getDimension();
                EntityPlayerMP entityPlayerMP = (EntityPlayerMP) playerIn;
                MinecraftServer server = playerIn.getEntityWorld().getMinecraftServer();
                WorldServer worldServer = server.getWorld(0);
                playerIn.addExperienceLevel(0);

                if (EntityPlayer.getBedSpawnLocation(worldServer, pos, true) == null) {
                    pos = worldServer.getTopSolidOrLiquidBlock(pos);
                }
                double x = pos.getX(), y = pos.getY(), z = pos.getZ();
                worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, 0,
                        new TeleporterVetheaToOverworld(worldServer));
                playerIn.setPositionAndUpdate(x, y, z);
                return true;
            }
        }
        return true;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return state.getValue(PART) == BlockNightmareBed.EnumPartType.FOOT ? Items.AIR : Item.getItemFromBlock(ModBlocks.nightmareBed);
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BED_AABB;
    }

    @SideOnly(Side.CLIENT)
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    /**
     * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
     * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
     * block, etc.
     */
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        EnumFacing enumfacing = state.getValue(FACING);

        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.FOOT) {
            if (worldIn.getBlockState(pos.offset(enumfacing)).getBlock() != this) {
                worldIn.setBlockToAir(pos);
            }
        } else if (worldIn.getBlockState(pos.offset(enumfacing.getOpposite())).getBlock() != this) {
            if (!worldIn.isRemote) {
                this.dropBlockAsItem(worldIn, pos, state, 0);
            }

            worldIn.setBlockToAir(pos);
        }
    }

    @Deprecated
    protected static boolean hasRoomForPlayer(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).isTopSolid() && !worldIn.getBlockState(pos).getMaterial().isSolid() && !worldIn.getBlockState(pos.up()).getMaterial().isSolid();
    }

    /**
     * Spawns this Block's drops into the World as EntityItems.
     */
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.HEAD) {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            spawnAsEntity(worldIn, pos, new ItemStack(ModBlocks.nightmareBed, 1));
        }
    }

    public EnumPushReaction getMobilityFlag(IBlockState state) {
        return EnumPushReaction.DESTROY;
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        BlockPos blockpos = pos;

        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.FOOT) {
            blockpos = pos.offset(state.getValue(FACING));
        }

        TileEntity tileentity = worldIn.getTileEntity(blockpos);
        return new ItemStack(ModBlocks.nightmareBed, 1);
    }

    /**
     * Called before the Block is set to air in the world. Called regardless of if the player's tool can actually
     * collect this block
     */
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if (player.capabilities.isCreativeMode && state.getValue(PART) == BlockNightmareBed.EnumPartType.FOOT) {
            BlockPos blockpos = pos.offset(state.getValue(FACING));

            if (worldIn.getBlockState(blockpos).getBlock() == this) {
                worldIn.setBlockToAir(blockpos);
            }
        }
    }

    /**
     * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
     * Block.removedByPlayer
     */
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, TileEntity te, ItemStack stack) {
        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.HEAD && te instanceof TileEntityNightmareBed) {
            TileEntityNightmareBed TileEntityNightmareBed = (TileEntityNightmareBed)te;
            ItemStack itemstack = TileEntityNightmareBed.getItemStack();
            spawnAsEntity(worldIn, pos, itemstack);
        } else {
            super.harvestBlock(worldIn, player, pos, state, null, stack);
        }
    }

    /**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        super.breakBlock(worldIn, pos, state);
        worldIn.removeTileEntity(pos);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
        return (meta & 8) > 0 ? this.getDefaultState().withProperty(PART, BlockNightmareBed.EnumPartType.HEAD).withProperty(FACING, enumfacing).withProperty(OCCUPIED, Boolean.valueOf((meta & 4) > 0)) : this.getDefaultState().withProperty(PART, BlockNightmareBed.EnumPartType.FOOT).withProperty(FACING, enumfacing);
    }

    /**
     * Get the actual Block state of this Block at the given position. This applies properties not visible in the
     * metadata, such as fence connections.
     */
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.FOOT) {
            IBlockState iblockstate = worldIn.getBlockState(pos.offset(state.getValue(FACING)));

            if (iblockstate.getBlock() == this) {
                state = state.withProperty(OCCUPIED, iblockstate.getValue(OCCUPIED));
            }
        }

        return state;
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If inapplicable, returns the passed
     * blockstate.
     */
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        i = i | state.getValue(FACING).getHorizontalIndex();

        if (state.getValue(PART) == BlockNightmareBed.EnumPartType.HEAD) {
            i |= 8;

            if (state.getValue(OCCUPIED).booleanValue()) {
                i |= 4;
            }
        }

        return i;
    }

    /**
     * Get the geometry of the queried face at the given position and state. This is used to decide whether things like
     * buttons are allowed to be placed on the face, or how glass panes connect to the face, among other things.
     * <p>
     * Common values are {@code SOLID}, which is the default, and {@code UNDEFINED}, which represents something that
     * does not fit the other descriptions and will generally cause other things not to connect to the face.
     *
     * @return an approximation of the form of the given face
     */
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, PART, OCCUPIED);
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityNightmareBed();
    }

    @SideOnly(Side.CLIENT)
    public static boolean isHeadPiece(int metadata) {
        return (metadata & 8) != 0;
    }

    public enum EnumPartType implements IStringSerializable {
        HEAD("head"),
        FOOT("foot");

        private final String name;

        EnumPartType(String name) {
            this.name = name;
        }

        public String toString() {
            return this.name;
        }

        public String getName() {
            return this.name;
        }
    }

    /**
     * Handling dimension change
     *
     * @param player  - player
     * @param old     - old dim
     * @param current - current dim
     */
    public static void onChangeDimension(EntityPlayer player, DimensionType old, DimensionType current) {
        if (player == null || old == null || current == null)
            return;

        // we need different dimensions including vethea
        if (old == current || old != ModDimensions.vetheaDimension && current != ModDimensions.vetheaDimension)
            return;

        NBTTagCompound tag = NbtUtil.getPersistedDivineTag(player);

        List<String> tagNames = Arrays.asList("OverworldInv", "VetheaInv");

        if (old == ModDimensions.vetheaDimension) {
            Collections.reverse(tagNames);
        }

        String saveTo = tagNames.get(0);
        tag.setTag(saveTo, player.inventory.writeToNBT(new NBTTagList()));
        player.inventory.clear();

        String loadFrom = tagNames.get(1);
        NBTBase base = tag.getTag(loadFrom);
        if (base instanceof NBTTagList) {
            player.inventory.readFromNBT((NBTTagList) base);
        }

        player.inventoryContainer.detectAndSendChanges();
    }
}