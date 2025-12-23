package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.TagRegistry;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntitySmelter extends EntityDivineTameable {
    public EntitySmelter(EntityType<? extends EntitySmelter> type, Level worldIn) {super(type, worldIn, 1);}
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FOODS_SMELTER);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.PET_TAMING_FOODS_SMELTER);}
    @Override public boolean doHurtTarget(Entity entity) {
        boolean attack = super.doHurtTarget(entity);
        if(attack) {
            entity.setDeltaMovement(-Mth.sin(getXRot() * Mth.DEG_TO_RAD), .1, Mth.cos(getXRot() * Mth.DEG_TO_RAD));
            entity.igniteForSeconds(5);
        } return attack;
    }
    @Override
    public void aiStep() {
        updateSwingTime();
        super.aiStep();
    }
}