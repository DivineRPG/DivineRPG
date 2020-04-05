package divinerpg.objects.entities.entity.vanilla;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityBrownGrizzle extends EntityWhiteGrizzle {
    public EntityBrownGrizzle(World worldIn) {
        super(worldIn);
    }

    public EntityBrownGrizzle(World worldIn, EntityPlayer player) {
        super(worldIn, player);
    }
}
