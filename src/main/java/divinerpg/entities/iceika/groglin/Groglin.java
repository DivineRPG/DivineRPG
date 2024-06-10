package divinerpg.entities.iceika.groglin;

import divinerpg.DivineRPG;
import divinerpg.entities.iceika.EntityIceikaNPC;
import divinerpg.registries.MobEffectRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.Structure;

public abstract class Groglin extends EntityIceikaNPC {
	public static final TagKey<Structure> RAID_TARGETS = TagKey.create(Registries.STRUCTURE, new ResourceLocation(DivineRPG.MODID, "groglin_raid_targets"));
	public Groglin(EntityType<? extends Groglin> type, Level worldIn) {super(type, worldIn);}
	@Override public Faction getFaction() {return Faction.GROGLIN;}
	@Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.18F;}
	@Override protected TagKey<Structure> getRaidTargets() {return RAID_TARGETS;}
	@Override protected MobEffect getTargetEffect() {return MobEffectRegistry.GROGLIN_BOUNTY.get();}
}