package divinerpg.objects.blocks.vethea;

import divinerpg.objects.entities.entity.vanilla.EnthralledDramcryx;
import divinerpg.objects.entities.entity.vethea.Quadro;
import divinerpg.registry.ModItems;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockQuadroticAltar extends BlockVetheaAltar {
    public BlockQuadroticAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ModItems.dreamFlint;
    }

    protected EntityLiving getBoss(World world) {
        return new Quadro(world);
    }

    protected void onFailure() {
    }
}
