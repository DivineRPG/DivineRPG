package divinerpg.objects.blocks.arcana;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.Reference;
import divinerpg.dimensions.arcana.ArcanaTeleporter;
import divinerpg.enums.EnumBlockType;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockArcanaPortal extends Block {
    private int firetick;
    private int firemax = 200;
    private int dimId;
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);

    public BlockArcanaPortal(String name, int dimId) {
        super(Material.PORTAL);
        this.setSoundType(EnumBlockType.PORTAL.getSound());
        this.setUnlocalizedName(name);
        this.setRegistryName(Reference.MODID, name);
        this.setCreativeTab(null);
        setLightLevel(1.0F);
        setBlockUnbreakable();
        setResistance(6000000F);
        this.dimId = dimId;

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BLOCK_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isReplaceable(IBlockAccess worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
            List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean isActualState) {
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null;
    }

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entity) {
        if ((entity.getRidingEntity() == null) && ((entity instanceof EntityPlayerMP))) {
            EntityPlayerMP thePlayer = (EntityPlayerMP) entity;
            thePlayer.mcServer.getWorld(thePlayer.dimension);
            int dimensionID = dimId;
            if (thePlayer.timeUntilPortal > 0) {
                thePlayer.timeUntilPortal = 40;
            } else if (thePlayer.dimension != dimensionID) {
                thePlayer.timeUntilPortal = 40;
                thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, dimensionID,
                        new ArcanaTeleporter(thePlayer.mcServer.getWorld(dimensionID)));
                thePlayer.addExperience(0);
            } else {
                thePlayer.timeUntilPortal = 40;
                thePlayer.mcServer.getPlayerList().transferPlayerToDimension(thePlayer, 0,
                        new ArcanaTeleporter(thePlayer.mcServer.getWorld(0)));
                thePlayer.addExperience(0);
            }
        }
    }

    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (blockIn == ModBlocks.arcanaPortalFrame) {
            int startX = pos.getX();
            int startZ = pos.getZ();
            /* Find upper left hand corner of portal */
            while (world.getBlockState(new BlockPos(startX - 1, pos.getY(), startZ)).getBlock() == this)
                startX--;
            while (world.getBlockState(new BlockPos(startX, pos.getY(), startZ - 1)).getBlock() == this)
                startZ--;

            /* Replace portal blocks with air */
            for (int scanZ = startZ; scanZ < startZ + 3; scanZ++) {
                for (int scanX = startX; scanX < startX + 3; scanX++) {
                    if (world.getBlockState(new BlockPos(scanX, pos.getY(), scanZ)).getBlock() == this) {
                        world.setBlockState(new BlockPos(scanX, pos.getY(), scanZ), Blocks.AIR.getDefaultState());
                    }
                }
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double distanceX = pos.getX() + rand.nextFloat();
        double distanceY = pos.getY() + 0.8F;
        double distanceZ = pos.getZ() + rand.nextFloat();
        worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, distanceX, distanceY, distanceZ, 0, 0, 0);
    }
}