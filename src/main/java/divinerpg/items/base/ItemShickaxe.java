package divinerpg.items.base;

import com.google.common.collect.ImmutableSet;
import divinerpg.DivineRPG;
import divinerpg.util.LocalizeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

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
        stack.hurtAndBreak(1, attacker, null);
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
