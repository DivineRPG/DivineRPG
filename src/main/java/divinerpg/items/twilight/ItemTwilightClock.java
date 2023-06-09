package divinerpg.items.twilight;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModPortal;
import divinerpg.items.base.ItemMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashSet;
import java.util.Set;

public class ItemTwilightClock extends ItemMod {
    private final Set<Block> possibleBlocks = new HashSet<Block>() {
        private static final long serialVersionUID = 1L; {
            add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_rock")));
            add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_block")));
            add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_block")));
            add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_block")));
            add(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_block")));
        }
    };

    public ItemTwilightClock() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        InteractionHand hand = context.getHand();
        BlockPos pos = context.getClickedPos();
        Direction facing = context.getClickedFace();
        ItemStack itemstack = player.getItemInHand(hand);
        Level worldIn = context.getLevel();
        RandomSource random = worldIn.random;

        if (!player.mayUseItemAt(pos, facing, itemstack)) {
            return InteractionResult.FAIL;
        }

        if (facing != Direction.UP) {
            return InteractionResult.FAIL;
        }

        BlockModPortal portalBlock;
        for (Direction direction : Direction.Plane.VERTICAL) {
            BlockPos framePos = context.getClickedPos().relative(direction);
            if (worldIn.getBlockState(framePos.below()) == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_rock")).defaultBlockState()) {
                portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_portal"));
                if (portalBlock.makePortal(context.getLevel(), framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                    return InteractionResult.SUCCESS;
                }
            }
            if (worldIn.getBlockState(framePos.below()) == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_block")).defaultBlockState()) {
                portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_portal"));
                if (portalBlock.makePortal(context.getLevel(), framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                    return InteractionResult.SUCCESS;
                }
            }
            if (worldIn.getBlockState(framePos.below()) == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_block")).defaultBlockState()) {
                portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_portal"));
                if (portalBlock.makePortal(context.getLevel(), framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                    return InteractionResult.SUCCESS;
                }
            }
            if (worldIn.getBlockState(framePos.below()) == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_block")).defaultBlockState()) {
                portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_portal"));
                if (portalBlock.makePortal(context.getLevel(), framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                    return InteractionResult.SUCCESS;
                }
            }
            if (worldIn.getBlockState(framePos.below()) == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_block")).defaultBlockState()) {
                portalBlock = (BlockModPortal) ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_portal"));
                if (portalBlock.makePortal(context.getLevel(), framePos)) {
                    worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                    return InteractionResult.SUCCESS;
                }
            }
            if (BaseFireBlock.canBePlacedAt(worldIn, pos.relative(facing), context.getHorizontalDirection()) && possibleBlocks.contains(worldIn.getBlockState(context.getClickedPos()).getBlock())) {
                worldIn.playSound(player, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, random.nextFloat() * 0.4F + 0.8F);
                worldIn.setBlock(context.getClickedPos().above(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_fire")).defaultBlockState(), 0);
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

}