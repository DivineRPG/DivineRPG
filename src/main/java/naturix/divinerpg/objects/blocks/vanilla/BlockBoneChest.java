package naturix.divinerpg.objects.blocks.vanilla;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.BlockModChest;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityBoneChest;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBoneChest extends BlockModChest {

    public BlockBoneChest(String name) {
        super(name, Material.ROCK, GUIHandler.BONE_CHEST_GUI_ID);
        setSoundType(SoundType.STONE);
        setHardness(4);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityBoneChest();
    }
}
