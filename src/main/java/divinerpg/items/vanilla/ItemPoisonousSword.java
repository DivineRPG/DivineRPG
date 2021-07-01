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

public class ItemPoisonousSword extends ItemModSword {
    private float poisonSeconds;

    public ItemPoisonousSword(IItemTier mat, String name, float seconds) {
        super(name, mat, DivineRPG.tabs.melee);
        this.poisonSeconds = seconds;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity)
            ((LivingEntity) entity)
                    .addEffect(new EffectInstance(Effects.POISON, (int) (poisonSeconds * 20), 1));
        return false;
    }

    @Override
    protected void addAdditionalInformation(List<ITextComponent> list) {
        list.add(LocalizeUtils.poison(this.poisonSeconds));
    }
}
