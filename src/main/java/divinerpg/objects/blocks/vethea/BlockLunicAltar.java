package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vethea.EntityLadyLuna;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.moonClock;
    }

    protected EntityLiving getBoss(World world) {
        return new EntityLadyLuna(world);
    }

    protected void onFailure() {
    }
}
