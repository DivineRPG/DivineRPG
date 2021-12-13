package divinerpg.world.gen.piece;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.entities.iceika.*;
import divinerpg.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class IceikaHousePiece {
        private static final BlockPos STRUCTURE_OFFSET = new BlockPos(0, 0, 0);

    public static class Piece extends TemplateStructurePiece {
        private final Rotation rotation;
        private static List<ResourceLocation> locations = new ArrayList();

    public Piece(TemplateManager p_i48904_1_, BlockPos p_i48904_3_, Rotation p_i48904_4_) {
        super(StructureRegistry.Pieces.ICEIKA_HOUSE, 0);
        this.templatePosition = p_i48904_3_;
        this.rotation = p_i48904_4_;
        this.loadTemplate(p_i48904_1_);
    }

    public Piece(TemplateManager p_i50445_1_, CompoundNBT p_i50445_2_) {
        super(StructureRegistry.Pieces.ICEIKA_HOUSE, p_i50445_2_);
        this.rotation = Rotation.valueOf(p_i50445_2_.getString("Rot"));
        this.loadTemplate(p_i50445_1_);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT tagCompound) {
        super.addAdditionalSaveData(tagCompound);
        tagCompound.putString("Rot", this.rotation.name());
    }

    private void loadTemplate(TemplateManager manager) {
        Random rand = new Random();
        locations.addAll(ImmutableList.of(new ResourceLocation(DivineRPG.MODID, "iceika/houses/workshop_house_1"),
                new ResourceLocation(DivineRPG.MODID, "iceika/houses/workshop_house_2"),
                new ResourceLocation(DivineRPG.MODID, "iceika/houses/workshop_house_3"),
                new ResourceLocation(DivineRPG.MODID, "iceika/houses/workshop_house_4"),
                new ResourceLocation(DivineRPG.MODID, "iceika/houses/workshop_house_5"),
                new ResourceLocation(DivineRPG.MODID, "iceika/houses/workshop_house_6"),
                new ResourceLocation(DivineRPG.MODID, "iceika/lamps/coalstone_lamp_1"),
                new ResourceLocation(DivineRPG.MODID, "iceika/lamps/coalstone_lamp_2"),
                new ResourceLocation(DivineRPG.MODID, "iceika/lamps/coalstone_lamp_3"),
                new ResourceLocation(DivineRPG.MODID, "iceika/workshop_library")));
        Template template = manager.getOrCreate(locations.get(rand.nextInt(locations.size())));
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).setRotationPivot(IceikaHousePiece.STRUCTURE_OFFSET).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
        this.setup(template, this.templatePosition, placementsettings);
    }

    @Override
    protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
        if ("WorkshopHouse1Loot".equals(function)) {
            LockableLootTileEntity.setLootTable(worldIn, rand, pos.below(), new ResourceLocation(DivineRPG.MODID, "chests/iceika/iceika_chest_hut"));
        }
        if ("WorkshopMerchant".equals(function)) {
            EntityWorkshopMerchant merchant = new EntityWorkshopMerchant(EntityRegistry.WORKSHOP_MERCHANT, worldIn.getLevel());
            merchant.moveTo(pos, rand.nextInt(360), 0);
            worldIn.addFreshEntity(merchant);
        }
        if ("WorkshopTinkerer".equals(function)) {
            EntityWorkshopTinkerer tinkerer = new EntityWorkshopTinkerer(EntityRegistry.WORKSHOP_TINKERER, worldIn.getLevel());
            tinkerer.moveTo(pos, rand.nextInt(360), 0);
            worldIn.addFreshEntity(tinkerer);
        }
    }

    @Override
    public boolean postProcess(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random random, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        return super.postProcess(world, manager, generator, random, boundingBox, chunkPos, blockPos);
    }
}
}