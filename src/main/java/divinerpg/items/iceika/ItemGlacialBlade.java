package divinerpg.items.iceika;

import divinerpg.enums.ToolStats;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class ItemGlacialBlade extends ItemModSword {
    public ItemGlacialBlade() {
        super(ToolStats.GLACIAL_BLADE);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof Player) {
            target.setDeltaMovement(0, 0, 0);
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 32, 4));
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    protected void addAdditionalInformation(List<Component> list) {
        list.add(LocalizeUtils.slow(1.6));
    }
}
