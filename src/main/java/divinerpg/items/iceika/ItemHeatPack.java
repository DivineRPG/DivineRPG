package divinerpg.items.iceika;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.DataComponentRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jspecify.annotations.Nullable;

import static divinerpg.registries.SoundRegistry.SNAP;
import static net.minecraft.stats.Stats.ITEM_USED;

public class ItemHeatPack extends ItemMod {
    public ItemHeatPack(Properties properties) {super(properties.durability(1000));}

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity owner, @Nullable EquipmentSlot slot) {
        if(isActivated(stack)) {
            if(owner instanceof LivingEntity living) {
                if(living.getTicksFrozen() > 2) living.setTicksFrozen(living.getTicksFrozen() - 3);
                stack.hurtAndBreak(1, living, living.getUsedItemHand());
            } else {
                stack.setDamageValue(stack.getDamageValue() + 1);
                if(stack.getDamageValue() >= stack.getMaxDamage()) stack.setCount(0);
            }
        }
    }
    @Override public boolean isFoil(ItemStack stack) {return isActivated(stack);}
    @Override public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if(!isActivated(stack)) {
            stack.set(DataComponentRegistry.activated, true);
            player.playSound(SNAP.get());
            player.awardStat(ITEM_USED.get(this));
            return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
    private static boolean isActivated(ItemStack stack) {
        return stack.has(DataComponentRegistry.activated) && stack.get(DataComponentRegistry.activated);
    }
    @Override public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        if(isActivated(stack)) {
            stack.setDamageValue(stack.getDamageValue() + 1);
            if(stack.getDamageValue() >= stack.getMaxDamage()) entity.remove(Entity.RemovalReason.KILLED);
        } return false;
    }
}