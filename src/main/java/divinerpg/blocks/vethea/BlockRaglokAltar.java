package divinerpg.blocks.vethea;

import divinerpg.entities.boss.EntityRaglok;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MapColor;

public class BlockRaglokAltar extends BlockVetheaAltar {
    public BlockRaglokAltar(MapColor color) {
        super(color);
    }

    protected Item acceptedItem() {
        return ItemRegistry.dream_flint.get();
    }

    protected LivingEntity getBoss(Level world) {
        return new EntityRaglok(EntityRegistry.RAGLOK.get(), world);
    }

    protected void onFailure() {
    }
}
