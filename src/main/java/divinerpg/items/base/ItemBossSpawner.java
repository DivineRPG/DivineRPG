package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static divinerpg.registries.LevelRegistry.MORTUM;
import static divinerpg.util.RarityList.RED;
import static net.minecraft.ChatFormatting.AQUA;
import static net.minecraft.world.Difficulty.PEACEFUL;
import static net.minecraft.world.entity.MobSpawnType.MOB_SUMMONED;

public class ItemBossSpawner extends ItemMod {
    private final Supplier<EntityType<?>> ent;
    private final String langKey;
    public ResourceKey<Level> dimensionID;
    public ItemBossSpawner(String key, ResourceKey<Level> dimension, Supplier<EntityType<?>> entity) {
        super(new Properties().stacksTo(1));
        dimensionID = dimension;
        ent = entity;
        langKey = key;
        this.nameColor = RED;
    }
    public ItemBossSpawner(String key, ResourceKey<Level> dimension) {
    	super(new Properties().stacksTo(1));
    	dimensionID = dimension;
    	langKey = key;
    	ent = null;
        this.nameColor = RED;
	}
	@Override public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos(), pos1;
        if(world.getBlockState(pos).getCollisionShape(world, pos).isEmpty()) pos1 = pos;
        else pos1 = pos.relative(context.getClickedFace());
        Player player = context.getPlayer();
        if(dimensionID == null) dimensionID = MORTUM;
        if(world.dimension() != dimensionID) {
            player.displayClientMessage(LocalizeUtils.clientMessage(AQUA, langKey), true);
            return InteractionResult.FAIL;
        } else if(world.getDifficulty() == PEACEFUL) {
            player.displayClientMessage(LocalizeUtils.clientMessage(AQUA, "boss.peaceful"), true);
            return InteractionResult.FAIL;
        } else if(ent != null && !world.getBlockStates(ent.get().getSpawnAABB(pos.getX() + .5, pos.getY() + 2.14, pos.getZ() + .5).inflate(1)).allMatch(BlockBehaviour.BlockStateBase::isAir)) {
            player.displayClientMessage(LocalizeUtils.clientMessage(AQUA, "boss.space"), true);
            return InteractionResult.FAIL;
        } else {
            ItemStack stack = player.getItemInHand(context.getHand());
            if(!world.isClientSide && ent != null) ent.get().spawn((ServerLevel) world, stack, player, pos1, MOB_SUMMONED, true, false);
            stack.consume(1, player);
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResult.SUCCESS;
        }
    }
}