package naturix.divinerpg.objects.blocks.twilight;

import naturix.divinerpg.objects.blocks.BlockModDoubleCrop;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSeeds;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPurpleGlowbone extends BlockModDoubleCrop {
    public BlockPurpleGlowbone() {
        super("purple_glowbone_plant");
    }

    public Item getSeedDrop() {
        return ModSeeds.purpleGlowboneSeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.purpleGlowbone;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
}