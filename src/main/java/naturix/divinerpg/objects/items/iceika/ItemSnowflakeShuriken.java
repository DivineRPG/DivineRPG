package naturix.divinerpg.objects.items.iceika;

import naturix.divinerpg.objects.entities.entity.projectiles.EntitySnowflakeShuriken;
import naturix.divinerpg.objects.items.ItemThrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

public class ItemSnowflakeShuriken extends ItemThrowable {
    public ItemSnowflakeShuriken(String name, float damage) {
        super(name, damage);
    }

    public EntityThrowable createThrowableEntity(World worldIn, EntityPlayer playerIn, float damage) {
        return new EntitySnowflakeShuriken(worldIn, playerIn);
    }
}