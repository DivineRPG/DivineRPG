package divinerpg.items.arcana;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.capability.*;
import divinerpg.items.base.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemArcanaPoweredSword extends ItemModSword {

    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130002");
    public int arcanaConsumed;
    public float weakenedDamageValue;

    public ItemArcanaPoweredSword(String name, IItemTier tier, int arcanaConsumed, float weakenedDamageValue) {
        super(name, tier, DivineRPG.tabs.melee);
        this.arcanaConsumed = arcanaConsumed;
        this.weakenedDamageValue = weakenedDamageValue;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", weakenedDamageValue, AttributeModifier.Operation.ADDITION));
        this.attributeModifiers = builder.build();
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        IArcana arcana = player.getCapability(ArcanaProvider.ARCANA_CAP).orElse(null);
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