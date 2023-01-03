package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;

public class ItemCollector extends ItemMod {

    public ItemCollector() {
        super();
    }

    @Override
    public InteractionResult useOn(UseOnContext ctx) {
        Level world = ctx.getLevel();
        BlockPos pos = ctx.getClickedPos();
        InteractionHand hand = ctx.getHand();
        Player player = ctx.getPlayer();
        ItemStack stack = ctx.getPlayer().getItemInHand(hand);

        if (!world.isClientSide) {
            Block block = world.getBlockState(pos).getBlock();
            if (block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_altar"))) {
                EntityRegistry.DUNGEON_CONSTRUCTOR.get().spawn((ServerLevel) world, stack, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
                if (!player.isCreative())
                    stack.shrink(1);
                return InteractionResult.PASS;
            }
        }
        return InteractionResult.FAIL;
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
    	return 100;
    }
}