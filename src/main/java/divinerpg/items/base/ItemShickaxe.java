package divinerpg.items.base;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.*;

import javax.annotation.*;
import java.util.*;

public class ItemShickaxe extends ToolItem {
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of();

    public ItemShickaxe(String name, Rarity rarity, IItemTier tier) {
        super(1.0F, -2.8F, tier, EFFECTIVE_ON, new Item.Properties().tab(DivineRPG.tabs.tools).addToolType(ToolType.AXE, tier.getLevel()).addToolType(ToolType.PICKAXE, tier.getLevel()).addToolType(ToolType.SHOVEL, tier.getLevel()).durability(tier.getUses()).rarity(rarity));
        setRegistryName(name);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency(speed));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getLevel()));

        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        } else {
            tooltip.add(LocalizeUtils.usesRemaining(getTier().getUses() - getDamage(stack)));
        }
    }



    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, (context) -> {
            context.broadcastBreakEvent(attacker.getUsedItemHand());
        });
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock().getHarvestLevel(state) <= getTier().getLevel()) {
            return this.speed;
        }

        return super.getDestroySpeed(stack, state);
    }



    @Override
    public ActionResultType useOn(ItemUseContext context) {
        return Items.DIAMOND_HOE.useOn(context);
    }

    @Override
    public boolean canHarvestBlock(ItemStack stack, BlockState state) {
        return state.getBlock().getHarvestLevel(state) <= getTier().getLevel();
    }

}
