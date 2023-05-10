package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import divinerpg.enums.BlockColor;
import divinerpg.block_entities.bosses.StatueBlockEntity;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockStatue extends BlockMod implements EntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final EnumProperty<BlockColor> COLOR = BlockColor.COLOR;
    private Supplier<SoundEvent> statueSound;
    public BlockStatue(Supplier<SoundEvent> soundIn) {
        super(BlockBehaviour.Properties.of(Material.STONE).strength(6.0F, 6.0F).noOcclusion().requiresCorrectToolForDrops());
        registerDefaultState(stateDefinition.any().setValue(COLOR, BlockColor.WHITE));
        statueSound = soundIn;
    }
    @Override
    public boolean skipRendering(BlockState p_200122_1_, BlockState p_200122_2_, Direction p_200122_3_) {
        return true;
    }
    @Override @Nullable
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new StatueBlockEntity(p_153215_, p_153216_);
    }
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(COLOR);
    }
    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack stack) {
        world.setBlock(pos, state.setValue(FACING, player.getDirection().getOpposite()), 2);
    }
    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
    	if(state.is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")))) {
        	ItemStack item = player.getItemInHand(hand);
        	colorTest:
        	if(item != null) {
        		BlockColor color = state.getValue(COLOR);
        		if(item.is(Items.BLUE_DYE) && color != BlockColor.BLUE) color = BlockColor.BLUE;
        		else if(item.is(Items.GREEN_DYE) && color != BlockColor.GREEN) color = BlockColor.GREEN;
        		else if(item.is(Items.PINK_DYE) && color != BlockColor.PINK) color = BlockColor.PINK;
        		else if(item.is(Items.PURPLE_DYE) && color != BlockColor.PURPLE) color = BlockColor.PURPLE;
        		else if(item.is(Items.RED_DYE) && color != BlockColor.RED) color = BlockColor.RED;
        		else if(item.is(Items.YELLOW_DYE) && color != BlockColor.YELLOW) color = BlockColor.YELLOW;
        		else if(item.is(Items.WHITE_DYE) && color != BlockColor.WHITE) color = BlockColor.WHITE;
        		else break colorTest;
        		if(!player.isCreative()) item.shrink(1);
        		player.setItemInHand(hand, item);
        		world.setBlock(pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")).defaultBlockState().setValue(COLOR, color).setValue(FACING, state.getValue(FACING)), 3);
        		return InteractionResult.CONSUME;
        	}
    	}
    	if(!player.isCrouching() && statueSound != null) {
    		world.playSound(null, pos, statueSound.get(), SoundSource.BLOCKS, 3.0F, 1.0F);
    		return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }
    @Override
    @Deprecated
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));
    }
    @Override
    @Deprecated
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
    public static final VoxelShape
    	WATCHER_AABB = Shapes.create(new AABB(0.3F, 0.0F, 0.3F, 0.7F, 0.5F, 0.7F)),
    	AYERACO_AABB = Shapes.create(new AABB(0.2F, 0.0F, 0.20F, 0.8F, 0.4F, 0.8F)),
    	TWILIGHT_DEMON_AABB = Shapes.create(new AABB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F)),
    	VAMACHERON_AABB = Shapes.create(new AABB(0.2F, 0.0F, 0.20F, 0.8F, 0.7F, 0.8F)),
    	PARASECTA_AABB = Shapes.create(new AABB(0.2F, 0.2F, 0.20F, 0.8F, 1.0F, 0.8F)),
    	SOUL_FIEND_AABB = Shapes.create(new AABB(0.2F, 0.0F, 0.20F, 0.8F, 1.0F, 0.8F));
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter source, BlockPos pos, CollisionContext context) {
        Block block = state.getBlock();
        if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "ayeraco_statue")).equals(block)) return AYERACO_AABB;
        if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "the_watcher_statue")).equals(block)) return WATCHER_AABB;
        if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "twilight_demon_statue")).equals(block)) return TWILIGHT_DEMON_AABB;
        if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "vamacheron_statue")).equals(block)) return VAMACHERON_AABB;
        if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_statue")).equals(block)) return PARASECTA_AABB;
        if(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "soul_fiend_statue")).equals(block)) return SOUL_FIEND_AABB;
        return Shapes.block();
    }
}