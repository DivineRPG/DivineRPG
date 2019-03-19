package naturix.divinerpg.objects.items.vanilla;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityShuriken;
import naturix.divinerpg.objects.items.ItemThrowable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.world.World;

public class ItemShuriken extends ItemThrowable {
    public ItemShuriken(String name, float damage) {
        super(name, damage);
    }

    public EntityThrowable createThrowableEntity(World worldIn, EntityPlayer playerIn, float damage) {
        return new EntityShuriken(worldIn, playerIn);
    }
}