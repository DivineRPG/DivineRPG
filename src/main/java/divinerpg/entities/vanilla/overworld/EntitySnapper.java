package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.*;
import net.minecraft.tags.ItemTags;

import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntitySnapper extends EntityDivineTameable {
    public EntitySnapper(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    protected EntitySnapper(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn, 1F);
        tame(player);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .4F;}
    @Override
    public boolean isFood(ItemStack item) {
    	return item.is(ItemTags.FISHES);
    }
    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(ItemTags.FISHES);
    }
    @Override
    public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof Player) if(random.nextInt(3000) == 0) getOwner().addEffect(new MobEffectInstance(MobEffects.SATURATION, 5));
    }
}
