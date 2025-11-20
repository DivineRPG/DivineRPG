package divinerpg.items.base;

import divinerpg.recipe.MaulSmashingRecipe;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
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
import net.neoforged.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.*;

import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.stats.Stats.ITEM_USED;
import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemMaul extends ItemModSword {
    private static final int COOLDOWN_TICKS = 10;
    public ItemMaul(Tier tier, Properties properties) {super(tier, properties);}
    public ItemMaul(Tier tier) {super(tier);}
    @Override public boolean hasCraftingRemainingItem(ItemStack stack) {return true;}
    @Override public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        if(itemStack.isDamageableItem()) {
            int damage = itemStack.getDamageValue() + 1;
            if(damage >= itemStack.getMaxDamage()) return ItemStack.EMPTY;
            itemStack.setDamageValue(damage);
        } return itemStack.copy();
    }
    @Override public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(level.isClientSide) return super.use(level, player, hand);
        double range = player.entityInteractionRange();
        Vec3 eyePos = player.getEyePosition(), lookVec = player.getViewVector(1);
        EntityHitResult hitResult = ProjectileUtil.getEntityHitResult(
                player, eyePos, eyePos.add(lookVec.scale(range)),
                player.getBoundingBox().expandTowards(lookVec.scale(range)).inflate(1),
                e -> e instanceof ItemEntity, range * range
        );
        if(hitResult != null) {
            ItemEntity itemEntity = (ItemEntity)hitResult.getEntity();
            ItemStack targetStack = itemEntity.getItem();
            MaulSmashingRecipe matchingRecipe = findMatchingRecipe(level.getRecipeManager(), targetStack, level, itemEntity.blockPosition());
            if(matchingRecipe != null) {
                ItemStack resultStack = matchingRecipe.getResult();
                ItemStack maulStack = player.getItemInHand(hand);
                int itemsToSmashCount;
                if(maulStack.has(DataComponents.UNBREAKABLE)) itemsToSmashCount = targetStack.getCount();
                else itemsToSmashCount = Math.min(targetStack.getCount(), maulStack.getMaxDamage() - maulStack.getDamageValue());
                resultStack.setCount(resultStack.getCount() * itemsToSmashCount);
                targetStack.shrink(itemsToSmashCount);
                ItemEntity convertedEntity = new ItemEntity(level, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), resultStack);
                level.addFreshEntity(convertedEntity);
                convertedEntity.setItem(resultStack);
                applyMaulEffects(player, itemsToSmashCount, hand);
                return InteractionResultHolder.success(player.getItemInHand(hand));
            }
        } return super.use(level, player, hand);
    }
    private void applyMaulEffects(Player player, int count, InteractionHand hand) {
        ItemStack maulStack = player.getItemInHand(hand);
        if(player instanceof ServerPlayer s) maulStack.hurtAndBreak(count, s.serverLevel(), s, (it) -> s.serverLevel().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.ITEM_BREAK, PLAYERS, 1, 1));
        player.level().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.ANVIL_LAND, PLAYERS, .7F, 1.5F);
        player.getCooldowns().addCooldown(this, COOLDOWN_TICKS);
        player.awardStat(ITEM_USED.get(this));
    }
    @Nullable
    private MaulSmashingRecipe findMatchingRecipe(RecipeManager recipeManager, ItemStack inputStack, Level level, BlockPos itemPos) {
        BlockState baseState = level.getBlockState(itemPos.below());
        for(var holder : recipeManager.getAllRecipesFor(MaulSmashingRecipe.TYPE)) {
            if(!(holder.value() instanceof MaulSmashingRecipe recipe)) continue;
            if(!recipe.matches(inputStack)) continue;
            TagKey<Block> tag = recipe.requiredBaseBlockTag();
            if(tag == null) return recipe;
            MinecraftServer server = level.getServer();
            if(server == null) continue;
            Optional<HolderLookup.RegistryLookup<Block>> blockLookup = server.registryAccess().lookup(Registries.BLOCK);
            if(blockLookup.isEmpty()) continue;
            Optional<HolderSet.Named<Block>> tagBlocksOpt = blockLookup.get().get(tag);
            if(tagBlocksOpt.isEmpty()) continue;
            if(baseState.is(tagBlocksOpt.get())) return recipe;
        } return null;
    }
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(LocalizeUtils.i18n("tool.maul_use"));
        super.appendHoverText(stack, context, tooltip, flag);
    }
}