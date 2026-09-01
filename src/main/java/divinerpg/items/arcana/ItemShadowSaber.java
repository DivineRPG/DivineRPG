package divinerpg.items.arcana;

import divinerpg.items.base.ItemModSword;
import divinerpg.registries.SoundRegistry;
import divinerpg.utils.ToolStats;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ItemShadowSaber extends ItemModSword {
    public ItemShadowSaber(Properties properties) {
        super(ToolStats.SHADOW_SABER, properties);
    arcanaConsumedAttack = 12;
    }

    @Override
    public void arcanicAttack(ItemStack stack, Player player, Entity entity) {
        player.level().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundRegistry.SHADOW_SABER.get(), SoundSource.PLAYERS, 1, 1);
        player.addEffect(new MobEffectInstance(MobEffects.SPEED, sword.effectSec * 20, 1));
    }
}
