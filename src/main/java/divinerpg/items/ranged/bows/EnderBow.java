package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.EnderArrow;
import divinerpg.items.ranged.ItemBow;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.ItemRegistry.ender_arrow;
import static divinerpg.registries.MobEffectRegistry.ENDER_ATTACHMENT;
import static divinerpg.utils.RarityList.ENDER;
import static divinerpg.utils.ToolStats.ENDER_BOW;

public class EnderBow extends ItemBow {
    public EnderBow(Properties properties) {super(ENDER_BOW, properties, ender_arrow, ENDER);}
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        if(arrow instanceof DivineArrow a) {
            a.addEffect(new MobEffectInstance(ENDER_ATTACHMENT, 1));
            if(a instanceof EnderArrow) a.powerMultiplier = speedScale;
        } return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(ender_arrow.get());
    }
}