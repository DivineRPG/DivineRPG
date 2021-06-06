package divinerpg.blocks.fluid;

import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.fluid.*;
import net.minecraft.item.*;
import net.minecraft.particles.*;
import net.minecraft.state.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.fluids.*;

import javax.annotation.*;
import java.util.*;

public class FluidTar extends FlowingFluid {
    public Fluid getFlowing() {
        return FluidRegistry.TAR_FLOW;
    }

    public Fluid getSource() {
        return FluidRegistry.TAR;
    }

    public Item getBucket() {
        return ItemRegistry.smolderingTarBucket;
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(World p_204522_1_, BlockPos p_204522_2_, FluidState p_204522_3_, Random p_204522_4_) {
        BlockPos blockpos = p_204522_2_.above();
        if (p_204522_1_.getBlockState(blockpos).isAir() && !p_204522_1_.getBlockState(blockpos).isSolidRender(p_204522_1_, blockpos)) {
            if (p_204522_4_.nextInt(100) == 0) {
                double d0 = (double)p_204522_2_.getX() + p_204522_4_.nextDouble();
                double d1 = (double)p_204522_2_.getY() + 1.0D;
                double d2 = (double)p_204522_2_.getZ() + p_204522_4_.nextDouble();
                p_204522_1_.addParticle(ParticleRegistry.TAR.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
                p_204522_1_.playLocalSound(d0, d1, d2, SoundEvents.LAVA_POP, SoundCategory.BLOCKS, 0.2F + p_204522_4_.nextFloat() * 0.2F, 0.9F + p_204522_4_.nextFloat() * 0.15F, false);
            }

            if (p_204522_4_.nextInt(200) == 0) {
                p_204522_1_.playLocalSound((double)p_204522_2_.getX(), (double)p_204522_2_.getY(), (double)p_204522_2_.getZ(), SoundEvents.LAVA_AMBIENT, SoundCategory.BLOCKS, 0.2F + p_204522_4_.nextFloat() * 0.2F, 0.9F + p_204522_4_.nextFloat() * 0.15F, false);
            }
        }

    }

    public void randomTick(World p_207186_1_, BlockPos p_207186_2_, FluidState p_207186_3_, Random p_207186_4_) {
        if (p_207186_1_.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            int i = p_207186_4_.nextInt(3);
            if (i > 0) {
                BlockPos blockpos = p_207186_2_;

                for(int j = 0; j < i; ++j) {
                    blockpos = blockpos.offset(p_207186_4_.nextInt(3) - 1, 1, p_207186_4_.nextInt(3) - 1);
                    if (!p_207186_1_.isLoaded(blockpos)) {
                        return;
                    }

                    BlockState blockstate = p_207186_1_.getBlockState(blockpos);
                    if (blockstate.isAir()) {
                        if (this.hasFlammableNeighbours(p_207186_1_, blockpos)) {
                            p_207186_1_.setBlockAndUpdate(blockpos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_207186_1_, blockpos, p_207186_2_, Blocks.FIRE.defaultBlockState()));
                            return;
                        }
                    } else if (blockstate.getMaterial().blocksMotion()) {
                        return;
                    }
                }
            } else {
                for(int k = 0; k < 3; ++k) {
                    BlockPos blockpos1 = p_207186_2_.offset(p_207186_4_.nextInt(3) - 1, 0, p_207186_4_.nextInt(3) - 1);
                    if (!p_207186_1_.isLoaded(blockpos1)) {
                        return;
                    }

                    if (p_207186_1_.isEmptyBlock(blockpos1.above()) && this.isFlammable(p_207186_1_, blockpos1)) {
                        p_207186_1_.setBlockAndUpdate(blockpos1.above(), net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_207186_1_, blockpos1.above(), p_207186_2_, Blocks.FIRE.defaultBlockState()));
                    }
                }
            }

        }
    }

    private boolean hasFlammableNeighbours(IWorldReader p_176369_1_, BlockPos p_176369_2_) {
        for(Direction direction : Direction.values()) {
            if (this.isFlammable(p_176369_1_, p_176369_2_.relative(direction))) {
                return true;
            }
        }

        return false;
    }

