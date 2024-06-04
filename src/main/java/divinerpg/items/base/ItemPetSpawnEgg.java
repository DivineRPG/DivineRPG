package divinerpg.items.base;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import java.util.Objects;
import java.util.function.Supplier;

public class ItemPetSpawnEgg extends ForgeSpawnEggItem {
    public ItemPetSpawnEgg(Supplier<? extends EntityType<? extends Mob>> type) {super(type, 0xffffff, 0xffffff, new Properties());}
    @Override public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if(!(level instanceof ServerLevel)) return InteractionResult.SUCCESS;
        else {
            ItemStack itemstack = context.getItemInHand();
            BlockPos blockpos = context.getClickedPos();
            Direction direction = context.getClickedFace();
            BlockState blockstate = level.getBlockState(blockpos);
            BlockPos blockpos1;
            if(blockstate.getCollisionShape(level, blockpos).isEmpty()) blockpos1 = blockpos;
            else blockpos1 = blockpos.relative(direction);
            EntityType<?> entitytype = getType(itemstack.getTag());
            if(entitytype.spawn((ServerLevel)level, itemstack, context.getPlayer(), blockpos1, MobSpawnType.SPAWN_EGG, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                itemstack.shrink(1);
                level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            } return InteractionResult.CONSUME;
        }
    }
}