package divinerpg.items.iceika;

import divinerpg.items.base.ItemMod;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Vanishable;
import net.minecraft.world.level.Level;

public class ItemHeatPack extends ItemMod implements Vanishable {
	public ItemHeatPack() {
		super(new Properties().defaultDurability(1000));
	}
	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int i, boolean b) {
		if(isActivated(stack)) {
			if(entity instanceof LivingEntity living) {
				if(living.getTicksFrozen() > 2) living.setTicksFrozen(living.getTicksFrozen() - 3);
				stack.hurtAndBreak(1, living, (e) -> {});
			} else {
				stack.setDamageValue(stack.getDamageValue() + 1);
				if(stack.getDamageValue() >= stack.getMaxDamage()) stack.setCount(0);
			}
		}
	}
	@Override
	public boolean isFoil(ItemStack stack) {
		return isActivated(stack);
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack stack = player.getItemInHand(hand);
		if(!isActivated(stack)) {
			stack.getOrCreateTag().putBoolean("activated", true);
			player.playSound(SoundRegistry.SNAP.get());
			return InteractionResultHolder.success(stack);
		} return InteractionResultHolder.pass(stack);
	}
	private static boolean isActivated(ItemStack stack) {
		CompoundTag tag = stack.getTag();
		return tag != null && tag.contains("activated") && tag.getBoolean("activated");
	}
	@Override
	public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
		if(isActivated(stack)) {
			stack.setDamageValue(stack.getDamageValue() + 1);
			if(stack.getDamageValue() >= stack.getMaxDamage()) entity.kill();
		} return false;
	}
}