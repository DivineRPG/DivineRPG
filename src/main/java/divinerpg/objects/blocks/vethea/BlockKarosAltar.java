package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vethea.EntityKaros;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockKarosAltar extends BlockVetheaAltar {
    public BlockKarosAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new EntityKaros(world);
    }

    protected void onFailure() {
    }
}
