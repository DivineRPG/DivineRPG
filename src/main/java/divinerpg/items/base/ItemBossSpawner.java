package divinerpg.items.base;

import divinerpg.registries.LevelRegistry;
import divinerpg.util.RarityList;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.function.Supplier;

public class ItemBossSpawner extends ItemMod {
    private final Supplier<EntityType<?>>[] ents;
    private final String langKey;
    private ResourceKey<Level> dimensionID;

    public ItemBossSpawner(String langKey, ResourceKey<Level> dimensionID, Supplier<EntityType<?>>... ents) {
        super(new Item.Properties().stacksTo(1).rarity(RarityList.BOSS));
        this.dimensionID = dimensionID;
        this.ents = ents;
        this.langKey = langKey;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        Direction direction = context.getClickedFace();
        BlockPos pos = context.getClickedPos();
        BlockState blockstate = world.getBlockState(pos);
        BlockPos pos1;
        if (blockstate.getCollisionShape(world, pos).isEmpty()) {
            pos1 = pos;
        } else {
            pos1 = pos.relative(direction);
        }
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        if (dimensionID == null) {
            dimensionID = LevelRegistry.MORTUM;
        }
        if (world.dimension() != dimensionID) {
            MutableComponent message = TextComponentHelper.createComponentTranslation(player, langKey);
            message.withStyle(ChatFormatting.AQUA);
            player.displayClientMessage(message, true);
            return InteractionResult.FAIL;
        } else if (world.getDifficulty() == Difficulty.PEACEFUL) {
            player.displayClientMessage(Component.translatable("message.spawner.peaceful"), true);
            return InteractionResult.FAIL;
        } else {
            for (Supplier<EntityType<?>> entType : ents) {
                if (!world.isClientSide) {
                    entType.get().spawn((ServerLevel) world, player.getItemInHand(hand), player, pos1, MobSpawnType.MOB_SUMMONED, true, false);
                }
                if (!player.isCreative()) {
                    player.getItemInHand(hand).shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}