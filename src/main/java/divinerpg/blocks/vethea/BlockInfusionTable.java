package divinerpg.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockMod;
import divinerpg.client.containers.InfusionTableContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class BlockInfusionTable extends BlockMod {

    public BlockInfusionTable() {
        super(BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(-1, 3600000F));
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player instanceof ServerPlayer)
            InfusionTableContainer.openContainer((ServerPlayer)player, pos);

        return InteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        return new SimpleMenuProvider((i, inventory, player) -> {
            return new InfusionTableContainer(i, inventory, ContainerLevelAccess.create(level, pos));
        }, Component.translatable(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "infusion_table")).getDescriptionId()));
    }

}