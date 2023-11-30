package divinerpg.compat;

import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.items.wrapper.RecipeWrapper;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosCompat {

    public static boolean checkCuriosSlots(Player player) {
        return !CuriosApi.getCuriosHelper().getEquippedCurios(player).<Container>map(RecipeWrapper::new).orElseGet(() -> new SimpleContainer(0)).isEmpty();
    }
}
