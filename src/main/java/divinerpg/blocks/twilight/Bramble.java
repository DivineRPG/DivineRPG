package divinerpg.blocks.twilight;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import static net.neoforged.neoforge.common.Tags.Items.TOOLS;

public class Bramble extends DoublePlantBlock {
    public Bramble(Properties p) {super(p);}

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if(entity instanceof Player) entity.hurt(level.damageSources().cactus(), 6);
    }

    @Override
    public void playerDestroy(ServerLevel worldIn, ServerPlayer player, BlockPos pos, BlockState state, @org.jspecify.annotations.Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        super.playerDestroy(worldIn, player, pos, state, blockEntity, destroyedWith);
        if(!destroyedWith.is(TOOLS)) player.hurt(worldIn.damageSources().cactus(), 1);
    }
}