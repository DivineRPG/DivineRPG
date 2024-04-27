package divinerpg.items.base;

import divinerpg.registries.LevelRegistry;
import divinerpg.util.RarityList;
import net.minecraft.ChatFormatting;
import net.minecraft.core.*;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.server.command.TextComponentHelper;
import java.util.function.Supplier;

public class ItemBossSpawner extends ItemMod {
    private final Supplier<EntityType<?>> ent;
    private final String langKey;
    private ResourceKey<Level> dimensionID;
    public ItemBossSpawner(String key, ResourceKey<Level> dimension, Supplier<EntityType<?>> entity) {
        super(new Item.Properties().stacksTo(1).rarity(RarityList.RED));
        dimensionID = dimension;
        ent = entity;
        langKey = key;
    }
    public ItemBossSpawner(String key, ResourceKey<Level> dimension) {
    	super(new Item.Properties().stacksTo(1).rarity(RarityList.RED));
    	dimensionID = dimension;
    	langKey = key;
    	ent = null;
	}
	@Override public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Direction direction = context.getClickedFace();
        BlockPos pos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(pos);
        BlockPos pos1;
        if(blockstate.getCollisionShape(world, pos).isEmpty()) pos1 = pos;
        else pos1 = pos.relative(direction);
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        if(dimensionID == null) dimensionID = LevelRegistry.MORTUM;
        if(world.dimension() != dimensionID) {
            MutableComponent message = TextComponentHelper.createComponentTranslation(player, langKey);
            message.withStyle(ChatFormatting.AQUA);
            player.displayClientMessage(message, true);
            return InteractionResult.FAIL;
        } else if(world.getDifficulty() == Difficulty.PEACEFUL) {
            player.displayClientMessage(Component.translatable("message.spawner.peaceful"), true);
            return InteractionResult.FAIL;
        } else {
        	if(!world.isClientSide && ent != null) ent.get().spawn((ServerLevel) world, player.getItemInHand(hand), player, pos1, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) player.getItemInHand(hand).shrink(1);
            return InteractionResult.SUCCESS;
        }
    }
}