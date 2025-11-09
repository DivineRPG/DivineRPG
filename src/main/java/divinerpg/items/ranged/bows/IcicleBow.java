package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.IcicleArrow;
import divinerpg.items.ranged.ItemBow;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import static divinerpg.enums.ToolStats.ICICLE_BOW;
import static divinerpg.registries.ItemRegistry.icicle_arrow;
import static divinerpg.util.RarityList.ICICLE;
import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.effect.MobEffects.MOVEMENT_SLOWDOWN;
import static net.minecraft.world.item.alchemy.PotionContents.EMPTY;

public class IcicleBow extends ItemBow {
    public final int effectSeconds;
    public IcicleBow() {
        super(ICICLE_BOW, new Properties().component(POTION_CONTENTS, EMPTY.withEffectAdded(new MobEffectInstance(MOVEMENT_SLOWDOWN, 4 * 20, 1))), null, ICICLE);
        effectSeconds = 4;
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        switch(arrow) {
            case IcicleArrow h -> {
                h.powerMultiplier = 1.2F;
                h.addEffect(new MobEffectInstance(MOVEMENT_SLOWDOWN, effectSeconds * 20, 1));
                return arrow;
            } case Arrow a -> addEffect(a, new MobEffectInstance(MOVEMENT_SLOWDOWN, effectSeconds * 20, 1));
            case DivineArrow a -> a.addEffect(new MobEffectInstance(MOVEMENT_SLOWDOWN, effectSeconds * 20, 1));
            default -> {}
        } return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(icicle_arrow.get());
    }
}