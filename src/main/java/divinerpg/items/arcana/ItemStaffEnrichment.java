package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.List;

public class ItemStaffEnrichment extends ItemMod {


    public ItemStaffEnrichment() {
        super(new Properties().durability(100));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Level world = context.getLevel();
        ItemStack stack = player.getItemInHand(hand);
        if (!world.mayInteract(player, pos)) {
            return InteractionResult.FAIL;
        } else {
            Block var11 = world.getBlockState(pos).getBlock();

            if (var11 == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_dirt"))) {
                Block var13 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_grass"));
                player.playSound(SoundEvents.METAL_STEP, 0.8f, 0.8f);
                if (world.isClientSide) {
                    return InteractionResult.PASS;
                } else {
                    world.setBlock(pos, var13.defaultBlockState(), 0);
                    stack.hurtAndBreak(1, player, (ctx) -> {
                        ctx.broadcastBreakEvent(player.getUsedItemHand());
                    });
                    return InteractionResult.PASS;
                }
            }
        }
        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.staff_of_enrichment"));
        tooltip.add(LocalizeUtils.usesRemaining(stack.getMaxDamage() - stack.getDamageValue()));
    }
}
