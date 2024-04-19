package divinerpg.items.arcana;

import com.google.common.collect.*;
import divinerpg.capability.ArcanaProvider;
import divinerpg.items.base.ItemModSword;
import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.*;

public class ItemArcanaPoweredSword extends ItemModSword {
    protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130002");
    private final Multimap<Attribute, AttributeModifier> attributeModifiers;
    public int weakenedDamageValue;
    public ItemArcanaPoweredSword(Tier tier, int arcanaConsumed, int weakenedDamageValue) {
        super(tier);
        this.arcanaConsumed = arcanaConsumed;
        this.weakenedDamageValue = weakenedDamageValue;
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_MODIFIER, "Weapon attack", weakenedDamageValue, AttributeModifier.Operation.ADDITION));
        attributeModifiers = builder.build();
    }
    @Override public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
            if(arcana.getArcana() < arcanaConsumed) {
                arcana.consume(player, arcanaConsumed);
                //To fix: weakened damage for powered swords
//                if (entity instanceof Player) {
//                    Player player = (Player) entity;
//                    player.getAttributes().removeAttributeModifiers(getAttributeModifiers(EquipmentSlot.MAINHAND, stack));
//                    player.getAttributes().addTransientAttributeModifiers(getAttributeModifiers(EquipmentSlot.MAINHAND, stack));
//                } else {
//                    LivingEntity entityLivingBase = (LivingEntity) entity;
//
//                    entityLivingBase.getAttributes().removeAttributeModifiers(getAttributeModifiers(EquipmentSlot.MAINHAND, stack));
//                    entityLivingBase.getAttributes().addTransientAttributeModifiers(getAttributeModifiers(EquipmentSlot.MAINHAND, stack));
//                }
            }
        }); return super.onLeftClickEntity(stack, player, entity);
    }
    @Override public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {return equipmentSlot == EquipmentSlot.OFFHAND ? attributeModifiers : super.getAttributeModifiers(equipmentSlot, stack);}
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.weakenedWithoutArcana());
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}