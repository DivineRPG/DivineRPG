package divinerpg.items.arcana;

import divinerpg.DivineRPG;
import divinerpg.items.base.ItemMod;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.*;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemWizardsBook extends ItemMod {
    public ItemWizardsBook() {super(new Properties().stacksTo(1));}
    @Override public InteractionResult useOn(UseOnContext context) {
        BlockPos pos = context.getClickedPos();
        InteractionHand hand = context.getHand();
        Level level = context.getLevel();
        Block block = level.getBlockState(pos).getBlock();
        Player player = context.getPlayer();
        ItemStack stack = player.getItemInHand(hand);
        Item item = stack.getItem();
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_altar"))) {
            if(!level.isClientSide) EntityRegistry.PARASECTA.get().spawn((ServerLevel) level, ItemStack.EMPTY, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) stack.shrink(1);
            player.getCooldowns().addCooldown(item, 40);
            return InteractionResult.SUCCESS;
        }
        if(block == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "dramix_altar"))) {
            if(!level.isClientSide) EntityRegistry.DRAMIX.get().spawn((ServerLevel) level, ItemStack.EMPTY, player, pos, MobSpawnType.MOB_SUMMONED, true, false);
            if(!player.isCreative()) stack.shrink(1);
            player.getCooldowns().addCooldown(item, 40);
            return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }
}