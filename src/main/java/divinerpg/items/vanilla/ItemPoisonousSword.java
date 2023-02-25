package divinerpg.items.vanilla;

import divinerpg.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;

import java.util.*;

public class ItemPoisonousSword extends ItemModSword {
    private final float poisonSeconds;

    public ItemPoisonousSword(Tier mat, float seconds) {
        super(mat, DivineRPG.tabs.melee);
        this.poisonSeconds = seconds;
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity)
            ((LivingEntity) entity)
                    .addEffect(new MobEffectInstance(MobEffects.POISON, (int) (poisonSeconds * 20), 1));
        return false;
    }

    @Override
    protected void addAdditionalInformation(List<Component> list) {
        list.add(LocalizeUtils.poison(this.poisonSeconds));
    }
}
