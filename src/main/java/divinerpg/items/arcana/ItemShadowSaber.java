package divinerpg.items.arcana;

import divinerpg.enums.ToolStats;
import divinerpg.items.base.ItemModSword;
import divinerpg.registries.SoundRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

public class ItemShadowSaber extends ItemModSword {
    public ItemShadowSaber() {
        super(ToolStats.SHADOW_SABER);
        arcanaConsumedAttack = 12;
    }
    @Override
    public void arcanicAttack(ItemStack stack, Player player, Entity entity) {
    	player.playSound(SoundRegistry.SHADOW_SABER.get(), 1, 1);
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sword.effectSec * 20, 1));
    }
}