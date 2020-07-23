package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.boss.EntityRaglok;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockRaglokAltar extends BlockVetheaAltar {
    public BlockRaglokAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new EntityRaglok(world);
    }

    protected void onFailure() {
    }
}
