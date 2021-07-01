package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.potion.*;
import net.minecraft.util.text.*;

import java.util.*;

public class ItemSlowingSword extends ItemModSword {

    public ItemSlowingSword(IItemTier toolMaterial, String name) {
        super(name, toolMaterial, DivineRPG.tabs.melee);
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
