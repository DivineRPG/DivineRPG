package divinerpg.structure.base;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
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
    public boolean addComponentParts(World worldIn, Random randomIn, StructureBoundingBox structureBoundingBoxIn) {
        //Rotation[] rotations = Rotation.values();
        //this.placeSettings.setRotation(rotations[randomIn.nextInt(rotations.length)]);
        return super.addComponentParts(worldIn, randomIn, structureBoundingBoxIn);
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

}
