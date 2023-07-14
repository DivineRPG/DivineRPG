package divinerpg.world.feature.decoration;

import divinerpg.DivineRPG;
import divinerpg.blocks.iceika.BlockIcicle;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DripstoneThickness;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.PointedDripstoneConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Optional;
import java.util.function.Consumer;

public class Icicle extends Feature<PointedDripstoneConfiguration> {
   public Icicle() {
      super(PointedDripstoneConfiguration.CODEC);
   }
   public boolean place(FeaturePlaceContext<PointedDripstoneConfiguration> p_191078_) {
      LevelAccessor levelaccessor = p_191078_.level();
      BlockPos blockpos = p_191078_.origin();
      RandomSource randomsource = p_191078_.random();
      PointedDripstoneConfiguration pointeddripstoneconfiguration = p_191078_.config();
      Optional<Direction> optional = getTipDirection(levelaccessor, blockpos, randomsource);
      if (optional.isEmpty()) return false;
      else {
         BlockPos blockpos1 = blockpos.relative(optional.get().getOpposite());
         createPatchOfPackedIce(levelaccessor, randomsource, blockpos1, pointeddripstoneconfiguration);
         int i = randomsource.nextFloat() < pointeddripstoneconfiguration.chanceOfTallerDripstone && DripstoneUtils.isEmptyOrWater(levelaccessor.getBlockState(blockpos.relative(optional.get()))) ? 2 : 1;
         growIcicle(levelaccessor, blockpos, optional.get(), i, false);
         return true;
      }
   }
   private static Optional<Direction> getTipDirection(LevelAccessor p_225199_, BlockPos p_225200_, RandomSource p_225201_) {
      boolean flag = isIcicleBase(p_225199_.getBlockState(p_225200_.above()));
      boolean flag1 = isIcicleBase(p_225199_.getBlockState(p_225200_.below()));
      if (flag && flag1) return Optional.of(p_225201_.nextBoolean() ? Direction.DOWN : Direction.UP);
      else if (flag) return Optional.of(Direction.DOWN);
      else return flag1 ? Optional.of(Direction.UP) : Optional.empty();
   }
   private static void createPatchOfPackedIce(LevelAccessor p_225194_, RandomSource p_225195_, BlockPos p_225196_, PointedDripstoneConfiguration p_225197_) {
      placePackedIceIfPossible(p_225194_, p_225196_);
      for(Direction direction : Direction.Plane.HORIZONTAL) {
         if (!(p_225195_.nextFloat() > p_225197_.chanceOfDirectionalSpread)) {
            BlockPos blockpos = p_225196_.relative(direction);
            placePackedIceIfPossible(p_225194_, blockpos);
            if (!(p_225195_.nextFloat() > p_225197_.chanceOfSpreadRadius2)) {
               BlockPos blockpos1 = blockpos.relative(Direction.getRandom(p_225195_));
               placePackedIceIfPossible(p_225194_, blockpos1);
               if (!(p_225195_.nextFloat() > p_225197_.chanceOfSpreadRadius3)) {
                  BlockPos blockpos2 = blockpos1.relative(Direction.getRandom(p_225195_));
                  placePackedIceIfPossible(p_225194_, blockpos2);
               }
            }
         }
      }
   }
   protected static boolean placePackedIceIfPossible(LevelAccessor p_190854_, BlockPos p_190855_) {
	      BlockState blockstate = p_190854_.getBlockState(p_190855_);
	      if (isIcicleBase(blockstate)) {
	         if(!(blockstate.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_leaves"))) || blockstate.is(Blocks.ICE) || blockstate.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "shiverspine_log"))))) p_190854_.setBlock(p_190855_, Blocks.PACKED_ICE.defaultBlockState(), 2);
	         return true;
	      } else return false;
	}
	protected static void growIcicle(LevelAccessor p_190848_, BlockPos p_190849_, Direction p_190850_, int p_190851_, boolean p_190852_) {
		if (isIcicleBase(p_190848_.getBlockState(p_190849_.relative(p_190850_.getOpposite())))) {
	         BlockPos.MutableBlockPos blockpos$mutableblockpos = p_190849_.mutable();
	         buildBaseToTipColumn(p_190850_, p_190851_, p_190852_, (p_190846_) -> {
	            if (p_190846_.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")))) p_190846_ = p_190846_.setValue(BlockIcicle.WATERLOGGED, Boolean.valueOf(p_190848_.isWaterAt(blockpos$mutableblockpos)));
	            p_190848_.setBlock(blockpos$mutableblockpos, p_190846_, 2);
	            blockpos$mutableblockpos.move(p_190850_);
	         });
		}
	}
	public static boolean isIcicleBase(BlockState blockstate) {
	   return blockstate.is(BlockTags.DRIPSTONE_REPLACEABLE) || blockstate.is(BlockTags.ICE) || blockstate.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_leaves"))) || blockstate.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "shiverspine_log"))) || blockstate.is(Blocks.GRAVEL);
	}
	protected static void buildBaseToTipColumn(Direction p_159652_, int p_159653_, boolean p_159654_, Consumer<BlockState> p_159655_) {
	      if (p_159653_ >= 3) {
	         p_159655_.accept(createIcicle(p_159652_, DripstoneThickness.BASE));
	         for(int i = 0; i < p_159653_ - 3; ++i) p_159655_.accept(createIcicle(p_159652_, DripstoneThickness.MIDDLE));
	      }
	      if (p_159653_ >= 2) p_159655_.accept(createIcicle(p_159652_, DripstoneThickness.FRUSTUM));
	      if (p_159653_ >= 1) p_159655_.accept(createIcicle(p_159652_, p_159654_ ? DripstoneThickness.TIP_MERGE : DripstoneThickness.TIP));
	   }
	private static BlockState createIcicle(Direction p_159657_, DripstoneThickness p_159658_) {
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "icicle")).defaultBlockState().setValue(BlockIcicle.TIP_DIRECTION, p_159657_).setValue(BlockIcicle.THICKNESS, p_159658_);
	}
}