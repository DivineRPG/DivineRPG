package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.EntityLadyLuna;
import divinerpg.registries.EntityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar(MaterialColor color) {
        super(color);
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