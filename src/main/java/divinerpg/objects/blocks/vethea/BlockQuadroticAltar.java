package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.boss.EntityQuadro;
import divinerpg.registry.ItemRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockQuadroticAltar extends BlockVetheaAltar {
    public BlockQuadroticAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new EntityQuadro(world);
    }

    protected void onFailure() {
    }
}
