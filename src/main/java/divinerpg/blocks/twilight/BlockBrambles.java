package divinerpg.blocks.twilight;

import divinerpg.blocks.base.BlockModDoublePlant;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import static net.neoforged.neoforge.common.Tags.Items.TOOLS;

public class BlockBrambles extends BlockModDoublePlant {
    public BlockBrambles(Properties properties) {super(properties);}

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if(entity instanceof Player) entity.hurt(level.damageSources().cactus(), 6);
    }

    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
        if(!destroyedWith.is(TOOLS)) player.hurt(level.damageSources().cactus(), 1);
    }
}