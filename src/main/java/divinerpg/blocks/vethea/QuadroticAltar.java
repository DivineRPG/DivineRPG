package divinerpg.blocks.vethea;

import divinerpg.entities.boss.EntityQuadro;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.QUADRO;
import static divinerpg.registries.ItemRegistry.dream_flint;

public class QuadroticAltar extends VetheaAltar {
    public QuadroticAltar(Properties p) {super(p);}
    @Override protected Item acceptedItem() {return dream_flint.get();}
    @Override protected LivingEntity getBoss(Level world) {return new EntityQuadro(QUADRO.get(), world);}
    @Override protected void onFailure() {}
}