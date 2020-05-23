package divinerpg.objects.blocks.twilight;

import divinerpg.objects.blocks.BlockModDoubleCrop;
import divinerpg.registry.ItemRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockPinkGlowbone extends BlockModDoubleCrop {
    public BlockPinkGlowbone() {
        super("pink_glowbone_plant");
    }

    public Item getSeedDrop() {
        return ItemRegistry.pinkGlowboneSeeds;
    }

    public Item getFlowerDrop() {
        return ItemRegistry.pinkGlowbone;
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Plains;
    }
}