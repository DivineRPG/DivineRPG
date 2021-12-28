package divinerpg.items.arcana;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import divinerpg.DivineRPG;
import divinerpg.capability.Arcana;
import divinerpg.capability.ArcanaCapability;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import divinerpg.util.RarityList;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class ItemArcanaPoweredSword extends ItemModSword {

    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130002");
    public int arcanaConsumed;
    public float weakenedDamageValue;

    public ItemArcanaPoweredSword(String name, IItemTier tier, int arcanaConsumed, float weakenedDamageValue) {
        super(name, RarityList.COMMON, tier, DivineRPG.tabs.melee);
        this.arcanaConsumed = arcanaConsumed;
        this.weakenedDamageValue = weakenedDamageValue;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", weakenedDamageValue, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        Arcana arcana = player.getCapability(ArcanaCapability.CAPABILITY_ARCANA).orElse(null);
        if (!player.level.isClientSide && entity instanceof LivingEntity && arcana.getArcana() >= arcanaConsumed) {
            arcana.consume(player, arcanaConsumed);
        }
        return super.onLeftClickEntity(stack, player, entity);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        if (world.getGameTime() % 10 == 0 && entity instanceof LivingEntity) {
                if (entity instanceof PlayerEntity) {
                    PlayerEntity player = (PlayerEntity) entity;
                    player.getAttributes().removeAttributeModifiers(getAttributeModifiers(EquipmentSlotType.MAINHAND, stack));
                    player.getAttributes().addTransientAttributeModifiers(getAttributeModifiers(EquipmentSlotType.MAINHAND, stack));
                } else {
                    LivingEntity entityLivingBase = (LivingEntity) entity;

                    entityLivingBase.getAttributes().removeAttributeModifiers(getAttributeModifiers(EquipmentSlotType.MAINHAND, stack));
                    entityLivingBase.getAttributes().addTransientAttributeModifiers(getAttributeModifiers(EquipmentSlotType.MAINHAND, stack));
                }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        return equipmentSlot == EquipmentSlotType.OFFHAND ? this.attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);
    }
    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(LocalizeUtils.arcanaConsumed(arcanaConsumed));
        tooltip.add(LocalizeUtils.weakenedWithoutArcana());
    }
}