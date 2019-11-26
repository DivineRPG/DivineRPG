package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vanilla.EnthralledDramcryx;
import divinerpg.objects.entities.entity.vethea.LadyLuna;
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
        return new LadyLuna(world);
    }

    protected void onFailure() {
    }
}
