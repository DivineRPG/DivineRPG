package divinerpg.items.iceika;

import divinerpg.enums.ToolStats;
import divinerpg.items.vanilla.ItemSlowingSword;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemGlacialBlade extends ItemSlowingSword {
    public ItemGlacialBlade() {
        super(ToolStats.GLACIAL_BLADE);
        slowSeconds = 2;
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if(entity instanceof LivingEntity) ((LivingEntity)entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, slowSeconds * 20, 4));
        return super.onLeftClickEntity(stack, player, entity);
    }
}