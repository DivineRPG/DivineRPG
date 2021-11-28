package divinerpg.blocks.base;

import divinerpg.registries.*;
import divinerpg.tiles.spawner.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;
import java.util.function.*;

public class BlockSingleUseSpawner extends BlockMod implements ITileEntityProvider {
    private final EntityType entityClass;
    private final int delay;
    private String name;
    private int nearDistance;
    private BlockPos spawnOffset;

    protected Supplier<Item> activationItemSupplier;

    /**
     * @param name         - name of block
     * @param entityClass  - entity to spwan class
     * @param delay        - possible delay. Pass zero to remove
     * @param nearDistance - auto spawn when player is within distance. Pass zero to disable
     */
    public BlockSingleUseSpawner(String name, EntityType entityClass, Supplier<Item> activationItemSupplier, int delay, int nearDistance) {
        this(name, entityClass, activationItemSupplier, delay, nearDistance, BlockPos.ZERO);
    }

    /**
     * @param name         - name of block
     * @param entityClass  - entity to spwan class
     * @param delay        - possible delay. Pass zero to remove
     * @param nearDistance - auto spawn when player is within distance. Pass zero to disable
     * @param spawnOffset  - initial spawn offset for entity position
     */
    public BlockSingleUseSpawner(String name, EntityType entityClass, Supplier<Item> activationItemSupplier, int delay, int nearDistance, BlockPos spawnOffset) {
        super(name, Block.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().strength(1, 3.0F).sound(SoundType.STONE).noOcclusion());
        this.entityClass = entityClass;
        this.activationItemSupplier = activationItemSupplier;
        this.delay = delay;
        this.name = name;
        this.nearDistance = nearDistance;
        this.spawnOffset = spawnOffset;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult rayTraceResult) {

        ItemStack heldItem = player.getMainHandItem();
        Item activationItem = activationItemSupplier.get();

        if (heldItem.getItem() != activationItem && activationItem != null) {
            if (!world.isClientSide && hand == Hand.MAIN_HAND)
                player.sendMessage(new TranslationTextComponent("message.spawner.item", String.format("%s", activationItem.getDescriptionId())), player.getUUID());

            return ActionResultType.FAIL;
        }

        if (world.getDifficulty() == Difficulty.PEACEFUL) {
            if (!world.isClientSide && hand == Hand.MAIN_HAND)
                player.sendMessage(new TranslationTextComponent("message.spawner.peaceful"), player.getUUID());

            return ActionResultType.FAIL;
        }

        TileEntity spawnerTile = world.getBlockEntity(pos);

        if (spawnerTile instanceof TileEntitySingleUseSpawner) {
            if (!world.isClientSide && hand == Hand.MAIN_HAND) {
                ((TileEntitySingleUseSpawner) spawnerTile).activate(player);

                if (!player.isCreative())
                    heldItem.shrink(1);
            }
        }
        return ActionResultType.PASS;
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);

        TileEntity tileEntity = worldIn.getBlockEntity(pos);
        if (!(tileEntity instanceof TileEntitySingleUseSpawner) || !((TileEntitySingleUseSpawner) tileEntity).isActivated())
            return;

        worldIn.addParticle(ParticleRegistry.BLACK_FLAME.get(),
                pos.getY() + Math.random() - Math.random(),
                pos.getY() + Math.random(),
                pos.getZ() + Math.random() - Math.random(),
                Math.random(),
                Math.random(),
                Math.random());
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader reader) {
        return new TileEntitySingleUseSpawner(entityClass, delay, nearDistance, spawnOffset);
    }

    public VoxelShape getVisualShape(BlockState p_230322_1_, IBlockReader p_230322_2_, BlockPos p_230322_3_, ISelectionContext p_230322_4_) {
        return VoxelShapes.empty();
    }
    public boolean propagatesSkylightDown(BlockState p_200123_1_, IBlockReader p_200123_2_, BlockPos p_200123_3_) {
        return true;
    }

    public BlockRenderType getRenderShape(BlockState p_149645_1_) {
        return BlockRenderType.MODEL;
    }

}