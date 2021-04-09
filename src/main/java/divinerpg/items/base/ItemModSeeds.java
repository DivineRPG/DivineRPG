package divinerpg.items.base;

import divinerpg.*;
import net.minecraft.advancements.*;
import net.minecraft.block.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class ItemModSeeds extends ItemMod implements IPlantable {
    private Supplier<Block> cropSupplier;
    public Supplier<Block> soilSupplier;

    public ItemModSeeds(String name, Supplier<Block> cropSupplier) {
        this(name, cropSupplier, () -> Blocks.FARMLAND);
    }
    public ItemModSeeds(String name, Supplier<Block> cropSupplier, Supplier<Block> soilSupplier) {
        super(name, DivineRPG.tabs.food);
        this.cropSupplier = cropSupplier;
        this.soilSupplier = soilSupplier;
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        ItemStack itemstack = context.getItemInHand();
        World worldIn = context.getLevel();
        BlockPos pos = context.getClickedPos();
        PlayerEntity player = context.getPlayer();
        Direction facing = context.getClickedFace();
        Block crop = cropSupplier.get();
        Block soil = soilSupplier.get();

        if (worldIn.getBlockState(pos).getBlock() != soil) {
            return ActionResultType.FAIL;
        } else if (crop != null && facing == Direction.UP && player.mayUseItemAt(pos.offset(facing.getNormal()), facing, itemstack)
                && worldIn.getBlockState(pos.above()) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlock(pos.above(), crop.defaultBlockState(), 1);

            if (player instanceof ServerPlayerEntity) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayerEntity) player, pos.above(), itemstack);
            }

            if (!player.isCreative())
                itemstack.shrink(1);

            return ActionResultType.SUCCESS;
        } else {
            return ActionResultType.FAIL;
        }
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return null;
    }
}
