package divinerpg.entities.vanilla.overworld;

import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import net.minecraft.world.entity.EntityType;

public class EntityWhiteGrizzle extends EntityBrownGrizzle {
    public EntityWhiteGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn);
    }
    protected EntityWhiteGrizzle(EntityType<? extends TamableAnimal> type, Level worldIn, Player player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
    }
}