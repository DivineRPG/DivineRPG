package divinerpg.items.vanilla;

import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

import java.util.List;

public class ItemSlowingSword extends ItemModSword {

    public ItemSlowingSword(Tier toolMaterial) {
        super(toolMaterial);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity)
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 50, 1));
        return false;
    }

    @Override
    protected void addAdditionalInformation(List<Component> list) {
        list.add(LocalizeUtils.slow(2.5));
    }
}
