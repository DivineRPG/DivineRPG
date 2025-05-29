package divinerpg.items.arcana;

import divinerpg.enums.ToolStats;
import divinerpg.items.base.ItemModSword;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemShadowSaber extends ItemModSword {
    public ItemShadowSaber() {
        super(ToolStats.SHADOW_SABER);
        arcanaConsumedAttack = 12;
    }
    //TODO: to make this effect apply and sound play only when you hurt an entity, rather than everytime you hit it
    @Override public void arcanicAttack(ItemStack stack, Player player, Entity entity) {
        player.level().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundRegistry.SHADOW_SABER.get(), SoundSource.PLAYERS, 1, 1);
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, sword.effectSec * 20, 1));
    }
}