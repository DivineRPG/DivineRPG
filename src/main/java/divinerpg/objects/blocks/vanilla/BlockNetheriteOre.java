package divinerpg.objects.blocks.vanilla;

import java.util.Random;

import divinerpg.DivineRPG;
import divinerpg.enums.EnumBlockType;
import divinerpg.enums.OreType;
import divinerpg.objects.blocks.BlockMod;
import divinerpg.objects.blocks.BlockModOre;
import divinerpg.objects.blocks.itemblock.IMetaName;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.registry.ModBlocks;
import divinerpg.registry.ModItems;
import divinerpg.utils.IHasModel;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockNetheriteOre extends BlockModOre implements IHasModel, IMetaName {

    public BlockNetheriteOre(String name, float hardness, float resistance, int harvest, Item item) {
        super(name, hardness, resistance, harvest, item);
        setTickRandomly(true);
    }

    public void detectInBB(BlockPos pos, World world) {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        AxisAlignedBB extendBB = new AxisAlignedBB(x - 0.1, y - 0.1, z - 0.1, x + 1.1, y + 1.1, z + 1.1);
        world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB);
        for (EntityLivingBase entity : world.getEntitiesWithinAABB(EntityLivingBase.class, extendBB)) {
            if (entity instanceof EntityLivingBase) {
                entity.attackEntityFrom(DamageSource.GENERIC, 1);
            }
        }
        world.getEntitiesWithinAABB(EntityItem.class, extendBB);
        for (EntityItem entityItem : world.getEntitiesWithinAABB(EntityItem.class, extendBB)) {
            entityItem.attackEntityFrom(DamageSource.ON_FIRE, 10);
        }
    }

    @Override
    public String getSpecialName(ItemStack stack) {
        return OreType.values()[stack.getItemDamage()].getName();
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
        world.scheduleUpdate(pos, this, 5);
    }

    @Override
    public void registerModels() {
        for (int i = 0; i < OreType.values().length; i++) {
            DivineRPG.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i,
                    "netherite_ore_" + OreType.values()[i].getName(), "inventory");
        }
    }

    @Override
    public int tickRate(World worldIn) {
        return 5;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
        detectInBB(pos, world);
        world.scheduleUpdate(pos, this, 5);
    }
}