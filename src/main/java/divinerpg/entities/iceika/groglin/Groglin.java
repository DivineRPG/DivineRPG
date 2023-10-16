package divinerpg.entities.iceika.groglin;

import divinerpg.DivineRPG;
import divinerpg.entities.iceika.EntityIceikaNPC;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public abstract class Groglin extends EntityIceikaNPC {
	public static final TagKey<Item>
		WARRIOR_ACCEPTED = TagKey.create(Registries.ITEM, new ResourceLocation(DivineRPG.MODID, "groglin_warrior_tradeable")),
		HUNTER_ACCEPTED = TagKey.create(Registries.ITEM, new ResourceLocation(DivineRPG.MODID, "groglin_hunter_tradeable")),
		MERCHANT_ACCEPTED = TagKey.create(Registries.ITEM, new ResourceLocation(DivineRPG.MODID, "groglin_merchant_tradeable"));
	public Groglin(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
	@Override public Faction getFaction() {
		return Faction.GROGLIN;
	}
	protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.18F;
    }
}