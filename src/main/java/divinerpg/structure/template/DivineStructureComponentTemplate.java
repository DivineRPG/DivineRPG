package divinerpg.structure.template;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vethea.EntityCryptKeeper;
import divinerpg.objects.entities.entity.vethea.EntityTempleGuardian;
import divinerpg.objects.entities.entity.vethea.EntityTheHunger;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.entity.EntityLiving;
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

public class DivineStructureComponentTemplate extends StructureComponentTemplate {

    private static PlacementSettings DEFAULT_PLACEMENT_SETTINGS = new PlacementSettings(); //need to figure out structure block
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

    @Override
    protected void handleDataMarker(String function, BlockPos pos, World worldIn, Random rand, StructureBoundingBox sbb) {
        switch (function) {
            case "TheHunger":
                spawnPersistentEntity(worldIn, pos, new EntityTheHunger(worldIn));
                break;
            case "CryptLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.CRYPT_LOOT);
                break;
            case "CryptKeeper":
                spawnPersistentEntity(worldIn, pos, new EntityCryptKeeper(worldIn));
                break;
            case "TempleLootBottom":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_BOTTOM);
                break;
            case "TempleLootMiddle":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_MIDDLE);
                break;
            case "TempleLootTop":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.TEMPLE_LOOT_TOP);
                break;
            case "TempleGuardian":
                spawnPersistentEntity(worldIn, pos, new EntityTempleGuardian(worldIn));
                break;
            case "QuadroticPostLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.QUADROTIC_POST_LOOT);
                break;
            case "KarosMadhouseLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.KAROS_MADHOUSE_LOOT);
                break;
            case "RaglokChamberLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.RAGLOK_CHAMBER_LOOT);
                break;
            case "WreckHallLoot":
                populateLootChestBelow(worldIn, pos, rand, LootTableRegistry.WRECK_HALL_LOOT);
                break;
            default:
                DivineRPG.logger.warn("Unknown data marker: " + function + ", please report this.");
                break;
        }
    }

    private void spawnPersistentEntity(World world, BlockPos pos, EntityLiving entity) {
        entity.enablePersistence();
        entity.moveToBlockPosAndAngles(pos, 0.0F, 0.0F);
        world.spawnEntity(entity);
    }

    private void populateLootChestBelow(World world, BlockPos pos, Random rand, ResourceLocation lootTable) {
        BlockPos chestPosition = pos.down();
        TileEntity tileEntity = world.getTileEntity(chestPosition);
        if(tileEntity instanceof TileEntityChest) {
            ((TileEntityChest)tileEntity).setLootTable(lootTable, rand.nextLong());
        }
    }
}
