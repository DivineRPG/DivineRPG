package divinerpg.blocks.vethea;

import divinerpg.entities.boss.EntityLadyLuna;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

import static divinerpg.registries.EntityRegistry.LADY_LUNA;
import static divinerpg.registries.ItemRegistry.moon_clock;
import static net.minecraft.world.level.material.MapColor.COLOR_BLUE;

public class BlockLunicAltar extends BlockVetheaAltar {
    public BlockLunicAltar() {super(COLOR_BLUE);}
    @Override protected Item acceptedItem() {return moon_clock.get();}
    @Override protected LivingEntity getBoss(Level world) {return new EntityLadyLuna(LADY_LUNA.get(), world);}
    @Override protected void onFailure() {}
}