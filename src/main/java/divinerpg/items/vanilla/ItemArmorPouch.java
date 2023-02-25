package divinerpg.items.vanilla;

import java.util.List;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class ItemArmorPouch extends ItemMod {
	public static final String TAG_HELMET = "divinerpg:helmet", TAG_CHESTPLATE = "divinerpg:chestplate", TAG_LEGGINGS = "divinerpg:leggings", TAG_BOOTS = "divinerpg:boots";
	public final ChatFormatting color;
	public ItemArmorPouch(ChatFormatting color) {
		super(new Item.Properties().tab(DivineRPG.tabs.utilities).stacksTo(1));
		this.color = color;
	}
	@Override
	public boolean isFoil(ItemStack item) {
		CompoundTag itemTag = item.getOrCreateTag();
		return item.isEnchanted() || !(ItemStack.of(itemTag.getCompound(TAG_HELMET)).isEmpty() && ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)).isEmpty() && ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)).isEmpty() && ItemStack.of(itemTag.getCompound(TAG_BOOTS)).isEmpty());
	}
	@Override
	public Component getName(ItemStack item) {
		return Component.translatable(getDescriptionId(item)).withStyle(color);
	}
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltip) {
		CompoundTag itemTag = itemstack.getOrCreateTag();
		ItemStack helmet = ItemStack.of(itemTag.getCompound(TAG_HELMET)), chestplate = ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)), leggings = ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)), boots = ItemStack.of(itemTag.getCompound(TAG_BOOTS));
	    if(!helmet.isEmpty()) list.add(Component.translatable("item.divinerpg.armor_pouch.helmet").append(helmet.getHoverName()).withStyle(ChatFormatting.GRAY));
	    if(!chestplate.isEmpty()) list.add(Component.translatable("item.divinerpg.armor_pouch.chestplate").append(chestplate.getHoverName()).withStyle(ChatFormatting.GRAY));
	    if(!leggings.isEmpty()) list.add(Component.translatable("item.divinerpg.armor_pouch.leggings").append(leggings.getHoverName()).withStyle(ChatFormatting.GRAY));
	    if(!boots.isEmpty()) list.add(Component.translatable("item.divinerpg.armor_pouch.boots").append(boots.getHoverName()).withStyle(ChatFormatting.GRAY));
	}
	public void onDestroyed(ItemEntity entity) {
		CompoundTag itemTag = entity.getItem().getOrCreateTag();
		Utils.drop(entity.level, entity.position(), ItemStack.of(itemTag.getCompound(TAG_HELMET)));
		Utils.drop(entity.level, entity.position(), ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)));
		Utils.drop(entity.level, entity.position(), ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)));
		Utils.drop(entity.level, entity.position(), ItemStack.of(itemTag.getCompound(TAG_BOOTS)));
	}
	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if(!itemstack.is(this)) return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		CompoundTag itemTag = itemstack.getOrCreateTag();
		ItemStack helmet = ItemStack.of(itemTag.getCompound(TAG_HELMET)), chestplate = ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)), leggings = ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)), boots = ItemStack.of(itemTag.getCompound(TAG_BOOTS));
	    itemTag.put(TAG_HELMET, player.getItemBySlot(EquipmentSlot.HEAD).save(new CompoundTag()));
	    itemTag.put(TAG_CHESTPLATE, player.getItemBySlot(EquipmentSlot.CHEST).save(new CompoundTag()));
	    itemTag.put(TAG_LEGGINGS, player.getItemBySlot(EquipmentSlot.LEGS).save(new CompoundTag()));
	    itemTag.put(TAG_BOOTS, player.getItemBySlot(EquipmentSlot.FEET).save(new CompoundTag()));
	    player.setItemSlot(EquipmentSlot.HEAD, helmet);
	    player.setItemSlot(EquipmentSlot.CHEST, chestplate);
	    player.setItemSlot(EquipmentSlot.LEGS, leggings);
	    player.setItemSlot(EquipmentSlot.FEET, boots);
		itemstack.setTag(itemTag);
		player.setItemInHand(hand, itemstack);
		player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
		return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
	}
	@Override
	public boolean onLeftClickEntity(ItemStack itemstack, Player player, Entity entity) {
		if(itemstack.is(this) && entity instanceof ArmorStand) {
			CompoundTag itemTag = itemstack.getOrCreateTag();
			ItemStack helmet = ItemStack.of(itemTag.getCompound(TAG_HELMET)), chestplate = ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)), leggings = ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)), boots = ItemStack.of(itemTag.getCompound(TAG_BOOTS));
			itemTag.put(TAG_HELMET, ((ArmorStand) entity).getItemBySlot(EquipmentSlot.HEAD).save(new CompoundTag()));
		    itemTag.put(TAG_CHESTPLATE, ((ArmorStand) entity).getItemBySlot(EquipmentSlot.CHEST).save(new CompoundTag()));
		    itemTag.put(TAG_LEGGINGS, ((ArmorStand) entity).getItemBySlot(EquipmentSlot.LEGS).save(new CompoundTag()));
		    itemTag.put(TAG_BOOTS, ((ArmorStand) entity).getItemBySlot(EquipmentSlot.FEET).save(new CompoundTag()));
		    ((ArmorStand) entity).setItemSlot(EquipmentSlot.HEAD, helmet);
		    ((ArmorStand) entity).setItemSlot(EquipmentSlot.CHEST, chestplate);
		    ((ArmorStand) entity).setItemSlot(EquipmentSlot.LEGS, leggings);
		    ((ArmorStand) entity).setItemSlot(EquipmentSlot.FEET, boots);
		    itemstack.setTag(itemTag);
		    player.setItemInHand(InteractionHand.MAIN_HAND, itemstack);
			player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
			return true;
		} return false;
	}
}