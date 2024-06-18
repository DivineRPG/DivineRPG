package divinerpg.items.arcana;

import java.util.UUID;

import divinerpg.items.base.ItemModSword;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;

public class ItemArcanaPoweredSword extends ItemModSword {
	protected static final UUID ATTACK_MODIFIER = UUID.fromString("de0e83e8-d7ff-11eb-b8bc-0242ac130001");
    private final AttributeModifier EMPOWERED_DAMAGE_MODIFIER;
    public ItemArcanaPoweredSword(Tier tier, int arcanaConsumed, float empoweredDamage) {
        super(tier);
        arcanaConsumedAttack = arcanaConsumed;
        EMPOWERED_DAMAGE_MODIFIER = new AttributeModifier(ATTACK_MODIFIER, "ArcanicDamage", empoweredDamage, AttributeModifier.Operation.ADDITION);
    }
    @Override
    protected boolean preArcanicAttack(ItemStack stack, Player player, Entity entity) {
    	player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(EMPOWERED_DAMAGE_MODIFIER);
    	player.getAttribute(Attributes.ATTACK_DAMAGE).addTransientModifier(EMPOWERED_DAMAGE_MODIFIER);
    	return false;
    }
    @Override
    protected void postArcanicAttack(ItemStack stack, Player player, Entity entity) {
    	player.getAttribute(Attributes.ATTACK_DAMAGE).removeModifier(EMPOWERED_DAMAGE_MODIFIER);
    }
}