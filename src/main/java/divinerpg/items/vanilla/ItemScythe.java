package divinerpg.items.vanilla;

import divinerpg.entities.projectile.magic.DivineMagicProjectile;
import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.ItemRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;

import static divinerpg.registries.EntityRegistry.SCYTHE_SHOT;
import static divinerpg.registries.SoundRegistry.DEEP_LAUGH;

public class ItemScythe extends ItemRangedWeapon {
    public ItemScythe(Properties properties) {
        super(properties, SCYTHE_SHOT::value);
        sound = DEEP_LAUGH.get();
        cooldown = 10;
        infinite = true;
    }

    private boolean isJackoman(Player player){
        return player.getItemBySlot(EquipmentSlot.FEET).is(ItemRegistry.JACK_O_MAN_BOOTS.get())
                && player.getItemBySlot(EquipmentSlot.LEGS).is(ItemRegistry.JACK_O_MAN_LEGGINGS.get())
                && player.getItemBySlot(EquipmentSlot.CHEST).is(ItemRegistry.JACK_O_MAN_CHESTPLATE.get())
                && player.getItemBySlot(EquipmentSlot.HEAD).is(ItemRegistry.JACK_O_MAN_HELMET.get());
    }

    @Override protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack weapon, ItemStack ammo, boolean isCrit) {
        Projectile shot = super.createProjectile(level, shooter, weapon, ammo, isCrit);
        if(shot instanceof DivineMagicProjectile d && shooter instanceof Player player && isJackoman(player)) d.baseDamage = 6;
        return shot;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(LocalizeUtils.magicDam(6));
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
