package divinerpg.blocks.vethea;

import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.world.*;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar(String name) {
        super(name);
    }

    protected Item acceptedItem() {
        return ItemRegistry.moonClock;
    }

    protected LivingEntity getBoss(World world) {
        return new EntityLadyLuna(EntityRegistry.LADY_LUNA, world);
    }

    protected void onFailure() {
    }
}
