package divinerpg.objects.blocks.tile.container.slot;

import divinerpg.objects.blocks.tile.entity.TileEntityModFurnace;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SlotModFurnaceFuel extends Slot {
    private final TileEntityModFurnace tileFurnace;

    public SlotModFurnaceFuel(TileEntityModFurnace tileFurnace, int slotIndex, int xPosition, int yPosition) {
        super(tileFurnace, slotIndex, xPosition, yPosition);
        this.tileFurnace = tileFurnace;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return tileFurnace.needsFuel() && tileFurnace.isItemValidForSlot(1, stack);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isEnabled() {
        return tileFurnace.needsFuel();
    }
}
