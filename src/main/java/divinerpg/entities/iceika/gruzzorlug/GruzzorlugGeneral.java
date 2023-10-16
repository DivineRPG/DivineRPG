package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.registries.MobEffectRegistry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class GruzzorlugGeneral extends Gruzzorlug {
	public GruzzorlugGeneral(EntityType<? extends Monster> type, Level worldIn) {
		super(type, worldIn);
		entityData.set(ITEM, 6);
	}
	@Override
	protected TagKey<Item> getAcceptedItems() {
		return Gruzzorlug.KNIGHT_ACCEPTED;
	}
	@Override
	protected String getTradesLocation() {
		return "trades/gruzzorlug_general";
	}
	@Override
	public void modifyReputationOnDeath(DamageSource source) {
		if(source.getDirectEntity() != null && source.getDirectEntity() instanceof LivingEntity entity) entity.addEffect(new MobEffectInstance(MobEffectRegistry.GRUZZORLUG_TARGET.get(), -1, 0, false, false, true));
		if(source.getEntity() != null && source.getEntity() instanceof LivingEntity entity) entity.addEffect(new MobEffectInstance(MobEffectRegistry.GRUZZORLUG_TARGET.get(), -1, 0, false, false, true));
		super.modifyReputationOnDeath(source);
	}
}