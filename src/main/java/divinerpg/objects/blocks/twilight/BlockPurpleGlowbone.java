package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModDoubleCrop;
import divinerpg.registry.ModItems;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPurpleGlowbone extends BlockModDoubleCrop {
    public BlockPurpleGlowbone() {
        super("purple_glowbone_plant");
    }

    public Item getSeedDrop() {
        return ModItems.purpleGlowboneSeeds;
    }

    public Item getFlowerDrop() {
        return ModItems.purpleGlowbone;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Beach;
    }
}