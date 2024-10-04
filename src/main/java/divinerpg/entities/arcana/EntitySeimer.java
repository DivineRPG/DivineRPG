package divinerpg.entities.arcana;

import divinerpg.attachments.Arcana;
import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;

public class EntitySeimer extends EntityDivineTameable {
    public EntitySeimer(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 1F);
    }
    @Override
    public void tick() {
        super.tick();
        if(getOwner() != null && getOwner() instanceof ServerPlayer player) Arcana.modifyAmount(player, 1);
    }
}
