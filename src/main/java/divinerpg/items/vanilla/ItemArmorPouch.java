package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.util.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import java.util.List;

public class ItemArmorPouch extends ItemMod {
	public static final String TAG_HELMET = "divinerpg:helmet", TAG_CHESTPLATE = "divinerpg:chestplate", TAG_LEGGINGS = "divinerpg:leggings", TAG_BOOTS = "divinerpg:boots";
	public ItemArmorPouch(Rarity rarity) {super(new Properties().stacksTo(1).rarity(rarity));}
	@Override public boolean isFoil(ItemStack item) {
		CompoundTag itemTag = item.getOrCreateTag();
		return item.isEnchanted() || !(ItemStack.of(itemTag.getCompound(TAG_HELMET)).isEmpty() && ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)).isEmpty() && ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)).isEmpty() && ItemStack.of(itemTag.getCompound(TAG_BOOTS)).isEmpty());
	}
	@Override public void onDestroyed(ItemEntity entity, DamageSource source) {
		CompoundTag itemTag = entity.getItem().getOrCreateTag();
		Utils.drop(entity.level(), entity.position(), ItemStack.of(itemTag.getCompound(TAG_HELMET)));
		Utils.drop(entity.level(), entity.position(), ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)));
		Utils.drop(entity.level(), entity.position(), ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)));
		Utils.drop(entity.level(), entity.position(), ItemStack.of(itemTag.getCompound(TAG_BOOTS)));
	}
	@Override public boolean onLeftClickEntity(ItemStack itemstack, Player player, Entity entity) {
		if(itemstack.is(this) && entity instanceof ArmorStand stand) {
			CompoundTag itemTag = itemstack.getOrCreateTag();
			ItemStack helmet = ItemStack.of(itemTag.getCompound(TAG_HELMET)), chestplate = ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)), leggings = ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)), boots = ItemStack.of(itemTag.getCompound(TAG_BOOTS));
			ItemStack stack;
			if((stack = stand.getItemBySlot(EquipmentSlot.HEAD)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
				itemTag.put(TAG_HELMET, stack.save(new CompoundTag()));
				stand.setItemSlot(EquipmentSlot.HEAD, helmet);
			} if((stack = stand.getItemBySlot(EquipmentSlot.CHEST)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
				itemTag.put(TAG_CHESTPLATE, stack.save(new CompoundTag()));
				stand.setItemSlot(EquipmentSlot.CHEST, chestplate);
			} if((stack = stand.getItemBySlot(EquipmentSlot.LEGS)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
				itemTag.put(TAG_LEGGINGS, stack.save(new CompoundTag()));
				stand.setItemSlot(EquipmentSlot.LEGS, leggings);
			} if((stack = stand.getItemBySlot(EquipmentSlot.FEET)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
				itemTag.put(TAG_BOOTS, stack.save(new CompoundTag()));
				stand.setItemSlot(EquipmentSlot.FEET, boots);
			} itemstack.setTag(itemTag);
			player.setItemInHand(InteractionHand.MAIN_HAND, itemstack);
			player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
			player.awardStat(Stats.ITEM_USED.get(this));
		} return super.onLeftClickEntity(itemstack, player, entity);
	}
	@Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		if(!itemstack.is(this)) return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		CompoundTag itemTag = itemstack.getOrCreateTag();
		ItemStack helmet = ItemStack.of(itemTag.getCompound(TAG_HELMET)), chestplate = ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)), leggings = ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)), boots = ItemStack.of(itemTag.getCompound(TAG_BOOTS));
	    ItemStack stack;
		if((stack = player.getItemBySlot(EquipmentSlot.HEAD)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
	    	itemTag.put(TAG_HELMET, stack.save(new CompoundTag()));
		    player.setItemSlot(EquipmentSlot.HEAD, helmet);
	    } if((stack = player.getItemBySlot(EquipmentSlot.CHEST)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
		    itemTag.put(TAG_CHESTPLATE, stack.save(new CompoundTag()));
		    player.setItemSlot(EquipmentSlot.CHEST, chestplate);
		} if((stack = player.getItemBySlot(EquipmentSlot.LEGS)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
		    itemTag.put(TAG_LEGGINGS, stack.save(new CompoundTag()));
		    player.setItemSlot(EquipmentSlot.LEGS, leggings);
		} if((stack = player.getItemBySlot(EquipmentSlot.FEET)).getEnchantmentLevel(Enchantments.BINDING_CURSE) == 0) {
		    itemTag.put(TAG_BOOTS, stack.save(new CompoundTag()));
		    player.setItemSlot(EquipmentSlot.FEET, boots);
		} itemstack.setTag(itemTag);
		player.setItemInHand(hand, itemstack);
		player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER);
		player.awardStat(Stats.ITEM_USED.get(this));
		return InteractionResultHolder.success(itemstack);
	}
	@OnlyIn(Dist.CLIENT)
	@Override public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag tooltip) {
		CompoundTag itemTag = itemstack.getOrCreateTag();
		ItemStack helmet = ItemStack.of(itemTag.getCompound(TAG_HELMET)), chestplate = ItemStack.of(itemTag.getCompound(TAG_CHESTPLATE)), leggings = ItemStack.of(itemTag.getCompound(TAG_LEGGINGS)), boots = ItemStack.of(itemTag.getCompound(TAG_BOOTS));
		if(!helmet.isEmpty()) list.add(Component.translatable("tooltip.divinerpg.armor_pouch.helmet").append(helmet.getHoverName()).withStyle(ChatFormatting.WHITE));
		if(!chestplate.isEmpty()) list.add(Component.translatable("tooltip.divinerpg.armor_pouch.chestplate").append(chestplate.getHoverName()).withStyle(ChatFormatting.WHITE));
		if(!leggings.isEmpty()) list.add(Component.translatable("tooltip.divinerpg.armor_pouch.leggings").append(leggings.getHoverName()).withStyle(ChatFormatting.WHITE));
		if(!boots.isEmpty()) list.add(Component.translatable("tooltip.divinerpg.armor_pouch.boots").append(boots.getHoverName()).withStyle(ChatFormatting.WHITE));
		super.appendHoverText(itemstack, level, list, tooltip);
	}
}