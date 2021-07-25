package divinerpg.blocks.vethea;

import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class BlockQuadroticAltar extends BlockVetheaAltar {
    public BlockQuadroticAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected LivingEntity getBoss(World world) {
        return new EntityQuadro(EntityRegistry.QUADRO, world);
    }

    protected void onFailure() {
    }
}
