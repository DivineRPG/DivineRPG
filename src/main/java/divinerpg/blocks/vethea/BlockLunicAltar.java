package divinerpg.blocks.vethea;

import divinerpg.entities.boss.EntityLadyLuna;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.ItemRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MapColor;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar(MapColor color) {
        super(color);
    }

    protected Item acceptedItem() {
        return ItemRegistry.moon_clock.get();
    }

    protected LivingEntity getBoss(Level world) {
        return new EntityLadyLuna(EntityRegistry.LADY_LUNA.get(), world);
    }

    protected void onFailure() {
    }
}