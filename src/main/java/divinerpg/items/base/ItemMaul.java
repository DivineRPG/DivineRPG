package divinerpg.items.base;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.function.Consumer;

import static net.minecraft.sounds.SoundSource.PLAYERS;
import static net.minecraft.stats.Stats.ITEM_USED;

public class ItemMaul extends ItemMod {
    private static final int COOLDOWN_TICKS = 10;
    public ItemMaul(ToolMaterial material, Properties properties) {super(properties.sword(material, 3.0F, -2.4F));}

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(level.isClientSide()) return super.use(level, player, hand);
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
//            MaulSmashingRecipe matchingRecipe = findMatchingRecipe(level.getRecipeManager(), targetStack, level, itemEntity.blockPosition());
//            if(matchingRecipe != null) {
//                ItemStack resultStack = matchingRecipe.getResult();
//                ItemStack maulStack = player.getItemInHand(hand);
//                int itemsToSmashCount;
//                if(maulStack.has(DataComponents.UNBREAKABLE)) itemsToSmashCount = targetStack.getCount();
//                else itemsToSmashCount = Math.min(targetStack.getCount(), maulStack.getMaxDamage() - maulStack.getDamageValue());
//                resultStack.setCount(resultStack.getCount() * itemsToSmashCount);
//                targetStack.shrink(itemsToSmashCount);
//                ItemEntity convertedEntity = new ItemEntity(level, itemEntity.getX(), itemEntity.getY(), itemEntity.getZ(), resultStack);
//                level.addFreshEntity(convertedEntity);
//                convertedEntity.setItem(resultStack);
//                applyMaulEffects(player, itemsToSmashCount, hand);
//                return InteractionResult.SUCCESS;
//            }
        } return super.use(level, player, hand);
    }
    private void applyMaulEffects(Player player, int count, InteractionHand hand) {
        ItemStack maulStack = player.getItemInHand(hand);
        if(player instanceof ServerPlayer s) maulStack.hurtAndBreak(count, s.level(), s, (it) -> s.level().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.ITEM_BREAK, PLAYERS, 1, 1));
        player.level().playSound(null, player.getX(), player.getEyeY(), player.getZ(), SoundEvents.ANVIL_LAND, PLAYERS, .7F, 1.5F);
        player.getCooldowns().addCooldown(maulStack, COOLDOWN_TICKS);
        player.awardStat(ITEM_USED.get(this));
    }
    //TODO - maul recipe
//    @Nullable
//    private MaulSmashingRecipe findMatchingRecipe(RecipeManager recipeManager, ItemStack inputStack, Level level, BlockPos itemPos) {
//        BlockState baseState = level.getBlockState(itemPos.below());
//        for(var holder : recipeManager.getAllRecipesFor(MaulSmashingRecipe.TYPE)) {
//            if(!(holder.value() instanceof MaulSmashingRecipe recipe)) continue;
//            if(!recipe.matches(inputStack)) continue;
//            TagKey<Block> tag = recipe.requiredBaseBlockTag();
//            if(tag == null) return recipe;
//            MinecraftServer server = level.getServer();
//            if(server == null) continue;
//            Optional<HolderLookup.RegistryLookup<Block>> blockLookup = server.registryAccess().lookup(Registries.BLOCK);
//            if(blockLookup.isEmpty()) continue;
//            Optional<HolderSet.Named<Block>> tagBlocksOpt = blockLookup.get().get(tag);
//            if(tagBlocksOpt.isEmpty()) continue;
//            if(baseState.is(tagBlocksOpt.get())) return recipe;
//        } return null;
//    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.i18n("tool.maul_use"));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }

}
