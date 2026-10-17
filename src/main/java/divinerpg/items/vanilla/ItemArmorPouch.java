package divinerpg.items.vanilla;

import divinerpg.items.base.ItemMod;
import divinerpg.utils.Utils;
import net.minecraft.ChatFormatting;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
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
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ItemArmorPouch extends ItemMod {
    public ItemArmorPouch(int nameColor, Properties properties) {
        super(properties.stacksTo(1));
        this.nameColor = nameColor;
    }
    @Override
    public boolean isFoil(ItemStack item) {
        return item.isEnchanted() || item.has(DataComponents.CONTAINER);
    }
    @Override
    public void onDestroyed(ItemEntity entity, DamageSource source) {
        ItemStack item = entity.getItem();
        if (item.has(DataComponents.CONTAINER)) {
            ItemContainerContents container = item.get(DataComponents.CONTAINER);
            if (container != null) {
                NonNullList<ItemStack> drops = NonNullList.withSize(container.size(), ItemStack.EMPTY);
                container.copyInto(drops);
                for (ItemStack stack : drops) {
                    if (!stack.isEmpty()) {
                        Utils.drop(entity.level(), entity.position(), stack);
                    }
                }
            }
        }
    }
    @Override
    public boolean onLeftClickEntity(ItemStack itemstack, Player player, Entity entity) {
        if(itemstack.is(this) && entity instanceof ArmorStand stand) {
            ItemStack stack;
            RegistryLookup<Enchantment> enchantmentRegistry = player.level().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            List<ItemStack> container = itemstack.has(DataComponents.CONTAINER) ? getContainerContentsAsList(itemstack.get(DataComponents.CONTAINER)) : createEmptyContainer();
            if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = stand.getItemBySlot(EquipmentSlot.HEAD))) {
                setEntitySlot(stand, EquipmentSlot.HEAD, container.getFirst());
                setContainerSlot(container, 0, stack);
            } if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = stand.getItemBySlot(EquipmentSlot.CHEST))) {
                setEntitySlot(stand, EquipmentSlot.CHEST, container.get(1));
                setContainerSlot(container, 1, stack);
            } if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = stand.getItemBySlot(EquipmentSlot.LEGS))) {
                setEntitySlot(stand, EquipmentSlot.LEGS, container.get(2));
                setContainerSlot(container, 2, stack);
            } if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = stand.getItemBySlot(EquipmentSlot.FEET))) {
                setEntitySlot(stand, EquipmentSlot.FEET, container.get(3));
                setContainerSlot(container, 3, stack);
            } if(isEmptyItemList(container)) itemstack.remove(DataComponents.CONTAINER);
            else itemstack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(container));
            player.setItemInHand(InteractionHand.MAIN_HAND, itemstack);
            player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER.value());
            player.awardStat(Stats.ITEM_USED.get(this));
            return true;
        } return super.onLeftClickEntity(itemstack, player, entity);
    }
    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(!itemstack.is(this)) return InteractionResult.PASS;
        ItemStack stack;
        RegistryLookup<Enchantment> enchantmentRegistry = level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        List<ItemStack> container = itemstack.has(DataComponents.CONTAINER) ? getContainerContentsAsList(itemstack.get(DataComponents.CONTAINER)) : createEmptyContainer();
        if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = player.getItemBySlot(EquipmentSlot.HEAD))) {
            setEntitySlot(player, EquipmentSlot.HEAD, container.getFirst());
            setContainerSlot(container, 0, stack);
        } if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = player.getItemBySlot(EquipmentSlot.CHEST))) {
            setEntitySlot(player, EquipmentSlot.CHEST, container.get(1));
            setContainerSlot(container, 1, stack);
        } if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = player.getItemBySlot(EquipmentSlot.LEGS))) {
            setEntitySlot(player, EquipmentSlot.LEGS, container.get(2));
            setContainerSlot(container, 2, stack);
        } if(!Utils.hasEnchantment(Enchantments.BINDING_CURSE, stack = player.getItemBySlot(EquipmentSlot.FEET))) {
            setEntitySlot(player, EquipmentSlot.FEET, container.get(3));
            setContainerSlot(container, 3, stack);
        } if(isEmptyItemList(container)) itemstack.remove(DataComponents.CONTAINER);
        else itemstack.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(container));
        player.setItemInHand(hand, itemstack);
        player.playSound(SoundEvents.ARMOR_EQUIP_LEATHER.value());
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        if (stack.has(DataComponents.CONTAINER)) {
            ItemContainerContents container = stack.get(DataComponents.CONTAINER);
            if (container != null) {
                NonNullList<ItemStack> contents = NonNullList.withSize(4, ItemStack.EMPTY);
                container.copyInto(contents);
                ItemStack helmet = contents.size() > 0 ? contents.get(0) : ItemStack.EMPTY;
                ItemStack chestplate = contents.size() > 1 ? contents.get(1) : ItemStack.EMPTY;
                ItemStack leggings = contents.size() > 2 ? contents.get(2) : ItemStack.EMPTY;
                ItemStack boots = contents.size() > 3 ? contents.get(3) : ItemStack.EMPTY;
                if (!isEmpty(helmet)) builder.accept(Component.translatable("tooltip.divinerpg.armor_pouch.helmet").append(helmet.getHoverName()).withStyle(ChatFormatting.WHITE));
                if (!isEmpty(chestplate)) builder.accept(Component.translatable("tooltip.divinerpg.armor_pouch.chestplate").append(chestplate.getHoverName()).withStyle(ChatFormatting.WHITE));
                if (!isEmpty(leggings)) builder.accept(Component.translatable("tooltip.divinerpg.armor_pouch.leggings").append(leggings.getHoverName()).withStyle(ChatFormatting.WHITE));
                if (!isEmpty(boots)) builder.accept(Component.translatable("tooltip.divinerpg.armor_pouch.boots").append(boots.getHoverName()).withStyle(ChatFormatting.WHITE));
            }
        }
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
    public void setEntitySlot(LivingEntity entity, EquipmentSlot slot, ItemStack stack) {
        entity.setItemSlot(slot, stack.getItem() instanceof ItemArmorPouch ? ItemStack.EMPTY : stack);
    }
    public void setContainerSlot(List<ItemStack> container, int slot, ItemStack stack) {
        container.set(slot, stack.isEmpty() ? getDefaultInstance() : stack);
    }
    public static boolean isEmpty(ItemStack i) {
        return i.isEmpty() || i.getItem() instanceof ItemArmorPouch;
    }
    public static List<ItemStack> getContainerContentsAsList(ItemContainerContents c) {
        List<ItemStack> result = new ArrayList<>();
        NonNullList<ItemStack> temp = NonNullList.withSize(Math.max(c.getSlots(), 4), ItemStack.EMPTY);
        c.copyInto(temp);
        for (int i = 0; i < 4 && i < temp.size(); i++) {
            result.add(temp.get(i));
        }
        if (result.size() != 4) throw new IllegalArgumentException();
        return result;
    }
    public static boolean isEmptyItemList(List<ItemStack> list) {
        for(ItemStack i : list) if(!isEmpty(i)) return false;
        return true;
    }
    private List<ItemStack> createEmptyContainer() {
        return new ArrayList<>(List.of(getDefaultInstance(), getDefaultInstance(), getDefaultInstance(), getDefaultInstance()));
    }
}