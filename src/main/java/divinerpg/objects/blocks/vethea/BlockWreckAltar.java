package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vanilla.EnthralledDramcryx;
import divinerpg.objects.entities.entity.vethea.Wreck;
import divinerpg.registry.ModItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockWreckAltar extends BlockVetheaAltar {
    public BlockWreckAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ModItems.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new Wreck(world);
    }

    protected void onFailure() {
    }
}
