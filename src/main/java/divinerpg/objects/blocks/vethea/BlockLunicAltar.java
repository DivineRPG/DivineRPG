package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vanilla.EnthralledDramcryx;
import divinerpg.registry.ModItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ModItems.moonClock;
    }

    protected EntityLiving getBoss(World world) {
        return new EnthralledDramcryx(world);
    }

    protected void onFailure() {
    }
}
