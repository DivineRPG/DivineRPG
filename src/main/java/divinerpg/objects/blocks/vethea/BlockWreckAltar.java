package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vethea.EntityWreck;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockWreckAltar extends BlockVetheaAltar {
    public BlockWreckAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new EntityWreck(world);
    }

    protected void onFailure() {
    }
}
