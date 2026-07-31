package divinerpg.items.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

import java.util.Objects;

public class ItemPetSpawnEgg extends SpawnEggItem {
    public ItemPetSpawnEgg(Properties properties) {super(properties);}
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
            EntityType<?> entitytype = getType(itemstack);
            if(entitytype.spawn((ServerLevel)level, itemstack, context.getPlayer(), blockpos1, EntitySpawnReason.SPAWN_ITEM_USE, true, !Objects.equals(blockpos, blockpos1) && direction == Direction.UP) != null) {
                itemstack.shrink(1);
                level.gameEvent(context.getPlayer(), GameEvent.ENTITY_PLACE, blockpos);
            } return InteractionResult.CONSUME;
        }
    }
}