package divinerpg.blocks.vethea;

import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class BlockKarosAltar extends BlockVetheaAltar {
    public BlockKarosAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected LivingEntity getBoss(World world) {
        return new EntityKaros(EntityRegistry.KAROS, world);
    }

    protected void onFailure() {
    }
}
