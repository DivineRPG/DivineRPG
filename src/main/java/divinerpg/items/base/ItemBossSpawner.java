package divinerpg.items.base;

import divinerpg.registries.LevelRegistry;
import divinerpg.util.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import java.util.function.Supplier;

public class ItemBossSpawner extends ItemMod {
    private final Supplier<EntityType<?>> ent;
    private final String langKey;
    public ResourceKey<Level> dimensionID;
    public ItemBossSpawner(String key, ResourceKey<Level> dimension, Supplier<EntityType<?>> entity) {
        super(new Properties().stacksTo(1).rarity(RarityList.RED));
        dimensionID = dimension;
        ent = entity;
        langKey = key;
    }
    public ItemBossSpawner(String key, ResourceKey<Level> dimension) {
    	super(new Properties().stacksTo(1).rarity(RarityList.RED));
    	dimensionID = dimension;
    	langKey = key;
    	ent = null;
	}
	@Override public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos(), pos1;
        if(world.getBlockState(pos).getCollisionShape(world, pos).isEmpty()) pos1 = pos;
        else pos1 = pos.relative(context.getClickedFace());
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        if(dimensionID == null) dimensionID = LevelRegistry.MORTUM;
        if(world.dimension() != dimensionID) {
            player.displayClientMessage(LocalizeUtils.clientMessage(ChatFormatting.AQUA, langKey), true);
            return InteractionResult.FAIL;
        } else if(world.getDifficulty() == Difficulty.PEACEFUL) {
            player.displayClientMessage(LocalizeUtils.clientMessage(ChatFormatting.AQUA, "boss.peaceful"), true);
            return InteractionResult.FAIL;
        } else {
        	if(!world.isClientSide && ent != null) ent.get().spawn((ServerLevel) world, player.getItemInHand(hand), player, pos1, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
            player.getCooldowns().addCooldown(this, 40);
            return InteractionResult.SUCCESS;
        }
    }
}