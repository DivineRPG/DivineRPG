package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemWizardsBook extends ItemMod {
    public ItemWizardsBook() {
        super(new Properties().stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = player.getItemInHand(hand);
        Block block = world.getBlockState(pos).getBlock();
        if (block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_altar"))) {
            if (!world.isClientSide) {
                EntityRegistry.PARASECTA.get().spawn((ServerLevel) world, ItemStack.EMPTY, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            }
            if (!player.isCreative())
                stack.shrink(1);
            return InteractionResult.SUCCESS;
        }

        if (block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_altar"))) {
            if (!world.isClientSide) {
                EntityRegistry.DRAMIX.get().spawn((ServerLevel) world, ItemStack.EMPTY, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            }
            if (!player.isCreative())
                stack.shrink(1);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

}
