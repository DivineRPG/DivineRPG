package divinerpg.entities.boss.ayeraco;

import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityAyeracoYellow extends EntityAyeraco {

    public EntityAyeracoYellow(EntityType<? extends Entity> type, World worldIn) {
        super(type, worldIn);
    }

    public EntityAyeracoYellow(EntityType<? extends MobEntity> type, World world, BlockPos beam, ResourceLocation loot) {
        super(type, world, beam);
    }
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
}
