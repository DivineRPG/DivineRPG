package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vethea.Raglok;
import divinerpg.registry.ModItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockRaglokAltar extends BlockVetheaAltar {
    public BlockRaglokAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ModItems.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new Raglok(world);
    }

    protected void onFailure() {
    }
}
