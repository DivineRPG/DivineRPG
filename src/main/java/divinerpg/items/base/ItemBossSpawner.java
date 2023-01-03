package divinerpg.items.base;

import divinerpg.registries.LevelRegistry;
import divinerpg.util.RarityList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
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
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if (!world.isClientSide) {
            if (dimensionID == null) {
                dimensionID = LevelRegistry.MORTUM;
            }
            if (world.dimension() != dimensionID) {
                MutableComponent message = TextComponentHelper.createComponentTranslation(player, langKey);
                message.withStyle(ChatFormatting.AQUA);
                player.displayClientMessage(message, true);
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            } else if (world.getDifficulty() == Difficulty.PEACEFUL) {
                player.displayClientMessage(Component.translatable("message.spawner.peaceful"), true);
                return InteractionResultHolder.fail(player.getItemInHand(hand));
            } else {
                for (Supplier<EntityType<?>> entType : ents) {
                    entType.get().spawn((ServerLevel) world, player.getItemInHand(hand), player, player.blockPosition().above(), MobSpawnType.MOB_SUMMONED, true, false);
                    if (!player.isCreative()) {
                        player.getItemInHand(hand).shrink(1);
                    }
                }
                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        }

        return InteractionResultHolder.fail(player.getItemInHand(hand));
    }
}