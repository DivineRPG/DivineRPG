package divinerpg.objects.items.arcana;

import divinerpg.objects.items.base.ItemMod;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class ItemOrbOfLight extends ItemMod {

    public ItemOrbOfLight() {
        super("orb_of_light");
        setCreativeTab(DivineRPGTabs.utility);
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int var4, boolean var5) {
        // todo optimize
        if (world.getTotalWorldTime() % 2 == 0) {
            world.setLightFor(EnumSkyBlock.BLOCK, entity.getPosition(), 15);

            BlockPos.getAllInBoxMutable(entity.getPosition().add(-1, -1, -1), entity.getPosition().add(1, 1, 1))
                    .forEach(x -> world.checkLightFor(EnumSkyBlock.BLOCK, x));
        }
    }
}