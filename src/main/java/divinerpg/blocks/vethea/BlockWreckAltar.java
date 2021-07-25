package divinerpg.blocks.vethea;

import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class BlockWreckAltar extends BlockVetheaAltar {
    public BlockWreckAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dreamFlint;
    }

    protected LivingEntity getBoss(World world) {
        return new EntityWreck(EntityRegistry.WRECK, world);
    }

    protected void onFailure() {
    }
}
