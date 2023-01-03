package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import divinerpg.tiles.chests.*;
import net.minecraft.core.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import javax.annotation.*;

public class BlockBoneChest extends BlockModChest {

    public BlockBoneChest() {
        super(Properties.of(Material.STONE).noOcclusion().sound(SoundType.STONE).strength(2.5F), () -> BlockEntityRegistry.BONE_CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new TileEntityBoneChest(p_153215_, p_153216_);
    }
}
