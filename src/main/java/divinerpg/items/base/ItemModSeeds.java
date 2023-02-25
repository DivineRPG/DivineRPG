package divinerpg.items.base;

import divinerpg.*;
import net.minecraft.advancements.*;
import net.minecraft.core.*;
import net.minecraft.server.level.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.common.*;

import java.util.function.*;

public class ItemModSeeds extends ItemMod implements IPlantable {
    public Supplier<Block> soilSupplier;
    private final Supplier<Block> cropSupplier;

    public ItemModSeeds(Supplier<Block> cropSupplier) {
        this(cropSupplier, () -> Blocks.FARMLAND);
    }

    public ItemModSeeds(Supplier<Block> cropSupplier, Supplier<Block> soilSupplier) {
        super(DivineRPG.tabs.food);
        this.cropSupplier = cropSupplier;
        this.soilSupplier = soilSupplier;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        ItemStack itemstack = context.getItemInHand();
        Level worldIn = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        Direction facing = context.getClickedFace();
        Block crop = cropSupplier.get();
        Block soil = soilSupplier.get();

        if (worldIn.getBlockState(pos).getBlock() != soil) {
            return InteractionResult.FAIL;
        } else if (crop != null && facing == Direction.UP && player.mayUseItemAt(pos.offset(facing.getNormal()), facing, itemstack)
                && worldIn.getBlockState(pos.above()) == Blocks.AIR.defaultBlockState()) {
            worldIn.setBlock(pos.above(), crop.defaultBlockState(), 1);

            if (player instanceof ServerPlayer) {
                CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, pos.above(), itemstack);
            }

            if (!player.isCreative())
                itemstack.shrink(1);

            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Override
    public PlantType getPlantType(BlockGetter world, BlockPos pos) {
        return null;
    }

    @Override
    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return null;
    }
}
