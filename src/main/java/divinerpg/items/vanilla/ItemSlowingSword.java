package divinerpg.items.vanilla;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;

import java.util.List;

public class ItemSlowingSword extends ItemModSword {

    public ItemSlowingSword(IItemTier toolMaterial, String name) {
        super(name, RarityList.COMMON, toolMaterial, DivineRPG.tabs.melee);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity)
            ((LivingEntity) entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 50, 1));
        return false;
    }

    @Override
    protected void addAdditionalInformation(List<ITextComponent> list) {
        list.add(LocalizeUtils.slow(2.5));
    }
}