    private boolean isFlammable(IWorldReader p_176368_1_, BlockPos p_176368_2_) {
        return p_176368_2_.getY() >= 0 && p_176368_2_.getY() < 256 && !p_176368_1_.hasChunkAt(p_176368_2_) ? false : p_176368_1_.getBlockState(p_176368_2_).getMaterial().isFlammable();
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticle() {
        return ParticleTypes.DRIPPING_LAVA;
    }

    protected void beforeDestroyingBlock(IWorld p_205580_1_, BlockPos p_205580_2_, BlockState p_205580_3_) {
        this.fizz(p_205580_1_, p_205580_2_);
    }

    public int getSlopeFindDistance(IWorldReader p_185698_1_) {
        return 4;
    }

    public BlockState createLegacyBlock(FluidState p_204527_1_) {
        return BlockRegistry.smolderingTar.defaultBlockState().setValue(FlowingFluidBlock.LEVEL, Integer.valueOf(getLegacyLevel(p_204527_1_)));
    }

    @Override
    public boolean isSource(FluidState p_207193_1_) {
        return false;
    }

    @Override
    public int getAmount(FluidState p_207192_1_) {
        return 0;
    }

    public boolean isSame(Fluid p_207187_1_) {
        return p_207187_1_ == FluidRegistry.TAR || p_207187_1_ == FluidRegistry.TAR_FLOW;
    }

    public int getDropOff(IWorldReader p_204528_1_) {
        return 2;
    }

    public boolean canBeReplacedWith(FluidState p_215665_1_, IBlockReader p_215665_2_, BlockPos p_215665_3_, Fluid p_215665_4_, Direction p_215665_5_) {
        return p_215665_1_.getHeight(p_215665_2_, p_215665_3_) >= 0.44444445F && p_215665_4_.is(FluidTags.WATER);
    }

    public int getTickDelay(IWorldReader p_205569_1_) {
        return 25;
    }

    public int getSpreadDelay(World p_215667_1_, BlockPos p_215667_2_, FluidState p_215667_3_, FluidState p_215667_4_) {
        int i = this.getTickDelay(p_215667_1_);
        if (!p_215667_3_.isEmpty() && !p_215667_4_.isEmpty() && !p_215667_3_.getValue(FALLING) && !p_215667_4_.getValue(FALLING) && p_215667_4_.getHeight(p_215667_1_, p_215667_2_) > p_215667_3_.getHeight(p_215667_1_, p_215667_2_) && p_215667_1_.getRandom().nextInt(4) != 0) {
            i *= 4;
        }

        return i;
    }

    private void fizz(IWorld p_205581_1_, BlockPos p_205581_2_) {
        p_205581_1_.levelEvent(1501, p_205581_2_, 0);
    }

    protected boolean canConvertToSource() {
        return false;
    }

    protected void spreadTo(IWorld p_205574_1_, BlockPos p_205574_2_, BlockState p_205574_3_, Direction p_205574_4_, FluidState p_205574_5_) {
        if (p_205574_4_ != Direction.UP) {
            FluidState fluidstate = p_205574_1_.getFluidState(p_205574_2_);
            if (fluidstate.is(FluidTags.WATER)) {
                if (p_205574_3_.getBlock() instanceof FlowingFluidBlock) {
                    p_205574_1_.setBlock(p_205574_2_, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_205574_1_, p_205574_2_, p_205574_2_, BlockRegistry.asphalt.defaultBlockState()), 3);
                }

                this.fizz(p_205574_1_, p_205574_2_);
                return;
            }
            if (fluidstate.is(FluidTags.LAVA)) {
                if (p_205574_3_.getBlock() instanceof FlowingFluidBlock) {
                    p_205574_1_.setBlock(p_205574_2_, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(p_205574_1_, p_205574_2_, p_205574_2_, BlockRegistry.twilightStone.defaultBlockState()), 3);
                }

                this.fizz(p_205574_1_, p_205574_2_);
                return;
            }
        }

        super.spreadTo(p_205574_1_, p_205574_2_, p_205574_3_, p_205574_4_, p_205574_5_);
    }

    protected boolean isRandomlyTicking() {
        return true;
    }

    protected float getExplosionResistance() {
        return 100.0F;
    }

    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(new ResourceLocation(DivineRPG.MODID, "blocks/liquid_tar_still"), new ResourceLocation(DivineRPG.MODID, "blocks/liquid_tar_flow")).temperature(1100).density(1153).viscosity(8000).build(this);
    }

    public static class Flowing extends FluidTar {
        protected void createFluidStateDefinition(StateContainer.Builder<Fluid, FluidState> p_207184_1_) {
            super.createFluidStateDefinition(p_207184_1_);
            p_207184_1_.add(LEVEL);
        }

        public int getAmount(FluidState p_207192_1_) {
            return p_207192_1_.getValue(LEVEL);
        }

        public boolean isSource(FluidState p_207193_1_) {
            return false;
        }
    }

    public static class Source extends FluidTar {
        public int getAmount(FluidState p_207192_1_) {
            return 8;
        }

        public boolean isSource(FluidState p_207193_1_) {
            return true;
        }
    }
}
