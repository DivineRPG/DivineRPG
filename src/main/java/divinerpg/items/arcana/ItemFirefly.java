package divinerpg.items.arcana;

import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ItemFirefly extends ItemRangedWeapon {
    public ItemFirefly(Properties properties) {
        super(properties.durability(1216), EntityRegistry.FIREFLY::get);
    sound = SoundRegistry.FIREFLY.get();
    cooldown = 30;
    arcanaConsumedUse = 25;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        builder.accept(LocalizeUtils.arcanaDam(8));
        builder.accept(LocalizeUtils.homingShots());
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
