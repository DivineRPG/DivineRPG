package divinerpg.entities.vanilla.overworld;

import net.minecraft.entity.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EntityWhiteGrizzle extends EntityBrownGrizzle {
    public <T extends Entity> EntityWhiteGrizzle(EntityType<T> type, World worldIn) {
        super(type, worldIn);
    }
    protected EntityWhiteGrizzle(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }
}
