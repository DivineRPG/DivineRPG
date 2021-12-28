package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.util.RarityList;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

import java.util.function.Supplier;

public class ItemModSeeds extends ItemMod implements IPlantable {
    private Supplier<Block> cropSupplier;
    public Supplier<Block> soilSupplier;

    public ItemModSeeds(String name, Supplier<Block> cropSupplier) {
        this(name, cropSupplier, () -> Blocks.FARMLAND);
    }
    public ItemModSeeds(String name, Supplier<Block> cropSupplier, Supplier<Block> soilSupplier) {
        super(name, RarityList.COMMON, DivineRPG.tabs.food);
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
