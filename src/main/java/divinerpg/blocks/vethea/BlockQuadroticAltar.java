package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.entities.boss.EntityQuadro;
import divinerpg.registries.EntityRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockQuadroticAltar extends BlockVetheaAltar {
    public BlockQuadroticAltar(MapColor color) {
        super(color);
    }

    protected Item acceptedItem() {
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "dream_flint"));
    }

    protected LivingEntity getBoss(Level world) {
        return new EntityQuadro(EntityRegistry.QUADRO.get(), world);
    }

    protected void onFailure() {
    }
}