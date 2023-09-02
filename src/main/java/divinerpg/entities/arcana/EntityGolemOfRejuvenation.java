package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EntityGolemOfRejuvenation extends EntityDivineTameable {
    private int healTimer;
    public EntityGolemOfRejuvenation(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
        healTimer = 0;
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.375F;}
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GOLEM.get();
    }
    @Override
    public boolean isFood(ItemStack item) {
    	return item.is(ItemTags.STONE_CRAFTING_MATERIALS);
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(ItemTags.STONE_CRAFTING_MATERIALS);
    }
    @Override
    public void tick() {
        super.tick();
        if(getOwner() != null) {
            if(healTimer == 16) {
                getOwner().heal(1);
                healTimer = 0;
            } else healTimer++;
        }
    }
}
