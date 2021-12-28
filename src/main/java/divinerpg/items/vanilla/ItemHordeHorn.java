package divinerpg.items.vanilla;

import divinerpg.items.base.ItemBossSpawner;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.SoundRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemHordeHorn extends ItemBossSpawner {

    public ItemHordeHorn(String name) {
        super(name, "message.ayeraco_horde", World.END);
    }

    @Override
    public ActionResultType useOn(ItemUseContext context) {
        ActionResultType result = super.useOn(context);

            BlockPos pos = context.getClickedPos();
            Direction facing = context.getClickedFace();
            World world = context.getLevel();
            PlayerEntity player = context.getPlayer();
            pos = pos.offset(facing.getStepX(), facing.getStepY()+1, facing.getStepZ());
            if (world.getBlockState(pos) == Blocks.AIR.defaultBlockState()) {
            	if(world.dimension().equals(World.END)) {
                world.playSound(null, pos, SoundRegistry.AYERACO_SPAWN, SoundCategory.MASTER, 20.0F, 1.0F);
                world.setBlock(pos.below(), BlockRegistry.ayeracoSpawn.defaultBlockState(), 0);

                if (!player.isCreative()) {
                    player.getMainHandItem().shrink(1);
                }
            	}
            }
        return result;
    }
}