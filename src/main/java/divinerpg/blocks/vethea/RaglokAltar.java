package divinerpg.blocks.vethea;

import divinerpg.entities.boss.EntityRaglok;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.RAGLOK;
import static divinerpg.registries.ItemRegistry.dream_flint;

public class RaglokAltar extends VetheaAltar {
    public RaglokAltar(Properties p) {super(p);}
    @Override protected Item acceptedItem() {return dream_flint.get();}
    @Override protected LivingEntity getBoss(Level world) {return new EntityRaglok(RAGLOK.get(), world);}
    @Override protected void onFailure() {}
}