package divinerpg.blocks.vethea;

import divinerpg.entities.boss.EntityWreck;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.WRECK;
import static divinerpg.registries.ItemRegistry.dream_flint;
import static net.minecraft.world.level.material.MapColor.COLOR_RED;

public class BlockWreckAltar extends BlockVetheaAltar {
    public BlockWreckAltar() {super(COLOR_RED);}
    @Override protected Item acceptedItem() {return dream_flint.get();}
    @Override protected LivingEntity getBoss(Level world) {return new EntityWreck(WRECK.get(), world);}
    @Override protected void onFailure() {}
}