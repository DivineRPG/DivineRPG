package divinerpg.entities.arcana;

import divinerpg.capability.ArcanaProvider;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntitySeimer extends EntityDivineTameable {
    public EntitySeimer(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return .6F;}
    @Override
    public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof Player)
            getOwner().getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                arcana.fill((Player) getOwner(), 1);
            });
    }
}
