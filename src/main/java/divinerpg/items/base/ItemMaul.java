package divinerpg.items.base;

import divinerpg.DivineRPG;
import divinerpg.recipe.MaulSmashingRecipe;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagManager;
import net.minecraft.world.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.*;
import net.neoforged.api.distmarker.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

import static net.minecraft.sounds.SoundEvents.ANVIL_LAND;
import static net.minecraft.sounds.SoundEvents.ITEM_BREAK;
import static net.minecraft.sounds.SoundSource.PLAYERS;

public class ItemMaul extends ItemModSword {
    private static final int COOLDOWN_TICKS = 10;

    public ItemMaul(Tier tier, Properties properties) {
        super(tier, properties);
    }

    public ItemMaul(Tier tier) {
        super(tier);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        if (itemStack.isDamageableItem()) {
            int damage = itemStack.getDamageValue() + 1;
            if (damage >= itemStack.getMaxDamage()) {
                return ItemStack.EMPTY;
            }
            itemStack.setDamageValue(damage);
        }
        return itemStack.copy();
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (level.isClientSide) return super.use(level, player, hand);

        double range = player.entityInteractionRange();
        Vec3 eyePos = player.getEyePosition();
        Vec3 lookVec = player.getViewVector(1);

        EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
                player, eyePos, eyePos.add(lookVec.scale(range)),
                player.getBoundingBox().expandTowards(lookVec.scale(range)).inflate(1.0D),
                e -> e instanceof ItemEntity, range * range
        );

        if (hitResult != null) {
            ItemEntity itemEntity = (ItemEntity) hitResult.getEntity();
            ItemStack targetStack = itemEntity.getItem();

            MaulSmashingRecipe matchingRecipe = findMatchingRecipe(level.getRecipeManager(), targetStack, level, itemEntity.blockPosition());

            if (matchingRecipe != null) {
                ItemStack resultStack = matchingRecipe.getResult();
                resultStack.setCount(resultStack.getCount() * targetStack.getCount());
                itemEntity.setItem(resultStack);
                applyMaulEffects(player, targetStack.getCount(), hand);
                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        }

        return super.use(level, player, hand);
    }

    private void applyMaulEffects(Player player, int count, InteractionHand hand) {
        ItemStack maulStack = player.getItemInHand(hand);
        if (player instanceof ServerPlayer s) {
            maulStack.hurtAndBreak(count, s.serverLevel(), s, (it) -> s.serverLevel().playSound(null, player.getX(), player.getEyeY(), player.getZ(), ITEM_BREAK, PLAYERS, 1, 1));
        }
        player.playSound(ANVIL_LAND, 0.7F, 1.5F);
        player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
        player.awardStat(Stats.ITEM_USED.get(this));
    }

    @Nullable
    private MaulSmashingRecipe findMatchingRecipe(RecipeManager recipeManager, ItemStack inputStack, Level level, BlockPos itemPos) {
        BlockPos baseBlockPos = itemPos.below();
        BlockState baseState = level.getBlockState(baseBlockPos);

        for (var holder : recipeManager.getAllRecipesFor(MaulSmashingRecipe.TYPE)) {
            if (!(holder.value() instanceof MaulSmashingRecipe recipe)) continue;

            if (!recipe.matches(inputStack)) continue;

            TagKey<Block> tag = recipe.getRequiredBaseBlockTag();
            if (tag == null) {
                return recipe;
            }

            MinecraftServer server = level.getServer();
            if (server == null) {
                continue;
            }

            Optional<HolderLookup.RegistryLookup<Block>> blockLookup = server.registryAccess().lookup(Registries.BLOCK);
            if (blockLookup.isEmpty()) {
                continue;
            }

            Optional<HolderSet.Named<Block>> tagBlocksOpt = blockLookup.get().get(tag);
            if (tagBlocksOpt.isEmpty()) {
                continue;
            }

            HolderSet<Block> tagBlocks = tagBlocksOpt.get();
            if (tagBlocks.contains(baseState.getBlock().builtInRegistryHolder())) {
                return recipe;
            }
        }

        return null;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(LocalizeUtils.i18n("maul_use"));
        super.appendHoverText(stack, context, tooltip, flag);
    }
}
