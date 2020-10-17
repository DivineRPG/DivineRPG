package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.util.LocalizeUtils;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.*;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.*;

public class ItemShickaxe extends ToolItem {
    private static final Set<Block> EFFECTIVE_ON = ImmutableSet.of();

    public ItemShickaxe(String name, IItemTier tier) {
        super(1.0F, -2.8F, tier, EFFECTIVE_ON, new Item.Properties().group(DivineRPG.tabs.tools).addToolType(ToolType.AXE, tier.getHarvestLevel()).addToolType(ToolType.PICKAXE, tier.getHarvestLevel()).addToolType(ToolType.SHOVEL, tier.getHarvestLevel()).maxDamage(tier.getMaxUses()));
        setRegistryName(name);
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.efficiency(efficiency));
        tooltip.add(LocalizeUtils.harvestLevel(getTier().getHarvestLevel()));

        if (getMaxDamage() == -1) {
            tooltip.add(LocalizeUtils.infiniteUses());
        } else {
            tooltip.add(LocalizeUtils.usesRemaining(getTier().getMaxUses() - getDamage(stack)));
        }
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, null);
        return true;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.getBlock().getHarvestLevel(state) <= getTier().getHarvestLevel()) {
            return this.efficiency;
        }

        return super.getDestroySpeed(stack, state);
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        return Items.DIAMOND_HOE.onItemUse(context);
    }

    @Override
    public boolean canHarvestBlock(BlockState blockIn) {
        return blockIn.getBlock().getHarvestLevel(blockIn) <= getTier().getHarvestLevel();
    }

}
