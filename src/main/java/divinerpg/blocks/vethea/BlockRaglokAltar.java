package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRaglokAltar extends BlockVetheaAltar {
    public BlockRaglokAltar() {
        super();
    }

    protected Item acceptedItem() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_flint"));
    }

    protected LivingEntity getBoss(Level world) {
        return new EntityRaglok(EntityRegistry.RAGLOK.get(), world);
    }

    protected void onFailure() {
    }
}
