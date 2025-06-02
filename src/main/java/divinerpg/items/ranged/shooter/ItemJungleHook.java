package divinerpg.items.ranged.shooter;

import divinerpg.items.ranged.ItemRangedWeapon;
import divinerpg.registries.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ItemJungleHook extends ItemRangedWeapon {
    public ItemJungleHook(){
        super(TagRegistry.ROPE, Items.LEAD::getDefaultInstance, EntityRegistry.HOOK::value, 100);
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(stack.getDamageValue() >= stack.getMaxDamage() - 1) {
            stack.hurtAndBreak(1, player, player.getEquipmentSlotForItem(stack));
            return InteractionResultHolder.consume(stack);
        } if(AttachmentRegistry.HOOKED.get(player)) {
            player.startUsingItem(hand);
            return InteractionResultHolder.pass(player.getItemInHand(hand));
        } return super.use(level, player, hand);
    }
    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BLOCK;
    }
}
