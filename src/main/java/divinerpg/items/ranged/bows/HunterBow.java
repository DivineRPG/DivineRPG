package divinerpg.items.ranged.bows;

import divinerpg.entities.projectile.DivineArrow;
import divinerpg.entities.projectile.arrows.HunterArrow;
import divinerpg.items.ranged.ItemBow;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import org.jetbrains.annotations.Nullable;

import static divinerpg.registries.ItemRegistry.hunter_arrow;
import static divinerpg.utils.RarityList.GREEN;
import static divinerpg.utils.ToolStats.HUNTER_BOW;
import static net.minecraft.core.component.DataComponents.POTION_CONTENTS;
import static net.minecraft.world.effect.MobEffects.POISON;

public class HunterBow extends ItemBow {
    public final int effectSeconds;
    public HunterBow(Properties properties) {
        super(HUNTER_BOW, properties.component(POTION_CONTENTS, PotionContents.EMPTY.withEffectAdded(new MobEffectInstance(POISON, 2 * 20, 3))), null, GREEN);
        effectSeconds = 2;
    }
    @Override public AbstractArrow customArrow(AbstractArrow arrow, ItemStack projectileStack, ItemStack weaponStack) {
        switch(arrow) {
            case HunterArrow h -> {
                h.powerMultiplier = 1.2F;
                return arrow;
            } case Arrow a -> addEffect(a, new MobEffectInstance(POISON, effectSeconds * 20, 3));
            case DivineArrow a -> a.addEffect(new MobEffectInstance(POISON, effectSeconds * 20, 3));
            default -> {}
        } return arrow;
    }
    @Override public ItemStack getDefaultCreativeAmmo(@Nullable Player player, ItemStack projectileWeaponItem) {
        return new ItemStack(hunter_arrow.get());
    }
}