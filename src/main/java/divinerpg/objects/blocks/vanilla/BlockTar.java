package divinerpg.objects.blocks.vanilla;

import divinerpg.objects.blocks.BlockModFluid;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockTar extends BlockModFluid {

    private static final MapColor mapColor = MapColor.BLACK;

    public BlockTar(String name, Fluid fluid) {
        super(name, fluid, Material.LAVA);
        this.setTickRandomly(true);
    }

    /*
    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        entityIn.setInWeb();
    }*/

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        super.onBlockAdded(worldIn, pos, state);
        this.checkForMixing(worldIn, pos, state);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        super.onBlockAdded(worldIn, pos, state);
        this.checkForMixing(worldIn, pos, state);
    }

    public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state) {
        boolean touchingWater = false;
        boolean touchingLava = false;

        EnumFacing[] facing = EnumFacing.values();
        int facingSize = facing.length;

        for(int k = 0; k < facingSize; ++k) {
            EnumFacing enumfacing = facing[k];

            IBlockState adjacent = worldIn.getBlockState(pos.offset(enumfacing));

            if (enumfacing != EnumFacing.DOWN && adjacent.getMaterial() == Material.WATER) {
                touchingWater = true;
                break;
            }
            else if (enumfacing != EnumFacing.DOWN && adjacent.getBlock() != this && adjacent.getMaterial() == Material.LAVA) {
                touchingLava = true;
                break;
            }
        }

        if (touchingWater) {
            Integer integer = (Integer)state.getValue(LEVEL);
            if (integer == 0) {
                worldIn.setBlockState(pos, fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.asphalt.getDefaultState()));
                this.triggerMixEffects(worldIn, pos);
                return true;
            }
            else if (integer <= 4) {
                worldIn.setBlockState(pos, fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.asphalt.getDefaultState()));
                this.triggerMixEffects(worldIn, pos);
                return true;
            }
        }
        else if (touchingLava) {
            Integer integer = (Integer)state.getValue(LEVEL);
            if (integer <= 4) {
                worldIn.setBlockState(pos, fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.twilightStone.getDefaultState()));
                this.triggerMixEffects(worldIn, pos);
                return true;
            }
        }

        return false;
    }

    /*
        Again stolen from lava
     */
    protected void triggerMixEffects(World worldIn, BlockPos pos) {
        double d0 = (double)pos.getX();
        double d1 = (double)pos.getY();
        double d2 = (double)pos.getZ();
        worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

        for(int i = 0; i < 8; ++i) {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0 + Math.random(), d1 + 1.2D, d2 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
        }

    }

    @Override
    public void updateTick(@Nonnull World world, @Nonnull BlockPos pos, @Nonnull IBlockState state,
                           @Nonnull Random rand) {
        super.updateTick(world, pos, state, rand);

        /*
        	Stolen from Lava block
         */
        if (this.blockMaterial == Material.LAVA) {
            if (world.getGameRules().getBoolean("doFireTick")) {
                int i = rand.nextInt(3);

                if (i > 0) {
                    BlockPos blockpos = pos;

                    for (int j = 0; j < i; ++j) {
                        blockpos = blockpos.add(rand.nextInt(3) - 1, 1, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < world.getHeight()
                                && !world.isBlockLoaded(blockpos)) {
                            return;
                        }

                        IBlockState block = world.getBlockState(blockpos);

                        if (block.getBlock().isAir(block, world, blockpos)) {
                            if (this.isSurroundingBlockFlammable(world, blockpos)) {
                                world.setBlockState(blockpos, fireFluidPlaceBlockEvent(world,
                                        blockpos, pos, Blocks.FIRE.getDefaultState()));
                                return;
                            }
                        } else if (block.getMaterial().blocksMovement()) {
                            return;
                        }
                    }
                } else {
                    for (int k = 0; k < 3; ++k) {
                        BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, 0, rand.nextInt(3) - 1);

                        if (blockpos1.getY() >= 0 && blockpos1.getY() < 256 && !world.isBlockLoaded(blockpos1)) {
                            return;
                        }

                        if (world.isAirBlock(blockpos1.up()) && this.getCanBlockBurn(world, blockpos1)) {
                            world.setBlockState(blockpos1.up(), fireFluidPlaceBlockEvent(world,
                                    blockpos1.up(), pos, Blocks.FIRE.getDefaultState()));
                        }
                    }
                }
            }
        }
    }
    public static IBlockState fireFluidPlaceBlockEvent(World world, BlockPos pos, BlockPos liquidPos, IBlockState state)
    {
        BlockEvent.FluidPlaceBlockEvent event = new BlockEvent.FluidPlaceBlockEvent(world, pos, liquidPos, state);
        MinecraftForge.EVENT_BUS.post(event);
        return event.getNewState();
    }
    /*
    	Stolen from Lava Block
     */
    private boolean isSurroundingBlockFlammable(World worldIn, BlockPos pos) {
        for (EnumFacing enumfacing : EnumFacing.values()) {
            if (this.getCanBlockBurn(worldIn, pos.offset(enumfacing))) {
                return true;
            }
        }

        return false;
    }

    /*
    	Stolen from Lava block
     */
    private boolean getCanBlockBurn(World worldIn, BlockPos pos) {
        return pos.getY() >= 0 && pos.getY() < 256 && !worldIn.isBlockLoaded(pos) ? false :
                worldIn.getBlockState(pos).getMaterial().getCanBurn();
    }

    // Still stolen from lava
    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        double d0 = (double) pos.getX();
        double d1 = (double) pos.getY();
        double d2 = (double) pos.getZ();

        if (this.blockMaterial == Material.LAVA && worldIn.getBlockState(pos.up()).getMaterial() == Material.AIR
                && !worldIn.getBlockState(pos.up()).isOpaqueCube()) {
            if (rand.nextInt(100) == 0) {
                double d8 = d0 + (double) rand.nextFloat();
                double d4 = d1 + stateIn.getBoundingBox(worldIn, pos).maxY;
                double d6 = d2 + (double) rand.nextFloat();
                worldIn.spawnParticle(EnumParticleTypes.LAVA, d8, d4, d6, 0.0D, 0.0D, 0.0D);
                worldIn.playSound(d8, d4, d6, SoundEvents.BLOCK_LAVA_POP, SoundCategory.BLOCKS,
                        0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }

            if (rand.nextInt(200) == 0) {
                worldIn.playSound(d0, d1, d2, SoundEvents.BLOCK_LAVA_AMBIENT, SoundCategory.BLOCKS,
                        0.2F + rand.nextFloat() * 0.2F, 0.9F + rand.nextFloat() * 0.15F, false);
            }
        }
    }

    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return this.mapColor;
    }
}