package divinerpg.entities.iceika.gruzzorlug;

import divinerpg.DivineRPG;
import divinerpg.entities.iceika.EntityIceikaNPC;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

public abstract class Gruzzorlug extends EntityIceikaNPC {
	public static final TagKey<Structure> RAID_TARGETS = TagKey.create(Registries.STRUCTURE, new ResourceLocation(DivineRPG.MODID, "gruzzorlug_raid_targets"));
	public static final TagKey<Item>
		MINER_ACCEPTED = TagKey.create(Registries.ITEM, new ResourceLocation(DivineRPG.MODID, "gruzzorlug_miner_tradeable")),
		KNIGHT_ACCEPTED = TagKey.create(Registries.ITEM, new ResourceLocation(DivineRPG.MODID, "gruzzorlug_knight_tradeable"));
	public Gruzzorlug(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
	@Override
	public Faction getFaction() {
		return Faction.GRUZZORLUG;
	}
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.97F;
    }
	@Override
	protected TagKey<Structure> getRaidTargets() {
		return RAID_TARGETS;
	}
	@Override
	protected MobEffect getTargetEffect() {
		return MobEffectRegistry.GRUZZORLUG_TARGET.get();
	}
}