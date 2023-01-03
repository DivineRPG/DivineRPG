package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.*;
import divinerpg.registries.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar() {
        super();
    }

    protected Item acceptedItem() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "moon_clock"));
    }

    protected LivingEntity getBoss(Level world) {
        return new EntityLadyLuna(EntityRegistry.LADY_LUNA.get(), world);
    }

    protected void onFailure() {
    }
}
