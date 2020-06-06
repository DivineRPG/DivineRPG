package divinerpg.structure.base;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityCryptKeeper;
import divinerpg.objects.entities.entity.vethea.EntityTempleGuardian;
import divinerpg.objects.entities.entity.vethea.EntityTheHunger;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponentTemplate;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

public abstract class DivineStructureComponentTemplate extends StructureComponentTemplate {

    private static PlacementSettings DEFAULT_PLACEMENT_SETTINGS = new PlacementSettings().setIgnoreEntities(true).setReplacedBlock(Blocks.AIR);
    private ResourceLocation location;

    /**
     * NBT ctor
     */
    public DivineStructureComponentTemplate() {
        this.placeSettings = DEFAULT_PLACEMENT_SETTINGS;
    }

    public DivineStructureComponentTemplate(TemplateManager manager, ResourceLocation location, BlockPos start) {
        this(manager, location, start, DEFAULT_PLACEMENT_SETTINGS);
    }

    public DivineStructureComponentTemplate(TemplateManager manager, ResourceLocation location, BlockPos start, PlacementSettings settings) {
        super(0);
        this.location = location;
        Template template = manager.getTemplate(null, location);
        this.setup(template, start, settings);
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound tagCompound, TemplateManager manager) {
        super.readStructureFromNBT(tagCompound, manager);

        location = new ResourceLocation(tagCompound.getString("TmpRes"));
        setup(manager.getTemplate(null, location), templatePosition, placeSettings);
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound tagCompound) {
        super.writeStructureToNBT(tagCompound);
        tagCompound.setString("TmpRes", location.toString());
    }

    protected void spawnPersistentEntity(World world, BlockPos pos, EntityLiving entity) {
        entity.enablePersistence();
        entity.moveToBlockPosAndAngles(pos, 0.0F, 0.0F);
        world.spawnEntity(entity);
    }

    protected void populateLootChestBelow(World world, BlockPos pos, Random rand, ResourceLocation lootTable) {
        BlockPos chestPosition = pos.down();
        TileEntity tileEntity = world.getTileEntity(chestPosition);
        if(tileEntity instanceof TileEntityChest) {
            ((TileEntityChest)tileEntity).setLootTable(lootTable, rand.nextLong());
        }
    }
}
